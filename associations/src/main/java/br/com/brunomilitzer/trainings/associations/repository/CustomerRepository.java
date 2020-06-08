package br.com.brunomilitzer.trainings.associations.repository;

import br.com.brunomilitzer.trainings.associations.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
