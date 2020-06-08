package br.com.brunomilitzer.trainings.filedata.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Arrays;

@Entity
public class Image {

    @Id
    private Long id;

    private String name;

    @Lob
    private byte[] data;

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

    public byte[] getData() {
        return this.data;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", data=" + Arrays.toString(this.data) +
                '}';
    }
}
