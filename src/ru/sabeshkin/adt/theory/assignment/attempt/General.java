package ru.sabeshkin.adt.theory.assignment.attempt;

import java.io.Serializable;

/**
 * 8 фундаментальных методов класса.
 * 
 * @author Wizard
 *
 */
public class General implements Cloneable, Serializable {

  // ...
  
  public General assignmentAttempt(Object source) {
    if (source instanceof General) {
      return (General) source;
    }
    return new Void();
  }
}

class Any extends General{

  public Any assignmentAttempt(Object source) {
    if (source instanceof Any) {
      return (Any) source;
    }
    return new Void();
  }
}



final class Void extends Any /* A, B, .... */ {
}

