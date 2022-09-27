package ru.sabeshkin.adt.queue;

public abstract class Queue<T> {
  
  
  
  // операции
  // предусловие:в хвост очереди добавлен элемент
  public abstract void enqueue(T item);

  // постусловие: из очереди удален наиболее ранний из добавленных элементов
  public abstract void dequeue();

  // запросы
  // получить элемент, который достали из очереди в крайний раз
  public abstract T getItem();
  public abstract int size();
  
  // запросы статусов
  public abstract int get_dequeue_status(); 
}
