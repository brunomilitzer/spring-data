package br.com.brunomilitzer.trainings.patientscheduling.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient implements Serializable {

    private static final long serialVersionUID = 7021766786045258796L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Embedded
    private Insurance insurance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patients_doctors", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"))
    private List<Doctor> doctors;

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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Insurance getInsurance() {
        return this.insurance;
    }

    public void setInsurance(final Insurance insurance) {
        this.insurance = insurance;
    }

    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    public List<Appointement> getAppointements() {
        return this.appointements;
    }

    public void setAppointements(final List<Appointement> appointements) {
        this.appointements = appointements;
    }

    public void addDoctor(final Doctor doctor) {

        if (this.doctors == null) {
            this.doctors = new ArrayList<>();
        }

        this.doctors.add(doctor);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + this.id +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", phone='" + this.phone + '\'' +
                ", insurance=" + this.insurance +
                '}';
    }
}
