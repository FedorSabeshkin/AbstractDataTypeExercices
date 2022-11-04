package ru.sabeshkin.adt.theory;

public class Any extends General{

  public Any assignmentAttempt(Object source) {
    if (source instanceof Any) {
      return (Any) source;
    }
    return new Void();
  }
}
