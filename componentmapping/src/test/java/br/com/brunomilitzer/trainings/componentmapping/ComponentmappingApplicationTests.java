package br.com.brunomilitzer.trainings.componentmapping;

import br.com.brunomilitzer.trainings.componentmapping.model.Address;
import br.com.brunomilitzer.trainings.componentmapping.model.Employee;
import br.com.brunomilitzer.trainings.componentmapping.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentmappingApplicationTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void testCreate() {
        final Address address = new Address();
        address.setStreetaddress("Farranlea Road");
        address.setCity("Cork");
        address.setState("Cork");
        address.setCountry("Ireland");
        address.setZipcode("112222");

        final Employee employee = new Employee();
        employee.setId(123L);
        employee.setName("Vanessa");
        employee.setAddress(address);

        this.repository.save(employee);
    }
}
