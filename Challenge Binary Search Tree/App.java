public class App {
  public static void main(String[] args) {

    Mobil prelude = new Mobil(1998, "Honda Prelude");
    Mobil yaris = new Mobil(2022, "Toyota GR Yaris");
    Mobil jeep = new Mobil(1972, "Jeep Wrangler");
    Mobil jimny = new Mobil(1983, "Suzuki Jimny");
    Mobil mazda = new Mobil(1967, "Mazda RX 87");
    Mobil fiat = new Mobil(2007, "Fiat 500");
    Mobil benz = new Mobil(1958, "Mercedes Benz 220");

    BST<Mobil> tree = new BST<>(new Node<Mobil>(prelude.tahun, prelude));
    
    // bangun tree (BST) sesuai urutan masuknya mobil 
    // yang diuraikan dalam studi kasus
    // manfaatkan method: public void add(Node<T> node);
    tree.add(new Node<Mobil>(yaris.tahun, yaris));
    tree.add(new Node<Mobil>(jeep.tahun, jeep));
    tree.add(new Node<Mobil>(jimny.tahun, jimny));
    tree.add(new Node<Mobil>(mazda.tahun, mazda));
    tree.add(new Node<Mobil>(fiat.tahun, fiat));
    tree.add(new Node<Mobil>(benz.tahun, benz));

    System.out.println(tree.toString()); // untuk melihat isi tree
    /*=== Ilustrasi Binary Search Tree ===
      *             1998
      *           /      \
      *        1972      2022
      *        /  \       /
      *     1967  1983  2007
      *     /
      *   1958
    */

    // demokan semua method:
    // public int degree(Node<T> node);
    System.out.println("Implementasi method degree()");
    System.out.println(tree.degree(tree.root.lt));
    // public int count();
    System.out.println("\nImplementasi method count()");
    System.out.println(tree.count(tree.root));
    // public Node<T> get(int key, Node<T> root);
    System.out.println("\nMencari dan mendapatkan sebuah node");
    System.out.println(tree.get(2007, tree.root));
    // public Node<T> getMin(Node<T> node);
    System.out.println("\nMencari dan mendapatkan node terkecil");
    System.out.println(tree.getMin(tree.root));
    // public Node<T> getMax(Node<T> node);
    System.out.println("\nMencari dan mendapatkan node terbesar");
    System.out.println(tree.getMax(tree.root));
    // public Node<T> parent(Node<T> node);
    System.out.println("\nMendapatkan parent dari node yang ditentukan");
    System.out.println(tree.parent(tree.root.lt.lt.lt));
    // public Node<T> delete(int key);
    tree.delete(1967);

    System.out.println("\nTampilan setelah terjadi proses pengahpusan");
    System.out.println(tree.toString()); // untuk melihat isi tree sesudah node di-delete

    Mobil[] mobils = tree.toArray(); // ubah BST menjadi array
    System.out.println(mobils[0]);
    tree.sort(mobils); // sort array
    tree.print(mobils); // tampilkan array yang telah diurutkan
  }
}
