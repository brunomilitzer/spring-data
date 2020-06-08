package br.com.brunomilitzer.trainings.productdata;

import br.com.brunomilitzer.trainings.productdata.model.Customer;
import br.com.brunomilitzer.trainings.productdata.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByEmailAndName() {
        final List<Customer> customers = this.customerRepository.findByEmailAndName("email@email.com", "Simon Says");

        customers.forEach(System.out::println);
    }

    @Test
    public void findByEmailLike() {
        final List<Customer> customers = this.customerRepository.findByEmailLike("%@%");

        customers.forEach(System.out::println);
    }
}
