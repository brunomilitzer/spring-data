package br.com.brunomilitzer.trainings.idgenerators.repository;

import br.com.brunomilitzer.trainings.idgenerators.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
