package br.com.brunomilitzer.trainings.patientscheduling.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Insurance {

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "copay")
    private Double copay;

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(final String providerName) {
        this.providerName = providerName;
    }

    public Double getCopay() {
        return this.copay;
    }

    public void setCopay(final Double copay) {
        this.copay = copay;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "providerName='" + this.providerName + '\'' +
                ", copay=" + this.copay +
                '}';
    }
}
