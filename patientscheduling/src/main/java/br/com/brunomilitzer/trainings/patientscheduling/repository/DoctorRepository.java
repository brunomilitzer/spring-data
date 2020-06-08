package br.com.brunomilitzer.trainings.patientscheduling.repository;

import br.com.brunomilitzer.trainings.patientscheduling.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
