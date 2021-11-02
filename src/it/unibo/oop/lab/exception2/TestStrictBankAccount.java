package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	public static final int TRANSACTIONS = 15;
	
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	AccountHolder mrossi = new AccountHolder("Mario", "Rossi", 1);
    	AccountHolder lverdi = new AccountHolder("Luigi", "Verdi", 2);
    	BankAccount marioBA = new StrictBankAccount(1, 10000, 10);
    	BankAccount luigiBA = new StrictBankAccount(2, 10000, 10);
    	try {
    		marioBA.deposit(lverdi.getUserID(), 2000);
	    	Assert.fail();
    	} catch(WrongAccountHolderException e) {
    		assertNotNull(e.getMessage());
    		System.out.println(e.getMessage());
    	}
    	try {	
	    	for(int i = 0; i < TRANSACTIONS; i++) {
	    		luigiBA.depositFromATM(lverdi.getUserID(), 100);
	    		System.out.println(lverdi.getName() + " " + lverdi.getSurname() + ": " + luigiBA.getBalance());
	    	}
	    	Assert.fail();
    	} catch (TransactionsOverQuotaException e) {
    		assertNotNull(e.getMessage());
    		System.out.println(e.getMessage());
    	}
    	try {
    		marioBA.withdraw(mrossi.getUserID(), 12000);
    		Assert.fail();
    	} catch(NotEnoughFundsException e) {
    		assertNotNull(e.getMessage());
    		System.out.println(e.getMessage());
    	}
    }
}
