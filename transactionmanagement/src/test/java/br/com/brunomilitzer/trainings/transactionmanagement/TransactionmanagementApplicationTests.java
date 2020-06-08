package br.com.brunomilitzer.trainings.transactionmanagement;

import br.com.brunomilitzer.trainings.transactionmanagement.services.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionmanagementApplicationTests {

    @Autowired
    private BankAccountService service;

    @Test
    void testTransfer() {
        this.service.transfer(500);
    }

}
