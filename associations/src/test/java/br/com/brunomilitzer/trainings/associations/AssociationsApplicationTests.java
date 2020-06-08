package br.com.brunomilitzer.trainings.associations;

import br.com.brunomilitzer.trainings.associations.model.*;
import br.com.brunomilitzer.trainings.associations.repository.CustomerRepository;
import br.com.brunomilitzer.trainings.associations.repository.LicenseRepository;
import br.com.brunomilitzer.trainings.associations.repository.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AssociationsApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    @Test
    public void createCustomer() {

        final PhoneNumber p1 = new PhoneNumber();
        p1.setNumber("12345678");
        p1.setType("Mobile");

        final PhoneNumber p2 = new PhoneNumber();
        p2.setNumber("55555555");
        p2.setType("Home");

        final Customer customer = new Customer();
        customer.setName("Vanessa de Garcez");

        customer.addPhoneNumber(p1);
        customer.addPhoneNumber(p2);

        this.customerRepository.save(customer);
    }

    @Test
    @Transactional
    public void testLoadCustomer() {
        assertTrue(this.customerRepository.findById(1L).isPresent());

        final Customer customer = this.customerRepository.findById(1L).get();

        System.out.println(customer);

        customer.getNumbers().forEach(System.out::println);
    }

    @Test
    public void testUpdateCustomer() {
        assertTrue(this.customerRepository.findById(1L).isPresent());

        final Customer customer = this.customerRepository.findById(1L).get();
        customer.setName("Bruno Militzer");
        customer.getNumbers().forEach(number -> number.setType("Cell"));

        this.customerRepository.save(customer);

        assertTrue(this.customerRepository.findById(1L).isPresent());

        final Customer updatedCustomer = this.customerRepository.findById(1L).get();


        System.out.println(updatedCustomer);
    }

    @Test
    public void testDelete() {
        this.customerRepository.deleteById(1L);
    }

    @Test
    public void createProgrammer() {
        final Programmer p1 = new Programmer();
        p1.setName("Bruno");
        p1.setSalary(6300L);

        final Programmer p2 = new Programmer();
        p2.setName("Igor");
        p2.setSalary(4300L);

        final Project proj1 = new Project();
        proj1.setName("Spring Data");

        final Project proj2 = new Project();
        proj2.setName("Spring Boot");

        final Project proj3 = new Project();
        proj3.setName("JDBC Servlets");

        p1.addProject(proj1);
        p1.addProject(proj2);
        p1.addProject(proj3);

        this.programmerRepository.save(p1);
    }

    @Test
    public void loadProgrammers() {
        assertTrue(this.programmerRepository.findById(2L).isPresent());

        final Programmer programmer = this.programmerRepository.findById(2L).get();

        System.out.println(programmer);
        System.out.println(programmer.getProjects());

    }

    @Test
    public void testCreateLicense() {
        final Person person = new Person();
        person.setFirstName("Bruno");
        person.setLastName("Militzer");
        person.setAge(42L);

        final License license = new License();
        license.setPerson(person);
        license.setType("Car");
        license.setValidDate(new Date());
        license.setValidTo(new Date());
        
        this.licenseRepository.save(license);
    }
}
