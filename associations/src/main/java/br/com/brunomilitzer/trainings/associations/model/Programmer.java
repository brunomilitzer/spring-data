package br.com.brunomilitzer.trainings.associations.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "programer_project", joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;

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

    public Long getSalary() {
        return this.salary;
    }

    public void setSalary(final Long salary) {
        this.salary = salary;
    }

    public Set<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(final Set<Project> projects) {
        this.projects = projects;
    }

    public void addProject(final Project project) {

        if (this.projects == null) {
            this.projects = new HashSet<>();
        }

        this.projects.add(project);
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", salary=" + this.salary +
                '}';
    }
}
