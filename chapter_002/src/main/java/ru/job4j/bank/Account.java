package ru.job4j.bank;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 23.01.19
 */
public class Account {

    /**
     * Хранит значение суммы денег на счете пользователя.
     */
    private double value;

    /**
     * Хранит реквезиты счета пользователя.
     */
    private String requisites;

    /**
     * Конструктор.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    /**
     * Метод осуществляет перевод средств на указанный счет.
     * @param destination целевой счет.
     * @param amount сумма перевода.
     * @return флаг операции (успешно/ неуспешно).
     */
    boolean transfer(Account destination, double amount) {
        boolean result = false;
        if (amount > 0 && amount <= this.value && destination != null) {
            this.value -= amount;
            destination.value += amount;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='"
                + requisites + '\''
                + '}';
    }
}
