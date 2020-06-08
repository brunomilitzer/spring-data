package br.com.brunomilitzer.trainings.hibernateinheritance.repository;

import br.com.brunomilitzer.trainings.hibernateinheritance.model.inheritence.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
