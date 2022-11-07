package ru.sabeshkin.adt.theory;

import ru.sabeshkin.adt.theory.limited.versatility.Void;

public class Any extends General{

  public Any assignmentAttempt(Object source) {
    if (source instanceof Any) {
      return (Any) source;
    }
    return new Void();
  }
}
