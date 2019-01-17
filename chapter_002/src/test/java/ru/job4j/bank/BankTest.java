package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {

    /**
     * Test addUser.
     */
    @Test
    public void whenAddUserThenNewUser() {
        Bank test = new Bank();
        User user = new User("Bob", "123456789");
        test.addUser(user);
        assertThat(test.getBank().containsKey(user), is (true));
    }

    /**
     * Test deleteUser
     */
    @Test
    public void whenDeleteUserThenNoUser() {
        Bank test = new Bank();
        User user = new User("Bob", "123456789");
        test.addUser(user);
        User user2 = new User("Tom", "242300");
        test.addUser(user2);
        test.deleteUser(user);
        assertThat(test.getBank().containsKey(user), is (false));
    }

    /**
     * Test addAccountToUser.
     */
    @Test
    public void whenAddAccountThenNewAccount() {
        Bank test = new Bank();
        User user = new User("Bob", "123456789");
        Account account = new Account(8000, "111222333");
        test.addUser(user);
        test.addAccountToUser(user.getPassport(), account);
        assertThat(test.getUserAccounts(user.getPassport()).get(0).getRequisites(), is (account.getRequisites()));
    }

    /**
     * Test deleteAccountFromUser.
     */
    @Test
    public void whenDeleteAccountFromUserThenNoAccount() {
        Bank test = new Bank();
        User user = new User("Bob", "123456789");
        Account account = new Account(8000, "111222333");
        Account account2 = new Account(5024, "444555666");
        test.addUser(user);
        test.addAccountToUser(user.getPassport(), account);
        test.addAccountToUser(user.getPassport(), account2);
        test.deleteAccountFromUser(user.getPassport(), account);
        assertThat(test.getUserAccounts(user.getPassport()).get(0).getRequisites(), is (account2.getRequisites()));
    }

    /**
     * Test getUserAccounts.
     */
    @Test
    public void whenGetUserAccountsThenListOfAccounts() {
        Bank test = new Bank();
        User user = new User("Bob", "123456789");
        Account account = new Account(8000, "111222333");
        test.addUser(user);
        test.addAccountToUser(user.getPassport(), account);
        assertThat(test.getUserAccounts(user.getPassport()).get(0).toString(), is(account.toString()));
    }

    /**
     * Test transferMoney.
     */
    @Test
    public void whenTransferMoneyThenTheyAreAddedToDestAccount() {

    }

}