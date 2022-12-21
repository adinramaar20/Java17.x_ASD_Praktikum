public class Node<T> {
  int key;
  T data;

  Node<T> lt;
  Node<T> rt;

  public Node(int key, T data) {
    this.key = key;
    this.data = data;
  }

  @Override
  public String toString() {
    return this.data.toString();
  }

}