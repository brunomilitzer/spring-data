package br.com.brunomilitzer.trainings.compositekey.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerId implements Serializable {

    private static final long serialVersionUID = 8289076509774100527L;

    private Long id;

    private String email;

    public Long getId() {
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
    }
}
