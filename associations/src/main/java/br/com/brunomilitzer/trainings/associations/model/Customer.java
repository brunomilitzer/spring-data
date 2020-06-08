package br.com.brunomilitzer.trainings.associations.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PhoneNumber> numbers;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<PhoneNumber> getNumbers() {
        return this.numbers;
    }

    public void setNumbers(final Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public void addPhoneNumber(final PhoneNumber number) {

        if (this.numbers == null) {
            this.numbers = new HashSet<>();
        }

        number.setCustomer(this);
        this.numbers.add(number);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                '}';
    }
}
