package ru.sabeshkin.adt.dictionary;

import java.lang.reflect.Array;

public class NativeDictionaryImpl<T> extends NativeDictionary<T> {
  
  private int isKeyStatus;
  private int getStatus;
  private int putStatus;
  private int size;
  private String[] slots;
  private T[] values;
  private int step = 3;

  @SuppressWarnings("unchecked")
  public NativeDictionaryImpl(int size, Class clazz) {
    super(size, clazz);
    this.size = size;
    this.slots = new String[size];
    this.values = (T[]) Array.newInstance(clazz, this.size);
    for (int i = 0; i < size; i++){
      this.slots[i] = null;
    }
  }

  /**
   * Set value by key
   * 
   * @param key
   * @param value
   */
  @Override
  public void put(String key, T value) {
      int index = 0;
      index = generateIndex(key);
      if(index != -1){
          slots[index] = key;
          values[index] = value;
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
          i = checkIndex(i, key);
          return i;
      }
  }

  /**
   * 
   * @param key
   * @return value by key or null if key don't exit
   */
  @Override
  public T get(String key) {
      int index = find(key);
      if(index != (-1)){
          return values[index];
      } else{
          return null;
      }
  }
  
  /**
   * 
   * @param key
   * @return check key is exist
   */
  @Override
  public boolean isKey(String key) {
      int index = 0;
      index = hashFun(key);
      if(slots[index] != null && slots[index].equals(key)){
          return true;
      } else{
          for (index = 0; index < slots.length; index++){
              if(slots[index] != null && slots[index].equals(key)){
                  return true;
              }
          }
      }
      return false;
  }


  @Override
  public int get_is_key_status() {
    return isKeyStatus;
  }

  @Override
  public int get_get_status() {
    return getStatus;
  }

  @Override
  public int get_put_status() {
    return putStatus;
  }

  /**
   * 
   * @param key
   * @return index of slots
   */
  private int hashFun(String key) {
      char[] charArr = new char[key.length()];
      int sum = 0;
      for (int i = 0; i < key.length(); i++){
          charArr[i] = key.charAt(i);
          sum += charArr[i] - '0';
      }
      return (sum % size);
  }

  /**
   * 
   * @param key
   * @return index after check collisions
   */
  private int generateIndex(String key) {
      int i;
      i = hashFun(key);
      i = checkIndex(i, key);
      return i;
  }
  
  private int checkIndex(int i, String key) {
      // check slot by step
      i = checkWithStep(i, key);
      // check each slot
      if(i >= size){
          i = checkEachElement(i, key);
      }
      /**
       * if have't free slot or already have this key
       */
      if(i >= size)
          return -1;
      return i;
  }
  
  private int checkWithStep(int i, String key) {
      while(i < size && slots[i] != null){
          if(slots[i].equals(key))
              break;
          i += step;
      }
      return i;
  }

  private int checkEachElement(int i, String key) {
      i = 0;
      while(i < size && slots[i] != null){
          if(slots[i].equals(key))
              break;
          i++;
      }
      return i;
  }
  
}
