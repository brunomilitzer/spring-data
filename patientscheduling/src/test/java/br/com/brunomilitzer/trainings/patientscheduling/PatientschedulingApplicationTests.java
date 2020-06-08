package br.com.brunomilitzer.trainings.patientscheduling;

import br.com.brunomilitzer.trainings.patientscheduling.model.Appointement;
import br.com.brunomilitzer.trainings.patientscheduling.model.Doctor;
import br.com.brunomilitzer.trainings.patientscheduling.model.Insurance;
import br.com.brunomilitzer.trainings.patientscheduling.model.Patient;
import br.com.brunomilitzer.trainings.patientscheduling.repository.AppointementRepository;
import br.com.brunomilitzer.trainings.patientscheduling.repository.DoctorRepository;
import br.com.brunomilitzer.trainings.patientscheduling.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
class PatientschedulingApplicationTests {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointementRepository appointementRepository;

    @Test
    void testCreateDoctor() {
        final Doctor doctor = new Doctor();
        doctor.setFirstName("Araci");
        doctor.setLastName("Vaz Calado");
        doctor.setSpecialty("Orthopedist");

        this.doctorRepository.save(doctor);
    }

    @Test
    void testCreatePatient() {
        final Insurance insurance = new Insurance();
        insurance.setCopay(20D);
        insurance.setProviderName("AIG");

        final Doctor doctor = this.doctorRepository.findById(1L).get();

        final Patient patient = new Patient();
        patient.setFirstName("Bruno");
        patient.setLastName("Militzer");
        patient.setPhone("12345678");
        patient.setInsurance(insurance);
        patient.addDoctor(doctor);

        this.patientRepository.save(patient);
    }

    @Test
    void testCreateAppointement() {
        final Doctor doctor = this.doctorRepository.findById(1L).get();
        final Patient patient = this.patientRepository.findById(1L).get();

        final Appointement appointement = new Appointement();
        appointement.setReason("New appointement");
        appointement.setDoctor(doctor);
        appointement.setPatient(patient);
        appointement.setStarted(true);
        appointement.setEnded(false);
        appointement.setAppointementTime(Timestamp.valueOf(LocalDateTime.now()));

        this.appointementRepository.save(appointement);

    }
}
