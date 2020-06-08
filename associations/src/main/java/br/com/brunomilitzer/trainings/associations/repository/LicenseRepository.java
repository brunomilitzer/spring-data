package br.com.brunomilitzer.trainings.associations.repository;

import br.com.brunomilitzer.trainings.associations.model.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
}
