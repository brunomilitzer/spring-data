package br.com.brunomilitzer.trainings.patientscheduling.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Appointement implements Serializable {

    private static final long serialVersionUID = 914179182583101472L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    protected Timestamp appointementTime;

    private Boolean started;

    private Boolean ended;

    private String reason;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(final Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(final Doctor doctor) {
        this.doctor = doctor;
    }

    public Timestamp getAppointementTime() {
        return this.appointementTime;
    }

    public void setAppointementTime(final Timestamp appointementTime) {
        this.appointementTime = appointementTime;
    }

    public Boolean getStarted() {
        return this.started;
    }

    public void setStarted(final Boolean started) {
        this.started = started;
    }

    public Boolean getEnded() {
        return this.ended;
    }

    public void setEnded(final Boolean ended) {
        this.ended = ended;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Appointement{" +
                "id=" + this.id +
                ", patient=" + this.patient +
                ", doctor=" + this.doctor +
                ", appointementTime=" + this.appointementTime +
                ", started=" + this.started +
                ", ended=" + this.ended +
                ", reason='" + this.reason + '\'' +
                '}';
    }
}
