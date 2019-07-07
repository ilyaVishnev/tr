package com.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "vehicle",schema = "public")
public class Transport {

    private int id;
    private String stateNumber;
    private Equipment equipment;
    private Park park;

    public Transport() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_gen")
    @SequenceGenerator(name = "my_seq_gen", sequenceName = "GEN_SEQUENCE")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "state_number")
    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_e", referencedColumnName = "id")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_p", referencedColumnName = "id")
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    @Override
    public String toString() {
        return this.getStateNumber();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        if (this.getId() == transport.getId()) {
            return true;
        }
        return false;
    }
}
