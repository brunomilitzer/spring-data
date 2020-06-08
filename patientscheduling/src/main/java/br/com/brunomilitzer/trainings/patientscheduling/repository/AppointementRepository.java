package br.com.brunomilitzer.trainings.patientscheduling.repository;

import br.com.brunomilitzer.trainings.patientscheduling.model.Appointement;
import org.springframework.data.repository.CrudRepository;

public interface AppointementRepository extends CrudRepository<Appointement, Long> {
}
