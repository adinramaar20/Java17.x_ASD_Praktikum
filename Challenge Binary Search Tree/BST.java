import java.util.ArrayList;
import java.util.List;

public class BST<T> implements IBST<T> {
  Node<T> root;

  public BST(Node<T> root) {
    this.root = root;
  }

  // jika root kosong
  public boolean isEmpty() {
    return this.root == null;
  }

  @Override
  public String toString() {
    return preOrder(this.root);
  }

  public String preOrder(Node<T> n) {
    if (n == null) return "";
    String out = String.format("%s;\n", n.data.toString());
    out += preOrder(n.lt);
    out += preOrder(n.rt);
    return out;
  }

  // hitung degree dari suatu node  
  @Override
  public int degree(Node<T> node) {
    Node<T> temp = get(node.key, this.root);
    int degree = 0;
    if (temp.lt != null) {
      degree++;
    }
    if (temp.rt != null) {
      degree++;
    }
    return degree;
  }

  // hitung jumlah node yang ada di dalam BST
  @Override
  public int count() {
    return count(this.root);
  }

  // method helper
  public int count(Node<T> root) {
    if (root == null) {
      return 0;
    }
    return 1 + count(root.lt) + count(root.rt);
  }

  // tambahkan node, 
  // dan letakkan node dalam BST 
  // sesuai nilai atribut int objek T
  @Override
  public void add(Node<T> node) {
    if (!isEmpty()) {
      Node<T> current = this.root;
      Node<T> parent = null;
      while (true) {
        parent = current;
        if (node.key < current.key) {
          current = current.lt;
          if (current == null) {
              parent.lt = new Node<T>(node.key, node.data);
              break;
          }
        }
        else {
          current = current.rt;
          if (current == null) {
              parent.rt = new Node<T>(node.key, node.data);
              break;
          }
        }
      }
    }
    else {
      Node<T> temp = new Node<T>(node.key, node.data);
      this.root = temp;
    }
  }

  // get node dalam BST 
  // yang memiliki atribut int objek T sama dengan key
  // dan dicari dari root node 
  // yang ditentukan dari parameter root 
  @Override
  public Node<T> get(int key, Node<T> root) {
    if (!isEmpty()) {
      if (root.key == key) {
          return root;
      }
      Node<T> temp = null;
      if (root.lt != null) {
          temp = get(key, root.lt);
          if (temp != null) {
              return temp;
          }
      }
      if (root.rt != null) {
          temp = get(key, root.rt);
          if (temp != null) {
              return temp;
          }
      }
    }
    return null;
  }

  // get node dengan atribut int objek T minimum 
  // yang diawali dari subtree 
  // dengan root node yang ditentukan lewat parameter
  @Override
  public Node<T> getMin(Node<T> node) {
    if (node.lt == null) {
      return node;
    }
    return getMin(node.lt);
  }

  // get node dengan atribut int objek T maksimum 
  // yang diawali dari subtree 
  // dengan root node yang ditentukan lewat parameter
  @Override
  public Node<T> getMax(Node<T> node) {
    if (!isEmpty()) {
      if (node.rt == null) {
          return node;
      }
      return getMax(node.rt);
    }
    return null;
  }

  // get parent node dari suatu node
  @Override
  public Node<T> parent(Node<T> node) {
    return parent(this.root, node.key);
  }

  // method helper
  public Node<T> parent(Node<T> node, int key) {
    if (node==null || node.key==key) {
      return null;
    }
    if ((node.lt!=null && node.lt.key==key) || (node.rt!=null && node.rt.key==key)) {
      return node;
    }
    Node<T> temp = parent(node.lt, key);
    if (temp != null) {
      return temp;
    }
    temp = parent(node.rt, key);
    return temp;
  }

  // hapus node dalam BST yang memiliki 
  // atribut int sama dengan key
  @Override
  public Node<T> delete(int key) {
    Node<T> n = get(key, this.root);
    int degree = this.degree(n);
    switch (degree) {
      case 0:
        Node<T> pa = parent(this.root, key);
        if (pa.key > key) pa.lt = null;
        else pa.rt = null;
        return pa;
      case 1:
        Node<T> pa2 = parent(this.root, key);
        Node<T> child = n.lt != null? n.lt : n.rt;
        if (pa2.key > n.key) pa2.lt = child;
        else pa2.rt = child;
        n.lt = null;
        n.rt = null;
        return pa2;
      case 2:
        Node<T> maxLeft = getMin(n.rt);
        n.data = maxLeft.data;
        this.delete(maxLeft.key);
        n.key = maxLeft.key;
        return maxLeft;
      }
    return null;
  }

  // traverse BST, simpan ke dalam array
  // return array
  @Override
  public T [] toArray() {
        return toArray(toList(root));
    }
    //helper casting
    public static <T> T[] toArray(List<T> list) {
        T[] toR = (T[]) java.lang.reflect.Array.newInstance(list.get(0).getClass(), list.size());
        for (int i = 0; i < list.size(); i++) {
            toR[i] = list.get(i);
        }
        return toR;
    }
    //helper arraylist
    public List<T> toList(Node node) {
        ArrayList<T> array = new ArrayList<>();
        if (node.lt != null) {
            array.addAll(toList(node.lt));

        }
        if (node.rt != null) {
            array.addAll(toList(node.rt));
        }
        array.add((T) node.data);
        return array;
    }

  // array yang dihasilkan dari toArray()
  // urutkan berdasarkan atribut int objek T
  // teknik sorting bebas
  @Override
  public T[] sort(T[] tArray) {
    Mobil[] mobil = (Mobil[]) tArray;
    for (int i = mobil.length-1; i >= 0; i--) {
      for (int j = mobil.length-1; j >= 0; j--) {
        if (mobil[i].tahun < mobil[j].tahun) {
          Mobil tempM = mobil[j];
          mobil[j] = mobil[i];
          mobil[i] = tempM;
        }
      }
    }
    return (T[]) mobil;
  }

  // print array yang dihasilkan dari toArray()
  @Override
  public void print(T[] tArray) {
    System.out.print("[ ");
    for(int i = 0; i<tArray.length;i++){
      if (i==tArray.length-1) {
        System.out.print(tArray[i]);
      }
      else {
        System.out.print(tArray[i] + ", ");
      }
    }
    System.out.print(" ]");
  }
}
