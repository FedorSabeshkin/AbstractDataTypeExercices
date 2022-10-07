package ru.sabeshkin.adt.power.set;

public abstract class PowerSet {

  // постусловие: созданно пустое множество
  public PowerSet() {}

  // операции
  // постусловие: в множество добавлено новое значение. Если значение существовало ранее, то
  // осталось там в единственном экземпляре
  public abstract void put(String value);

  // предусловие: в множестве есть указанное значение
  // постусловие: из множества удаленно значение
  public abstract void remove(String value);

  // запросы
  public abstract boolean isExist(String value);
  
  public abstract int size();

  public abstract int get_is_exist_status(); // возможные значения: не выполнялось,выполнялось

  public abstract int get_remove_status(); // возможные значения: не выполнялось, выполнилось
                                           // успешно, ошибка при выполнении

  public abstract int get_put_status(); // возможные значения: не выполнялось, выполнилось успешно,
                                        // ошибка при выполнении

}
