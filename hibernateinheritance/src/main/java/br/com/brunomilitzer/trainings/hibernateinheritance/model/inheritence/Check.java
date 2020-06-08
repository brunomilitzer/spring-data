package br.com.brunomilitzer.trainings.hibernateinheritance.model.inheritence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bankcheck")
public class Check extends Payment {

    private static final long serialVersionUID = 7547067426382287714L;

    @Column(name = "checknumber")
    private String checkNumber;

    public String getCheckNumber() {
        return this.checkNumber;
    }

    public void setCheckNumber(final String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
