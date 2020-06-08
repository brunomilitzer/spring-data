package br.com.brunomilitzer.trainings.productdata.repository;

import br.com.brunomilitzer.trainings.productdata.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByEmailAndName(String email, String name);

    List<Customer> findByEmailLike(String email);
}
