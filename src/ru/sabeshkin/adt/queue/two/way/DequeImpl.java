package ru.sabeshkin.adt.queue.two.way;

public class DequeImpl<T> extends Deque<T> {

  private int removeTailStatus;
  @Override
  public void addFront(T item) {
    linkedList.addFirst(item);
  }

  @Override
  public void removeTail() {
    item = linkedList.pollLast();
    if(item!=null) {
      removeTailStatus = 2;
      return;
    }
    removeTailStatus = 1;
  }

  @Override
  public int get_remove_tail_status() {
    return removeTailStatus;
  }

}
