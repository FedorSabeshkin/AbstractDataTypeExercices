package ru.sabeshkin.adt.parent.hash.store;

public abstract class ParentHashStore {
  
  // постусловие: создана таблица для сохранения size значений
  public ParentHashStore(int size) {}

  // операции
  // предусловие: в таблице есть свободные слоты
  // постусловие: в таблицу добавлено новое значение
  public abstract void put(String value);

  // запросы
  // сообщает найден ли элемент
  public abstract boolean isExist(String value);
  
  public abstract int get_put_status(); //  выполнялся успешно / с ошибкой / не выполнялся

  public abstract int get_is_exist_status(); // выполнялся / не выполнялся
}
