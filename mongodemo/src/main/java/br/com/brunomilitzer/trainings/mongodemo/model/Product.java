package br.com.brunomilitzer.trainings.mongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private String id;

    private String name;

    private Float price;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(final Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                '}';
    }
}
