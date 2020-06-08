package br.com.brunomilitzer.trainings.jpqlandnativesql.model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "score")
    private Long score;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public Long getScore() {
        return this.score;
    }

    public void setScore(final Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", lastName='" + this.lastName + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", score=" + this.score +
                '}';
    }
}
