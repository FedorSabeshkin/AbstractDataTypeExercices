package ru.sabeshkin.adt.list.parent;

public class ParentListImpl<T> extends ParentList<T> {


  private Node<T> current;
  private Node<T> head;
  private Node<T> tail;
  
  private int getStatus;
  private int putRightStatus;
  private int putLeftStatus;

  @Override
  public void put_right(T value) {
    Node<T> addedNode = new Node(value);
    current.next = addedNode;
    current = addedNode;
  }

  @Override
  public void put_left(T value) {
    Node<T> addedNode = new Node(value);
    // добавление к существующему узлу находящемуся в хвосте и имещему потомка слева
    Node<T> previousNode = current.prev;
    current.prev = addedNode;
    previousNode.next = addedNode;
    addedNode.next = current;
    current = addedNode;
    putRightStatus = PUT_RIGHT_OK;
    
    // добавление в пустой список
    
    // добавление к head у которого предыдущий сосед равен null
  }

  @Override
  public void right() {
    if (current != null && current.next != null) {
      current = current.next;
    }
  }

  @Override
  public void head() {
    current = head;
  }

  @Override
  public void tail() {
    current = tail;
  }

  @Override
  public void remove() {
    // TODO Auto-generated method stub

  }

  @Override
  public void clear() {
    current = null;
    head = current;
    tail = head;
  }

  @Override
  public void add_tail(T t) {
    // TODO Auto-generated method stub

  }

  @Override
  public void replace(T t) {
    // TODO Auto-generated method stub

  }

  @Override
  public void find(T t) {
    // TODO Auto-generated method stub

  }

  @Override
  public void remove_all(T t) {
    // TODO Auto-generated method stub

  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public T get() {
    if (current != null) {
      getStatus =GET_OK;
      return current.value;
    }
    getStatus =GET_OK;
    return null;
  }

  @Override
  public boolean is_head() {
    return head.equals(current);
  }

  @Override
  public boolean is_tail() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean is_value() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int get_put_right_status() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int get_put_left_status() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int get_right_status() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int get_get_status() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int get_remove_status() {
    // TODO Auto-generated method stub
    return 0;
  }

}


class Node<T> {
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
