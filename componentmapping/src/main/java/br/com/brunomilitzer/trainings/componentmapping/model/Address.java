package br.com.brunomilitzer.trainings.componentmapping.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetaddress;

    private String city;

    private String state;

    private String zipcode;

    private String country;

    public String getStreetaddress() {
        return this.streetaddress;
    }

    public void setStreetaddress(final String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetaddress='" + this.streetaddress + '\'' +
                ", city='" + this.city + '\'' +
                ", zipcode='" + this.zipcode + '\'' +
                ", country='" + this.country + '\'' +
                '}';
    }
}
