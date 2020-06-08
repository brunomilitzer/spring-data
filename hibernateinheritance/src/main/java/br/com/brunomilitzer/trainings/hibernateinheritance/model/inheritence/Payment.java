package br.com.brunomilitzer.trainings.hibernateinheritance.model.inheritence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment implements Serializable {

    private static final long serialVersionUID = 7432389933246280309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private Double ammount;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Double getAmmount() {
        return this.ammount;
    }

    public void setAmmount(final Double ammount) {
        this.ammount = ammount;
    }
}
