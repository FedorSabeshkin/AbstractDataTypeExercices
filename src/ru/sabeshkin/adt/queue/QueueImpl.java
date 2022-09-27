package ru.sabeshkin.adt.queue;

import java.util.LinkedList;

public class QueueImpl<T> extends Queue<T> {

  private int dequeueStatus;
  private LinkedList<T> queue;
  private T lastDequeued;
  
  public QueueImpl() {
    queue = new LinkedList<>();
  }
  
  @Override
  public void enqueue(T item) {
    queue.add(item);
  }

  @Override
  public void dequeue() {
    lastDequeued = queue.pollFirst();
    if(lastDequeued!=null) {
      dequeueStatus = 2;
      return;
    }
    dequeueStatus = 1;
  }

  @Override
  public T getItem() {
    return lastDequeued;
  }

  @Override
  public int size() {
    return queue.size();
  }

  @Override
  public int get_dequeue_status() {
    return dequeueStatus;
  }


}
