package ru.sabeshkin.adt.power.set;

public class PowerSetImpl extends PowerSet {

  private int putStatus;
  private int removeStatus;
  private int isExistStatus;

  private int storeSize;
  private String[] slots;
  private int step = 3;
  private int count;

  public PowerSetImpl() {
    storeSize = 20000;
    slots = new String[storeSize];
    count = 0;
    for (int i = 0; i < storeSize; i++) {
      slots[i] = null;
    }
  }

  public PowerSetImpl(int sizeOfStore) {
    storeSize = sizeOfStore;
    slots = new String[storeSize];
    count = 0;
    for (int i = 0; i < storeSize; i++) {
      slots[i] = null;
    }
  }

  private String[] getSlots() {
    return slots;
  }
  
  /**
   * 
   * @param key
   * @return index of slots
   */
  public int hashFun(String key) {
      char[] charArr = new char[key.length()];
      int sum = 0;
      for (int i = 0; i < key.length(); i++){
          charArr[i] = key.charAt(i);
          // cast char to int
          sum += (int) charArr[i] - '0';
      }
      return (sum % storeSize);
  }

  /**
   * 
   * @param value
   * @return index after check collisions
   */
  public int generateIndex(String value) {
      int i;
      i = hashFun(value);
      // check slot by step
      while(i < storeSize && slots[i] != null){
          if(slots[i].equals(value)){
              return -1;
          }
          i += step;
      }
      // check each slot
      if(i >= storeSize){
          i = 0;
          while(i < storeSize && slots[i] != null){
              if(slots[i].equals(value)){
                  return -1;
              }
              i++;
          }
      }
      /**
       * if have't free slot or already have this key
       */
      if(i >= storeSize)
          return -1;
      return i;
  }

  @Override
  public int size() {
    return count;
  }


  @Override
  public void put(String value) {
    int index = 0;
    index = generateIndex(value);
    if(index != -1){
        slots[index] = value;
        count++;
        removeStatus = 1;
        return;
    }
    removeStatus = 2;
  }

  @Override
  public void remove(String value) {
    int index = find(value);
    if(index != (-1)){
        slots[index] = null;
        count--;
        removeStatus = 1;
    } else{
        removeStatus = 2;
    }
  }
  

  /**
   * 
   * @param value
   *            for search
   * @return index of found value
   */
  private int find(String key) {
      int i = hashFun(key);
      if(key.equals(slots[i]))
          return i;
      else{
          for (i = 0; i < storeSize; i++){
              if(slots[i] != null && slots[i].equals(key))
                  return i;
          }
          return -1;
      }
  }

  @Override
  public boolean isExist(String value) {
    removeStatus = 1;
    int index = find(value);
    return index != (-1);
  }

  @Override
  public int get_is_exist_status() {
    return isExistStatus;
  }

  @Override
  public int get_remove_status() {
    return removeStatus;
  }

  @Override
  public int get_put_status() {
    return putStatus;
  }

}
