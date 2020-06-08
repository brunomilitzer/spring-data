package br.com.brunomilitzer.trainings.idgenerators.repository;

import br.com.brunomilitzer.trainings.idgenerators.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
