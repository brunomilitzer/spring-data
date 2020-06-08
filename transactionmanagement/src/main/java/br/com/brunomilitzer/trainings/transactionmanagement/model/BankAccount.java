package br.com.brunomilitzer.trainings.transactionmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

    @Id
    private Long accno;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "bal")
    private Long balance;

    public Long getAccno() {
        return this.accno;
    }

    public void setAccno(final Long accno) {
        this.accno = accno;
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

    public Long getBalance() {
        return this.balance;
    }

    public void setBalance(final Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accno=" + this.accno +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", balance=" + this.balance +
                '}';
    }
}
