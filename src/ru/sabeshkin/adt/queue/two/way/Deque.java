package ru.sabeshkin.adt.queue.two.way;

import ru.sabeshkin.adt.queue.parent.ParentQueueImpl;

public abstract class Deque<T> extends ParentQueueImpl<T>{ 

  // постусловие: в начало очереди добавлен элемент
   public abstract void addFront(T item);

   // постусловие: из очереди удален последний из добавленных элементов
   public abstract void removeTail();
   
   // запросы статусов
   public abstract int get_remove_tail_status(); 
 }
