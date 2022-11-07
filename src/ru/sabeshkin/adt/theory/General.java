package ru.sabeshkin.adt.theory;

import java.io.Serializable;
import ru.sabeshkin.adt.theory.limited.versatility.Void;

/**
 * 8 фундаментальных методов класса.
 * 
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
    return super.toString();
  }

  // 7) проверка типа
  // через стандартные средства языка - instance of

  // 8) получение реального типа объекта
  // через метод getClass(); класса Object

  public General assignmentAttempt(Object source) {
    if (source instanceof General) {
      return (General) source;
    }
    return new Void();
  }
}


final class Void extends Any /* A, B, .... */ {
}


class Test {
  public static Any getSome() {
    return new Void();
  }

  public static void setSome(Any any) {
    if (any instanceof Void) {
      System.out.println("wrong value!!!");
    }
  }
}
