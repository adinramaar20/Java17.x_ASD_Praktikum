public interface IBST<T> {
  public void add(Node<T> node);
  public int degree(Node<T> node);
  public int count();
  public Node<T> get(int key, Node<T> root);
  public Node<T> getMin(Node<T> node);
  public Node<T> getMax(Node<T> node);
  public Node<T> parent(Node<T> node);
  public Node<T> delete(int key);
  public T[] toArray();
  public T[] sort(T[] tArray);
  public void print(T[] tArray);
}
