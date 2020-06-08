package br.com.brunomilitzer.trainings.associations.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<Programmer> programmers;

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

    public Set<Programmer> getProgrammers() {
        return this.programmers;
    }

    public void setProgrammers(final Set<Programmer> programmers) {
        this.programmers = programmers;
    }

    public void addProgrammer(final Programmer programmer) {

        if (this.programmers == null) {
            this.programmers = new HashSet<>();
        }

        this.programmers.add(programmer);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                '}';
    }
}
