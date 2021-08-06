package com.cenfotec.comiteolimpico.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Imc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date fechaCreacion;

    private double imc;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Atleta atleta;

    public Imc() {
    }

    public Imc(Date fechaCreacion, double imc, Atleta atleta) {

        this.fechaCreacion = fechaCreacion;
        this.imc = imc;
        this.atleta = atleta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
