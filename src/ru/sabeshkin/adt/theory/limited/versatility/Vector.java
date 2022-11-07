package ru.sabeshkin.adt.theory.limited.versatility;

import ru.sabeshkin.adt.theory.Any;

public class Vector<T> extends Any{
  private int length;
  private T[] arr;

  public Vector() {
  }
  
  public Vector(T[] arr) {
    this.arr = arr;
    length = arr.length;
  }

  public Vector(int length) {
    arr = (T[]) new Object[length];
    this.length = length;
  }


  public void add(Vector<? extends T> v) {
    Vector<String> temp = new Vector<String>(1);
  
      T[] arr2 = v.getArr();
      for (int i = 0; i < length; i++) {
        if (arr2[i].getClass().isInstance(temp)) {
          // проверяем типы. Если это Vector, то:
          ((Vector<T>) arr[i]).add(((Vector<T>) arr2[i]));
        } else { // иначе - это Number или String
          add_v((Vector<T>) v);
          break;
        }
      }
    
  }


  private void add_v(Vector<T> vector) {
    T[] arr2 = vector.getArr();
    for (int i = 0; i < length; i++) {
      arr[i] = (T) sum(arr[i], arr2[i]);
    }
  }


  /**
   * Сумма двух векторов.
   */
  public static Vector addVectors(Vector v1, Vector v2) {
    if (v1.getLength() != v2.getLength()) {
      return new Void();
    }
    Vector resultVector = (Vector) v1.deepCopy();
    resultVector.add(v2);
    return resultVector;
  }

  public int getLength() {
    return length;
  }

  public T[] getArr() {
    return arr;
  }


  public T sum(T first, T second) {
    T summa = null;
    if (first instanceof String) {
      summa = sumString(first, second);
    }
    if (first instanceof Integer) {
      summa = sumInteger(first, second);
    }
    if (first instanceof Double) {
      summa = sumDouble(first, second);
    }
    return summa;
  }

  private T sumString(T first, T second) {
    return (T) (first + (String) second);
  }

  private T sumInteger(T first, T second) {
    Integer sum = (Integer) first + (Integer) second;
    T value = (T) sum;
    return value;
  }

  private T sumDouble(T first, T second) {
    return (T) ((Double) ((Double) (first) + (Double) second));
  }


}
