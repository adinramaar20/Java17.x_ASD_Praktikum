package praktikum;

import java.util.Scanner;

public class Train2 {
    static Scanner in = new Scanner(System.in);
    static LinkedList<String> listNode = new LinkedList<String>();

    private static void showLokomotif(String gerbong) {
        String kataAkhir = listNode.toString();
        for (int j = 0; j < kataAkhir.length(); j++) {
            if (kataAkhir.charAt(j) == ' '){
                gerbong += "-";
            } else {
                gerbong += kataAkhir.charAt(j);
            }
        }
        if (listNode.isEmpty()) {
            // nothing
        } else {
            System.out.println("<-" + gerbong);
        }
        gerbong = "";
    }

    public static void main(String[] args) {

        int count = in.nextInt();
        in.nextLine();
        String kata, gerbong = "";
        String[] train;

        for (int i=0; i<count; i++) {
            kata = in.nextLine();
            train = kata.split(" ");

            if (train[0].equals("TAMBAH") && train[2].equals("AWAL")){
                listNode.addFirst(train[1]);
            } else if (train[0].equals("TAMBAH") && train[2].equals("AKHIR")){
                listNode.addLast(train[1]);
            } else if (train[0].equals("LEPAS") && train[1].equals("AWAL")){
                if (listNode.isEmpty()){
                    // nothing
                } else {
                    listNode.removeFirst();
                }
            } else if (train[0].equals("LEPAS") && train[1].equals("AKHIR")){
                if (listNode.isEmpty()){
                    // nothing
                } else {
                    listNode.removeLast();
                }
            } else {
                if (listNode.isEmpty()){
                    System.out.println("<");
                }
                showLokomotif(gerbong);
            }
        }

    }
}

class LinkedList<T> {
    private Node<T> head, tail;
    private int size = 0;

    public LinkedList() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            this.head = this.tail = node;
        }
        else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            this.head = this.tail = node;
        }
        else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (this.head == this.tail) {
                this.head = this.tail = null;
            }
            else {
                Node<T> temp = this.head;
                this.head = null;
                this.head = temp.next;
            }
            this.size--;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (this.head == this.tail) {
                this.head = this.tail = null;
            }
            else {
                Node<T> temp = this.head;
                while (temp.next != this.tail) temp = temp.next;
                this.tail = temp;
                this.tail.next = null;
            }
            this.size--;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public T getFirst() {
        return this.head.data;
    }

    public T getLast() {
        return this.tail.data;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        Node<T> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            s.append(temp.data);
            if (temp.next != null) s.append(" ");
            temp = temp.next;
        }
        return s.toString();
    }
}

class Node<T> {
    public T data;
    public Node<T> next;

    public Node() {
        this(null);
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
