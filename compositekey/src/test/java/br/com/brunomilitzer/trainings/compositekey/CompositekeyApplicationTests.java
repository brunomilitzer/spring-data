package br.com.brunomilitzer.trainings.compositekey;

import br.com.brunomilitzer.trainings.compositekey.keys.CustomerId;
import br.com.brunomilitzer.trainings.compositekey.model.Customer;
import br.com.brunomilitzer.trainings.compositekey.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompositekeyApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testCreateCustomer() {
        /*final Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("email@email.com");
        customer.setName("Vanessa de Garcez");

        this.repository.save(customer);*/
    }

    @Test
    public void testCreateCustomerEmbeded() {
        final CustomerId id = new CustomerId();
        id.setId(2L);
        id.setEmail("email@email.com");

        final Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Vanessa de Garcez");

        this.repository.save(customer);
    }
}