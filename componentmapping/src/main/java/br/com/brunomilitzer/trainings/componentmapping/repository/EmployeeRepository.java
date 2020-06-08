package br.com.brunomilitzer.trainings.componentmapping.repository;

import br.com.brunomilitzer.trainings.componentmapping.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
