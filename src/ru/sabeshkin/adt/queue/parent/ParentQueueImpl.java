package ru.sabeshkin.adt.queue.parent;

import java.util.LinkedList;

public class ParentQueueImpl<T> extends ParentQueue<T> {
  private int removeFrontStatus;
  private int getStatus;
  protected T item;
  protected LinkedList<T> linkedList;
  
  public ParentQueueImpl() {
    linkedList = new LinkedList<>();
  }
  
  @Override
  public void addTail(T item) {
    linkedList.addLast(item);
  }

  @Override
  public void removeFront() {
    item = linkedList.pollFirst();
    if(item!=null) {
      removeFrontStatus = 2;
      return;
    }
    removeFrontStatus = 1;
  }

  @Override
  public T getItem() {
    getStatus = 1;
    return item;
  }

  @Override
  public int size() {
    return linkedList.size();
  }

  @Override
  public int get_remove_front_status() {
    return removeFrontStatus;
  }

  @Override
  public int get_get_status() {
    return getStatus;
  }
}
