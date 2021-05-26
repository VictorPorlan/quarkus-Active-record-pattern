package edu.pingpong.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Espada extends PanacheEntity {
    @Column
    public String nombre;
    @Column
    public double longitud;

}
