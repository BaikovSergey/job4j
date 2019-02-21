package ru.job4j.coffeemachine;

import java.util.Arrays;

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
     * Номиналы монет.
     */
    private int[] denominations = {10, 5, 2, 1};

    /**
     * Получение номиналов монет.
     * @return список номиналов
     */
    public int[] getDenominations() {
        return denominations;
    }

    /**
     * Установка номиналов монет.
     * @param denominations список номиналов
     */
    public void setDenominations(int[] denominations) {
        this.denominations = denominations;
    }

    /**
     * Метод для расчета минимального количества монет для сдачи.
     * @param value купюра
     * @param price цена напитка
     * @return массив монет
     */
  public int[] changes(int value, int price) {
      int counter = 0;
      int index = 0;
      int difference = value - price;
      int[] denominations = getDenominations();
      int[] result = new int[maxValue - minPrice];
      while (difference > 0) {
          if (difference >= denominations[index]) {
              difference -= denominations[index];
              result[counter] = denominations[index];
             counter++;
          } else {
              index++;
          }
      }
      return Arrays.copyOf(result, counter);
    }
}
