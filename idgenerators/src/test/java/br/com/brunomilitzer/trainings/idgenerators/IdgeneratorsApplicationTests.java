package br.com.brunomilitzer.trainings.idgenerators;

import br.com.brunomilitzer.trainings.idgenerators.model.Employee;
import br.com.brunomilitzer.trainings.idgenerators.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testCreateEmployee() {

        final Employee employee = new Employee();
        employee.setName("Tales de Garcez");

        this.employeeRepository.save(employee);
    }

}
