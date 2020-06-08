package br.com.brunomilitzer.trainings.hibernateinheritance.model.inheritence;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CreditCard extends Payment {

    private static final long serialVersionUID = 8803278208616405917L;

    @Column(name = "cardnumber")
    private String cardNumber;

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(final String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
