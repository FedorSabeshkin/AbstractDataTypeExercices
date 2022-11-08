package ru.sabeshkin.adt.theory.taxonomy;

/**
 * Поздравление.
 */
public class Congratulation {

  public Congratulation() {
    super();
  }


  /**
   * Избавились от множественных if else, путем создания класса под каждое возможное значение.
   */
  public void sendCongratulation(Gender gender) {
    send(gender.getCongratulationMessage());
  }

  /**
   * Каждое значение требует нового if во всех взаимодействующих частях.
   */
  public void sendCongratulation(String gender) {
    if (gender.equals("w")) {
      send("Поздравляем с международным Женским Днем!");
      return;
    }
    if (gender.equals("m")) {
      send("Поздравляем с международным Мужским Днем!");
      return;
    }
  }

  /**
   * Отправка сообщения.
   */
  private void send(String message) {
    System.out.println(message);
  }
}


/**
 * Мужчина.
 */
class Male implements Gender {

  @Override
  public String getCongratulationMessage() {
    return "Поздравляем с международным Мужским Днем!";
  }

}


/**
 * Женщина.
 */
class Female implements Gender {

  @Override
  public String getCongratulationMessage() {
    return "Поздравляем с международным Женским Днем!";
  }

}
