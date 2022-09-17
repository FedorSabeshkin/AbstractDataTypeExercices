package ru.sabeshkin.adt.list.twoway;

public class TwoWayListImpl<T> extends TwoWayList<T> {
  private int leftStatus;
  
  
  @Override
  void left() {
    if (current != null && current.prev != null) {
      current = current.prev;
      leftStatus = LEFT_OK;
      return;
    }
    leftStatus = LEFT_ERR;
  }
  

  @Override
  int get_left_status() {
    return leftStatus;
  }

}
