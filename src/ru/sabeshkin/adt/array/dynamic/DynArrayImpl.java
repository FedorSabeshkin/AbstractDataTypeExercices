package ru.sabeshkin.adt.array.dynamic;

public class DynArrayImpl<T> extends DynArray<T> {

  private int appendStatus;
  private int getItemStatus;
  private int removeStatus;
  private int insertStatus;

  // наша базовая структура данных
  public T[] array;
  // сколько элементов у нас в массиве
  public int count;
  // какая его максимальная емкость
  public int capacity;
  /*
   * Нужен для внутренней работы, что бы мы после инициалищации объекта не смогли добавлять элементы
   * другого типа
   */
  Class clazz;

  public DynArrayImpl(Class clz) {
    clazz = clz; // нужен для безопасного приведения типов
    // new DynArray<Integer>(Integer.class);
    count = 0;
    makeArray(16);
  }

  @Override
  @SuppressWarnings("unchecked")
  public void makeArray(int new_capacity) {
    int oldCapacity = this.capacity;
    if (count == 0) {
      this.array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
    } else {
      T[] newArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
      if (oldCapacity < new_capacity) {
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
      }
      if (oldCapacity > new_capacity) {
        System.arraycopy(this.array, 0, newArray, 0, newArray.length);
      }
      this.array = newArray;
    }
    this.capacity = new_capacity;
  }

  @Override
  public T getItem(int index) {
    if (index < 0 || index >= capacity) {
      getItemStatus = 2;
      throw new IllegalArgumentException("The passed index out of possible range");
    }
    getItemStatus = 1;
    return this.array[index];

  }

  @Override
  public void remove(int index) {
    // O(1)
    if (index < 0 || index >= this.capacity || index >= this.count) {
      removeStatus = 2;
      throw new IllegalArgumentException("The passed index out of possible range");
    }

    // создание копии элементов, которые будут сдвигаться
    int sizeOfThePart = this.count - index - 1;
    if (sizeOfThePart < 1) {
      sizeOfThePart = this.capacity - this.count;
    }
    @SuppressWarnings("unchecked")
    T[] copyPartOfArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, sizeOfThePart);
    System.arraycopy(this.array, index + 1, copyPartOfArray, 0, sizeOfThePart);
    // склеивание значений из части исходного массива, с окошком на месте
    // удаленного
    // и массива в котором хранил копии элементов из исходного
    System.arraycopy(copyPartOfArray, 0, this.array, index, sizeOfThePart);
    // O(1)
    if (this.count - 1 < (this.capacity / 2) && (this.capacity != 16)) {
      // O(1)
      int newCapacity = (int) ((this.capacity / 1.5 < 16) ? 16 : this.capacity / 1.5);
      // O(n)
      makeArray(newCapacity);
    }
    this.count--;
    this.array[this.count] = null;
    removeStatus = 1;
  }

  @Override
  public void append(T item) {
    if ((this.count + 1) > this.capacity) {
      makeArray(this.capacity * 2);
    }
    this.array[count] = item;
    this.count++;
    appendStatus = 1;
  }

  @Override
  public void insert(T item, int index) {
    if (index < 0 || index >= (capacity + 2)) {
      insertStatus = 2;
      throw new IllegalArgumentException("The passed index out of possible range");
    }
    if ((this.count + 1) > this.capacity) {
      makeArray(this.capacity * 2);
    }
    if (index == (this.count - 1)) {
      append(item);
    } else {
      // создание копии элементов, которые будут сдвигаться
      int sizeOfThePart = this.count - index;
      @SuppressWarnings("unchecked")
      T[] copyPartOfArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, sizeOfThePart);
      System.arraycopy(this.array, index, copyPartOfArray, 0, sizeOfThePart);
      // создание resultArr
      int newCapacity = ((this.count + 1) > this.capacity) ? this.capacity * 2 : this.capacity;
      // O(n)
      if (newCapacity != this.capacity) {
        makeArray(newCapacity);
      }
      this.array[index] = item;
      // склеивание значений из части исходного массива + новый элемент
      // и массива в котором хранил копии элементов из исходного
      System.arraycopy(copyPartOfArray, 0, this.array, index + 1, sizeOfThePart);
      this.count++;
    }
    insertStatus = 1;
  }

  @Override
  public int get_append_status() {
    return appendStatus;
  }

  @Override
  public int get_remove_status() {
    return removeStatus;
  }

  @Override
  public int get_get_item_status() {
    return getItemStatus;
  }

  @Override
  public int get_insert_status() {
    return insertStatus;
  }

}
