package ru.job4j.coffeemachine;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 20.02.19
 */
public class CoffeeMachine {
    /**
     * Максимальный номинал купюры.
     */
    int maxValue = 100;

    /**
     * Максимальная цена за напиток.
     */
    int minPrice = 35;

    /**
     * Монета номеналом 10 рублей.
     */
    static final int TEN = 10;
    /**
     * Монета номеналом 5 рублей.
     */
    static final int FIVE = 5;
    /**
     * Монета номеналом 2 рубля.
     */
    static final int TWO = 2;
    /**
     * Монета номеналом 1 рубль.
     */
    static final int ONE = 1;

    /**
     * В автомате есть монеты номиналом 10 рублей.
     * @return да/нет
     */
    public boolean gotTens() {
        return true;
    }
    /**
     * В автомате есть монеты номиналом 5 рублей.
     * @return да/нет
     */
    public boolean gotFives() {
        return true;
    }
    /**
     * В автомате есть монеты номиналом 2 рубля.
     * @return да/нет
     */
    public boolean gotTwos() {
        return true;
    }
    /**
     * В автомате есть монеты номиналом 1 рубль.
     * @return да/нет
     */
    public boolean gotOnes() {
        return true;
    }

    /**
     * Метод для расчета минимального количества монет для сдачи.
     * @param value купюра
     * @param price цена напитка
     * @return массив монет
     */
  public int[] changes(int value, int price) {
      int counter = 0;
      int difference = value - price;
      int[] result = new int[maxValue - minPrice];
      while (difference > 0) {
          if (gotTens() && difference >= TEN) {
            difference -= TEN;
            result[counter] = TEN;
            counter++;
          } else if (gotFives() && difference >= FIVE) {
              difference -= FIVE;
              result[counter] = FIVE;
              counter++;
          } else if (gotTwos() && difference >= TWO) {
              difference -= TWO;
              result[counter] = TWO;
              counter++;
          } else if (gotOnes()) {
              difference -= ONE;
              result[counter] = ONE;
              counter++;
          }
      }
      return result;
    }
}
