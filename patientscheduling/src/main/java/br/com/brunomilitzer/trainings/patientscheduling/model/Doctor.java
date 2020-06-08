package br.com.brunomilitzer.trainings.patientscheduling.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Doctor implements Serializable {

    private static final long serialVersionUID = 4122385077613336535L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialty")
    private String specialty;

    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;

    @OneToMany
    private List<Appointement> appointements;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(final String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(final List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointement> getAppointements() {
        return this.appointements;
    }

    public void setAppointements(final List<Appointement> appointements) {
        this.appointements = appointements;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + this.id +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", specialty='" + this.specialty + '\'' +
                '}';
    }
}
