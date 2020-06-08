package br.com.brunomilitzer.trainings.idgenerators.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")*/
    @GenericGenerator(name = "emp_id", strategy = "br.com.brunomilitzer.trainings.idgenerators.model.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    private Long id;

    private String name;

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
}
