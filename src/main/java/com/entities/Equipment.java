package com.entities;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "equipment",schema = "public")
public class Equipment {

    private int id;
    private String uin;
    private List<Transport> transports = new ArrayList<Transport>();

    public Equipment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "uin")
    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipment")
    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    @Override
    public String toString() {
        return this.getUin();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        if (this.getId() == equipment.getId()) {
            return true;
        }
        return false;
    }
}
