package edu.pingpong.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Espada")
public class Espada extends PanacheEntity {
    @Column
    public String nombre;
    @Column
    public Float longitud;

    public Espada(String nombre, Float longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
    }

    public Espada() {
    }

    public String getNombre() {
        return nombre;
    }

    public double getLongitud() {
        return longitud;
    }
}
