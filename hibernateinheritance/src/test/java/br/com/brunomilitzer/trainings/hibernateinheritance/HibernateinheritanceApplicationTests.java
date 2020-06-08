package br.com.brunomilitzer.trainings.hibernateinheritance;

import br.com.brunomilitzer.trainings.hibernateinheritance.model.inheritence.Check;
import br.com.brunomilitzer.trainings.hibernateinheritance.model.inheritence.CreditCard;
import br.com.brunomilitzer.trainings.hibernateinheritance.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateinheritanceApplicationTests {

    @Autowired
    private PaymentRepository repository;

    @Test
    public void createPayment() {

        final CreditCard cc1 = new CreditCard();
        cc1.setCardNumber("123456");
        cc1.setAmmount(5000D);

        this.repository.save(cc1);
    }

    @Test
    public void createCheckPayment() {

        final Check ck1 = new Check();
        ck1.setCheckNumber("123456");
        ck1.setAmmount(1000D);

        this.repository.save(ck1);
    }
}
