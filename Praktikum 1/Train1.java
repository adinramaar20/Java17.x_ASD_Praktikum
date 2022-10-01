package praktikum;

import java.util.Scanner;

public class Train1 {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
	LinkedList<String> listNode = new LinkedList<String>();
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
            } else {
                String kataAkhir = listNode.toString();
                for (int j = 0; j < kataAkhir.length(); j++) {
                    if (kataAkhir.charAt(j) == ' '){
                        gerbong += "-";
                    } else {
                        gerbong += kataAkhir.charAt(j);
                    }
                }
                System.out.println(gerbong);
                gerbong = "";
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
        return size == 0;
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
	
	public T getFirst() {
		return this.head.data;
    }

	public T getLast() {
		return this.tail.data;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<T> temp = this.head;
        while (temp != null) {
            s.append(temp.data);
            if (temp.next != null) s.append("-");
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
