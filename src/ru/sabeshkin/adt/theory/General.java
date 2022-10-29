package ru.sabeshkin.adt.theory;

import java.io.Serializable;

/**
 * 8 фундаментальных методов класса.
 * @author Wizard
 *
 */
public class General extends Object implements Cloneable, Serializable {
  
  // 1) копирование объекта
  // сочетание конструктора и геттеров для получения значения полей копируемого объекта
  
  // 2) клонирование объекта
  // метод clone() из интерфейса Cloneable

  // 3) сравнение объектов
  // Метод equals и hashCode из Object

  // 4) и 5) сериализация и десериализация
  // методы writeObject() и readObject() интерфейса Serializable

  // 6) печать
  @Override
  public String toString() {
    return "General{" +
        '}';
  }

  // 7) проверка типа
  // через стандартные средства языка - instance of

  // 8) получение реального типа объекта
  // через метод getClass(); класса Object
}
