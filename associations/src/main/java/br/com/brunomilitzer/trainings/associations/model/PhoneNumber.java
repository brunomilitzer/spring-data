package br.com.brunomilitzer.trainings.associations.model;

import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + this.id +
                ", number='" + this.number + '\'' +
                ", type='" + this.type + '\'' +
                ", customer=" + this.customer +
                '}';
    }
}
