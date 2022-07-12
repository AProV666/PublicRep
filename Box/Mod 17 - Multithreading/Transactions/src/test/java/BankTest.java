import junit.framework.TestCase;
import org.junit.Test;

public class BankTest extends TestCase {

    Bank bank;
    Account account1;
    Account account2;
    Account account3;

    @Override
    protected void setUp() throws Exception {

        bank = new Bank();
        account1 = new Account(100000, "111");
        account2 = new Account(90000, "222");
        account3 = new Account(80000, "333");

        bank.setAccounts(account1);
        bank.setAccounts(account2);
        bank.setAccounts(account3);
    }

    @Test
    public void testGetBalance() {
        long actual = bank.getBalance("111");
        long expected = 100000;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSumAllAccounts() {
        long actual = bank.getSumAllAccounts();
        long expected = 270000;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransfer1() {
        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 25000);
        long actual = bank.getBalance(account1.getAccNumber());
        long expected = 75000;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransfer2() {
        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 25000);
        long actual = bank.getBalance(account2.getAccNumber());
        long expected = 115000;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransfer3() {
        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 25000);
        long actual = bank.getSumAllAccounts();
        long expected = 270000;
        assertEquals(expected, actual);
    }
}
