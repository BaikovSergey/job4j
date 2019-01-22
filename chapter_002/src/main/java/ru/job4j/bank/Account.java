package ru.job4j.bank;

public class Account {

    private double value;
    private String requisites;

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
