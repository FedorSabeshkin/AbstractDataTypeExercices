package ru.sabeshkin.adt.list.parent;

public class ParentListImpl<T> extends ParentList<T> {


  protected Node<T> current;
  private Node<T> head;
  private Node<T> tail;
  private int size;
  private int getStatus;
  private int rightStatus;
  private int putRightStatus;
  private int putLeftStatus;
  private int removeStatus;

  @Override
  public void put_right(T value) {
    Node<T> _nodeAfter = current;
    Node<T> _nodeToInsert = new Node<T>(value);
    insertAfter(_nodeAfter, _nodeToInsert);
    putRightStatus = PUT_RIGHT_OK;
    size++;
  }



  private void insertAfter(Node<T> _nodeAfter, Node<T> _nodeToInsert) {
    if (this.size() > 0) {
      if (is_tail()) {
        Node<T> oldTail = this.tail;
        this.tail = _nodeToInsert;
        this.tail.prev = oldTail;
      }
      if (_nodeAfter != null) {
        Node<T> nodeAfterNext = _nodeAfter.next;
        if (nodeAfterNext != null) {
          nodeAfterNext.prev = _nodeToInsert;
        }
        _nodeToInsert.next = nodeAfterNext;
        _nodeToInsert.prev = _nodeAfter;
        _nodeAfter.next = _nodeToInsert;
      } else {
        Node<T> oldHead = this.head;
        _nodeToInsert.next = oldHead;
        oldHead.prev = _nodeToInsert;
        this.head = _nodeToInsert;
      }
    } else {
      addInTail(_nodeToInsert);
    }
  }

  private void addInTail(Node<T> _item) {
    if (head == null) {
      this.head = _item;
      this.head.next = null;
      this.head.prev = null;
    } else {
      this.tail.next = _item;
      _item.prev = tail;
    }
    this.tail = _item;
  }

  @Override
  public void put_left(T value) {
    moveToLeft();
    Node<T> _nodeAfter = current;
    Node<T> _nodeToInsert = new Node<T>(value);
    insertAfter(_nodeAfter, _nodeToInsert);
    putLeftStatus = PUT_LEFT_OK;
    size++;
  }
  
  private void moveToLeft() {
    if (current != null && current.prev != null) {
      current = current.prev;
      return;
    }
  }

  @Override
  public void right() {
    if (current != null && current.next != null) {
      current = current.next;
      rightStatus = RIGHT_OK;
      return;
    }
    rightStatus = RIGHT_ERR;
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
    Node<T> node = current;
    if (node != null) {
      removeNode();
      removeStatus = REMOVE_OK;
      size--;
    }
    removeStatus = REMOVE_ERR;
  }


  private void removeNode() {
    Node<T> node = current;
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    // check head case
    if (is_head()) {
      if (node.next != null) {
        this.head = node.next;
        this.head.prev = null;
      } else {
        this.head = null;
      }
    }
    // check tail case
    if (is_tail()) {
      if (node.prev != null) {
        this.tail = node.prev;
        this.tail.next = null;
      } else {
        this.tail = null;
      }
    }
  }

  @Override
  public void clear() {
    current = null;
    head = current;
    tail = head;
    size = 0;
  }

  @Override
  public void add_tail(T value) {
    Node<T> addedNode = new Node<T>(value);
    if (head == null) {
      this.head = addedNode;
      this.head.next = null;
      this.head.prev = null;
    } else {
      this.tail.next = addedNode;
      addedNode.prev = tail;
    }
    this.tail = addedNode;
  }

  @Override
  public void replace(T value) {
    Node<T> savedPrev = current.prev;
    Node<T> savedNext = current.next;
    Node<T> addedNode = new Node<T>(value);
    current = addedNode;
    current.prev = savedPrev;
    current.next = savedNext;
  }

  @Override
  public void find(T value) {
    Node<T> node = this.head;
    while (node != null) {
      if (node.value.equals(value)) {
        current = node;
        return;
      }
      node = node.next;
    }
  }

  @Override
  public void remove_all(T value) {
    find(value);
    Node<T> node = current;
    while (node != null) {
      remove();
      find(value);
      node = current;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get() {
    if (current != null) {
      getStatus = GET_OK;
      return current.value;
    }
    getStatus = GET_OK;
    return null;
  }

  @Override
  public boolean is_head() {
    return head.equals(current);
  }

  @Override
  public boolean is_tail() {
    return tail.equals(current);
  }

  @Override
  public boolean is_value() {
    return current != null;
  }

  @Override
  public int get_put_right_status() {
    return putLeftStatus;
  }

  @Override
  public int get_put_left_status() {
    return putRightStatus;
  }

  @Override
  public int get_right_status() {
    return rightStatus;
  }

  @Override
  public int get_get_status() {
    return getStatus;
  }

  @Override
  public int get_remove_status() {
    return removeStatus;
  }

}


