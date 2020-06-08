package br.com.brunomilitzer.trainings.compositekey.model;

import br.com.brunomilitzer.trainings.compositekey.keys.CustomerId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
//@IdClass(CustomerId.class)
public class Customer {

    /*@Id
    private Long id;

    @Id
    private String email;*/

    @EmbeddedId
    CustomerId id;

    private String name;

    /*public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }*/

    public CustomerId getId() {
        return this.id;
    }

    public void setId(final CustomerId id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
