package br.com.brunomilitzer.trainings.associations.repository;

import br.com.brunomilitzer.trainings.associations.model.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Long> {
}
