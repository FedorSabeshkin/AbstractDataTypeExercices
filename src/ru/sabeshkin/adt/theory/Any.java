package ru.sabeshkin.adt.theory;

import java.util.List;
import ru.sabeshkin.adt.theory.limited.versatility.Void;

public class Any extends General{

  public Any assignmentAttempt(Object source) {
    if (source instanceof Any) {
      return (Any) source;
    }
    return new Void();
  }
}

class Expression {
  @Override
  public String toString() {
      return "some expression";
  }

  public void method() {
      System.out.println("some method from expression");
  }
}

class SimpleExpression extends Expression {
  @Override
  public String toString() {
      return "some simple expression";
  }

  @Override
  public void method() {
      System.out.println("some method from simple expression");
  }
}

class ComplexExpression extends SimpleExpression {
  @Override
  public String toString() {
      return "some complex expression";
  }

  @Override
  public void method() {
      System.out.println("some complex expression");
  }
}


class Calculator {
  Expression getExpression() {
      System.out.println("Некоторая логика простого калькулятора");
      return new Expression();
  }

  // В Java только массивы ковариантны,
  // остальные обобщенные коллекции использовать нельзя.
  public <T extends Expression> void covariantMethod(List<T> values) {
      for (T value : values) {
          System.out.println(value.toString());
      }
  }

  // Можно передавать как объект типа Expression, 
  // так и любого его потомка
  public void polymorphicMethod(Expression value) {
      value.method();
  }
}