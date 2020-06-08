package br.com.brunomilitzer.trainings.patientscheduling.repository;

import br.com.brunomilitzer.trainings.patientscheduling.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
