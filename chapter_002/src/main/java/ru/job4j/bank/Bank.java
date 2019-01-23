package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 23.01.19
 */
public class Bank {

    /**
     * Коллекция типа "карта", хранит пользователей и их счета.
     */
    private Map<User, List<Account>> bank = new TreeMap<>();

    /**
     * Метод добавляет нового пользователя.
     * @param user новый пользователь.
     */
    public void addUser(User user) {
        try {
            this.bank.put(user, new ArrayList<>());
        } catch (NullPointerException e) {
            System.out.println("User is null");
        }
    }

    /**
     * Метод удаяет пользователя.
     * @param user пользователь для удаления.
     */
    public void deleteUser(User user) {
        try {
            this.bank.remove(user);
        } catch (NullPointerException e) {
            System.out.println("User not found");
        }
    }

    /**
     * Метод добавляет новый счет пользоватею.
     * @param passport номер паспорта пользователя.
     * @param account счет пользователя.
     */
    public void addAccountToUser(String passport, Account account) {
        User user = getUserByPassport(passport);
        if (user != null && account != null) {
            this.bank.get(user).add(account);
        }
    }

    /**
     * Метод удаляет счет пользователя.
     * @param passport номер паспорта пользователя.
     * @param account счет пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUserByPassport(passport);
        if (user != null && account != null) {
            this.bank.get(user).remove(account);
        }
    }

    /**
     * Метод получает список всех считов пользователя.
     * @param passport номер паспорта пользователя.
     * @return список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = null;
        User user = getUserByPassport(passport);
        if (user != null) {
            accounts = this.bank.get(user);
        }
        return accounts;
    }

    /**
     * Метод осуществляет перевод средств с одного счета на другой.
     * @param srcPassport номер паспорта пользователя отправителя.
     * @param srcRequisite реквезиты счета отправителя.
     * @param destPassport номер паспорта пользователя получателя.
     * @param dstRequisite реквезиты счета получателя.
     * @param amount сумма перевода.
     * @return флаг операции (успешно / неуспешно)
     */
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

    /**
     * Метод предоставляет доступ к пользователям и их считам.
     * @return коллекция типа "карта".
     */
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

    /**
     * Метод находит пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя.
     * @return искомый пользователь.
     */
    public User getUserByPassport(String passport) {
        User user = null;
        for (User userFromBank : bank.keySet()) {
            if (userFromBank.getPassport().equals(passport)) {
                user = userFromBank;
            }
        }
        return user;
    }

    /**
     * Метод находит счет пользователя по номеру паспорта и реквезитам счета.
     * @param passport номер паспорта пользователя.
     * @param requisite номер счета пользователя.
     * @return счет пользователя.
     */
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
