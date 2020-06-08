package br.com.brunomilitzer.trainings.associations.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_date")
    private Date validDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "valid_to")
    private Date validTo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Date getValidDate() {
        return this.validDate;
    }

    public void setValidDate(final Date validDate) {
        this.validDate = validDate;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(final Date validTo) {
        this.validTo = validTo;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }
}
