package br.com.brunomilitzer.trainings.compositekey.repository;

import br.com.brunomilitzer.trainings.compositekey.keys.CustomerId;
import br.com.brunomilitzer.trainings.compositekey.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, CustomerId> {
}
