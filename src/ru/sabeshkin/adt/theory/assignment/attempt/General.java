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

}


class Any extends General {

  public Any assignmentAttempt(Object source) {
    if (source instanceof Any) {
      return (Any) source;
    }
    return new None();
  }
}



final class None extends Any /* A, B, .... */ {
}

