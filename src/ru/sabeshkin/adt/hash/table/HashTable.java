package ru.sabeshkin.adt.hash.table;

public abstract class HashTable {
  public int size;
  public int step;
  public String[] slots;

  // постусловие: создана таблица для сохранения size значений
  public HashTable(int size) {}

  // операции
  // предусловие: в таблице есть свободные слоты
  // постусловие: в таблицу добавлено новое значение
  public abstract void put(String value);

  // постусловие: курсор указывает на индекс найденного значение, либо на -1, если найти не удалось
  public abstract boolean isExist(String value);

  // предусловие: убедились в существовании элементаа с таким значением
  // постусловие: после выполнения, его уже нет в таблице
  public abstract void remove(String value);


  // запросы
  public abstract int get_put_status();

  public abstract int get_remove_status();

  public abstract int get_is_exist_status();

}
