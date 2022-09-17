package ru.sabeshkin.adt.list.twoway;

import ru.sabeshkin.adt.list.parent.ParentListImpl;

public abstract class TwoWayList<T> extends ParentListImpl<T> {
  public final int LEFT_NIL = 0; // LEFT() ещё не вызывалась    
  public final int LEFT_OK = 1; // последняя LEFT() отработала нормально
  public final int LEFT_ERR = 2; // ошибка при перемещении курсора влево(возможно были на null)
  
  abstract void left();
  
 
  abstract int get_left_status();
}
