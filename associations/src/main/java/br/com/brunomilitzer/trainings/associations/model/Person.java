package br.com.brunomilitzer.trainings.associations.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Long age;

    @OneToOne(mappedBy = "person")
    private License license;

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

    public Long getAge() {
        return this.age;
    }

    public void setAge(final Long age) {
        this.age = age;
    }

    public License getLicense() {
        return this.license;
    }

    public void setLicense(final License license) {
        this.license = license;
    }
}
