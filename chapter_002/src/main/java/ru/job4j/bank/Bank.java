package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    private Map<User, List<Account>> bank = new TreeMap<>();

    public void addUser(User user) {
        this.bank.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.bank.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = getUserByPasport(passport);
        this.bank.get(user).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUserByPasport(passport);
        this.bank.get(user).remove(account);
    }

    public List<Account> getUserAccounts (String passport) {
        User user = getUserByPasport(passport);
        return this.bank.get(user);
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        if (this.bank.get(srcPassport) != null && this.bank.get(srcPassport).contains(getUserAccounts(srcPassport)) && this.bank.get(destPassport) != null && this.bank.get(srcPassport).contains(srcRequisite) ) {

        }
        return result;
    }

    public Map<User, List<Account>> getBank() {
        return this.bank;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bank=" + bank +
                '}';
    }

    public User getUserByPasport(String passport) {
        User user = null;
        for (User userFromBank : bank.keySet()) {
            if (userFromBank.getPassport().equals(passport)) {
                user = userFromBank;
            }
        }
        return user;
    }

    public User getUserByName(String name) {
        User user = null;
        for (User userFromBank : bank.keySet()) {
            if (userFromBank.getName().equals(name)) {
                user = userFromBank;
            }
        }
        return user;
    }
}
