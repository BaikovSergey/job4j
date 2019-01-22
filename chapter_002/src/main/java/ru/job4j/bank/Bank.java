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
        User user = getUserByPassport(passport);
        if (user != null && account != null) {
            this.bank.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUserByPassport(passport);
        this.bank.get(user).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        User user = getUserByPassport(passport);
        return this.bank.get(user);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = getAccountByPassportAndRequisite(srcPassport, srcRequisite);
        Account destAccount = getAccountByPassportAndRequisite(destPassport, dstRequisite);
        if (this.bank.get(getUserByPassport(srcPassport)).contains(srcAccount)
                && srcAccount != null
                && this.bank.get(getUserByPassport(destPassport)).contains(destAccount)
                && destAccount != null) {
            srcAccount.transfer(destAccount, amount);
            result = true;
        }
        return result;
    }

    public Map<User, List<Account>> getBank() {
        return this.bank;
    }

    @Override
    public String toString() {
        return "Bank{"
                + "bank="
                + bank
                + '}';
    }

    public User getUserByPassport(String passport) {
        User user = null;
        for (User userFromBank : bank.keySet()) {
            if (userFromBank.getPassport().equals(passport)) {
                user = userFromBank;
            }
        }
        return user;
    }

    public Account getAccountByPassportAndRequisite(String passport, String requisite) {
        Account account = null;
        User user = getUserByPassport(passport);
        for (Account userAccount : bank.get(user)) {
            if (userAccount.getRequisites().equals(requisite)) {
                account = userAccount;
            }
        }
        return account;
    }
}
