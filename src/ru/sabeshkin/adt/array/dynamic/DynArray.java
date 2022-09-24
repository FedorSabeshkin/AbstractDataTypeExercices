package ru.sabeshkin.adt.array.dynamic;

public abstract class DynArray<T> {
  
  /**
   * постусловие: создан новый массив на начальное кол-во ячеек. 
   */
  public abstract void makeArray(int new_capacity);

  /**
   * постусловие: получили ссылку на эллемент под заданным индексом  
   */
  public abstract T getItem(int index);

  // предусловие: существует массив
  // постусловие: под индексом размера массива-1 будет новый элемент 
  // инвариант: элемент, который ранее находился в позиции  (размер массива-1), находится на позиции (размер массива-2)
  // постусловие: размер массива увеличился на 1
  public abstract void append(T item);

  // постусловие: под индексом будет новый элемент 
  // постусловие: элементы находившийся в данной позиции ранее и его правые соседи переместились на один в право
  public abstract void insert(T item, int index); 

  /**
   * постусловие: ячейка под заданный индексом пуста
   */
  public abstract void remove(int index);
  
  // запросы статусов
  public abstract int get_append_status(); 
  public abstract int get_remove_status(); 
  public abstract int get_get_item_status();
  public abstract int get_insert_status(); 
}
