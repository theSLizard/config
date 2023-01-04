package io.space4.config.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//import javax.persistence.*;


@Entity
public class PlainKeyValueStore {

    public PlainKeyValueStore() {
    }

    public PlainKeyValueStore(Long id, String s4name, String s4value) {
        this.id = id;
        this.s4name = s4name;
        this.s4value = s4value;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getS4name() {
        return s4name;
    }

    public void setS4name(String s4name) {
        this.s4name = s4name;
    }

    public String getS4value() {
        return s4value;
    }

    public void setS4value(String s4value) {
        this.s4value = s4value;
    }

    @Override
    public String toString() {
        return "PlainKeyValueStore{" +
                "id=" + id +
                ", key='" + s4name + '\'' +
                ", value='" + s4value + '\'' +
                '}';
    }

    private String s4name;
    private String s4value;

    // standard constructors / setters / getters / toString

}