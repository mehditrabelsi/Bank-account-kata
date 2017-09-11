package tn.wevioo.kataBank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import tn.wevioo.kataBank.entities.Account;
import tn.wevioo.kataBank.entities.Operation;
import tn.wevioo.kataBank.entities.TypeOperation;
import tn.wevioo.kataBank.exception.AccountNotFoundException;
import tn.wevioo.kataBank.exception.AmountLowerThanBalance;
import tn.wevioo.kataBank.exception.AmountMinMaxValueException;

/**
 * Impl Service of operation
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 * @see OperationService for more informations about methods
 */
public class OperationServiceImpl implements OperationService {
	private static final Logger logger = Logger.getLogger("MyLog");
	private static final double MIN_VALUE = 0;
	private static final double MAX_VALUE = 999999999;

	@SuppressWarnings("unused")
	@Override
	public boolean deposit(Account account, double amount)
			throws AccountNotFoundException, AmountMinMaxValueException {
		logger.info("deposit : " + account.toString() + " | amount : " + amount);

		// testing if the account is NULL
		if (account == null) {
			throw new AccountNotFoundException("There is no account !");

		} else { // the amount must be positive
			if (amount <= MIN_VALUE || amount > MAX_VALUE) {
				throw new AmountMinMaxValueException(
						"Please enter a valid amount");

			} else { // if the amount is valid, let's do the operation
				Operation operation = new Operation();
				account.setBalance(account.getBalance() + amount);

				// Auto-increment NumOperation
				operation.setNumOperation(account.getOperations().size() + 1);
				operation.setAmount(amount);
				operation.setBalance(account.getBalance());
				operation.setDate(LocalDate.now());
				operation.setType(TypeOperation.Deposit);

				// save operation in account history
				account.getOperations().add(operation);

				return true;
			}
		}
	}

	@SuppressWarnings("unused")
	@Override
	public boolean retrive(Account account, double amount)
			throws AccountNotFoundException, AmountLowerThanBalance,
			AmountMinMaxValueException {
		logger.info("retrive : " + account.toString() + " | amount : " + amount);
		// testing if the account is NULL
		if (account == null) {
			throw new AccountNotFoundException("There is no account !");
		} else { // the amount should be lower than account's balance
			if (amount > account.getBalance()) {
				throw new AmountLowerThanBalance("Please introduce an amount lower than your balance : <"
								+ account.getBalance());
				
				
				// the amount should be positive
			} else if (amount <= MIN_VALUE || amount > MAX_VALUE) {
				throw new AmountMinMaxValueException(
						"Please enter a valid amount");

			} else { // if the amount is valid, let's do the operation
				Operation operation = new Operation();
				account.setBalance(account.getBalance() - amount);

				// Auto-increment NumOperation
				operation.setNumOperation(account.getOperations().size() + 1);
				operation.setAmount(amount);
				operation.setBalance(account.getBalance());
				operation.setDate(LocalDate.now());
				operation.setType(TypeOperation.Withdrawal);

				// save operation in account history
				account.getOperations().add(operation);

				return true;
			}
		}
	}

	@Override
	public void history(Account account) throws AccountNotFoundException {
		logger.info("history : " + account.toString());

		// testing if the account is NULL
		if (account == null) {
			throw new AccountNotFoundException("There is no account !");}
		else {
			List<Operation> allOperations = account.getOperations();
			System.out.println("* * * * * * * * H I S T O R Y * * * * * * * *");
			System.out
					.println("Num | Operation type | Date      | Amount  | Balance   ");
			allOperations.stream().forEach(
					operation -> {
						System.out.println(operation.getNumOperation()
								+ "   | " + operation.getType() + "        | "
								+ operation.getDate() + "| "
								+ operation.getAmount() + "    | "
								+ operation.getBalance());
					});
		}
	}
}
