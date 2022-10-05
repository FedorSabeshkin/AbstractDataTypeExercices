package ru.sabeshkin.adt.hash.table;

public abstract class HashTable {
  protected int size;

  // постусловие: создана таблица для сохранения size значений
  public HashTable(int size) {}

  // операции
  // предусловие: в таблице есть свободные слоты
  // постусловие: в таблицу добавлено новое значение
  public abstract void put(String value);

  // постусловие: курсор указывает на индекс найденного значение, либо на -1, если найти не удалось
  public abstract void find(String value);
  
  // запросы
  // постусловие: получили значение индекса, который переместился после операции find()
  public abstract int get();


  public abstract int get_put_status();

  public abstract int get_find_status();

  public abstract int get_get_status();
}
