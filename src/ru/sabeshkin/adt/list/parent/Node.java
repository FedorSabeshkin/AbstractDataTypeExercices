package ru.sabeshkin.adt.list.parent;


public class Node<T> {
  public T value;
  public Node<T> next;
  public Node<T> prev;

  public Node(T value) {
    this.value = value;
    next = null;
    prev = null;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((next == null) ? 0 : next.hashCode());
    result = prime * result + ((prev == null) ? 0 : prev.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Node<T> other = (Node<T>) obj;
    if (next == null) {
      if (other.next != null)
        return false;
    } else if (!next.equals(other.next))
      return false;
    if (prev == null) {
      if (other.prev != null)
        return false;
    } else if (!prev.equals(other.prev))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

}