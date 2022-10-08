package ru.sabeshkin.adt.hash.table;

import ru.sabeshkin.adt.parent.hash.store.ParentHashStore;

public abstract class HashTable  extends ParentHashStore{
  public int size;
  public int step;
  public String[] slots;

  // постусловие: создана таблица для сохранения size значений
  public HashTable(int size) {
    super(size);
  }

  // предусловие: убедились в существовании элементаа с таким значением
  // постусловие: после выполнения, его уже нет в таблице
  public abstract void remove(String value);

  // запросы
  public abstract int get_remove_status();


}
