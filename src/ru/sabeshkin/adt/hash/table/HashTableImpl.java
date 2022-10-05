package ru.sabeshkin.adt.hash.table;

public class HashTableImpl extends HashTable {

  private int size;
  private int step;
  private String[] slots;
  private final int DEFAULT_STEP = 3;
  private int putStatus;
  private int isExistStatus;
  private int removeStatus;

  public HashTableImpl(int size) {
    super(size);
    this.size = size;
    step = DEFAULT_STEP;
    slots = new String[size];
    for (int i = 0; i < size; i++) {
      slots[i] = null;
    }
  }

  /*
   * return index of value
   */
  private int hashFun(String value) {
    char[] charArr = new char[value.length()];
    int sum = 0;
    for (int i = 0; i < value.length(); i++) {
      charArr[i] = value.charAt(i);
      // cast char to int
      sum += charArr[i] - '0';
    }
    return (sum % size);
  }

  /*
   * return index after check collisions
   */
  private int seekSlot(String value) {
    int i;
    i = hashFun(value);
    i = checkIndex(i, value);
    return i;
  }

  private int checkIndex(int i, String key) {
    // check slot by step
    i = checkWithStep(i, key);
    // check each slot
    if (i >= size) {
      i = checkEachElement(i, key);
    }
    /**
     * if have't free slot or already have this key
     */
    if (i >= size) {
      return -1;
    }
    return i;
  }

  private int checkWithStep(int i, String key) {
    while (i < size && slots[i] != null) {
      if (slots[i].equals(key)) {
        break;
      }
      i += step;
    }
    return i;

  }

  private int checkEachElement(int i, String key) {
    i = 0;
    while (i < size && slots[i] != null) {
      if (slots[i].equals(key)) {
        break;
      }
      i++;
    }
    return i;
  }

  /*
   * put value to hash table
   */
  @Override
  public void put(String value) {
    int i;
    i = seekSlot(value);
    if (i != -1) {
      slots[i] = value;
      putStatus = 1;
    }
    putStatus = 2;
  }

  private int find(String value) {
    int i = hashFun(value);
    if (value.equals(slots[i])) {
      return i;
    } else {
      for (i = 0; i < size; i++) {
        if (value.equals(slots[i])) {
          return i;
        }
      }
      return -1;
    }
  }


  @Override
  public boolean isExist(String value) {
    int foundIndex = find(value);
    isExistStatus = 1;
    return foundIndex != -1;
  }

  @Override
  public void remove(String value) {
    int foundIndex = find(value);
    if (foundIndex != -1) {
      removeStatus = 1;
      slots[foundIndex] = null;
      return;
    }
    removeStatus = 2;
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
