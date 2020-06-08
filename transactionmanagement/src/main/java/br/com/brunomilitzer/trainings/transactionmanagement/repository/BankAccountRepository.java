package br.com.brunomilitzer.trainings.transactionmanagement.repository;

import br.com.brunomilitzer.trainings.transactionmanagement.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
