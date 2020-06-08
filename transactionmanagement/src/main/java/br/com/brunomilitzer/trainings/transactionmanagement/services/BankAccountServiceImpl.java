package br.com.brunomilitzer.trainings.transactionmanagement.services;

import br.com.brunomilitzer.trainings.transactionmanagement.model.BankAccount;
import br.com.brunomilitzer.trainings.transactionmanagement.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    @Override
    @Transactional
    public void transfer(final Integer ammount) {

        final Optional<BankAccount> account1 = this.repository.findById(1L);
        final Optional<BankAccount> account2 = this.repository.findById(2L);

        BankAccount acc1 = null;
        BankAccount acc2 = null;

        if (account1.isPresent()) {
            acc1 = account1.get();
        }

        if (account2.isPresent()) {
            acc2 = account2.get();
        }

        if (acc1 != null) {
            acc1.setBalance(acc1.getBalance() - ammount);
            this.repository.save(acc1);
        }

        if (true) {
            throw new RuntimeException();
        }

        if (acc2 != null) {
            acc2.setBalance(acc2.getBalance() + ammount);
            this.repository.save(acc2);
        }

    }
}
