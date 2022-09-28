package ru.sabeshkin.adt.queue.parent;

public abstract class ParentQueue<T> {
  
  // операции
  // постусловие: в хвост очереди добавлен элемент
  public abstract void addTail(T item);

  // постусловие: из очереди удален наиболее ранний из добавленных элементов
  public abstract void removeFront();

  // запросы
  // получить элемент, который достали из очереди в крайний раз
  public abstract T getItem();
  public abstract int size();
  
  // запросы статусов
  public abstract int get_remove_front_status(); 
  public abstract int get_get_status(); 
}
