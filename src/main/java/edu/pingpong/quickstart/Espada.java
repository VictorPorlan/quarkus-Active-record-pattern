package edu.pingpong.quickstart;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;

@Entity
public class Espada extends PanacheEntity {
    @Column(unique = true)
    public String nombre;
    @Column
    public double longitud;

}
