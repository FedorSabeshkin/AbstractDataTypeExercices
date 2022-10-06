package ru.sabeshkin.adt.dictionary;


public abstract class NativeDictionary<T> {
  public int size;
  public String[] slots;
  public T[] values;

  // постусловие: создана таблица для сохранения size значений типа clazz
  public NativeDictionary(int size, Class clazz) {}

  // операции
  // предусловие: в таблице есть свободные слоты
  // постусловие: в таблицу добавлено новое значение
  public abstract void put(String key, T value);

  // предусловие: убедились в существовании элементаа с таким значением
  // постусловие: после выполнения он находится в таблице, а мы получили на него ссылку
  public abstract T get(String key);

  // запросы
  public abstract boolean isKey(String key);

  public abstract int get_is_key_status();

  public abstract int get_get_status();

  public abstract int get_put_status();
}
