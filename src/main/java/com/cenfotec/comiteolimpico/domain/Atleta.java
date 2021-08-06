package com.cenfotec.comiteolimpico.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechNacimiento;
    private String deporte;
    private double estatura;
    private double peso;
    private String categoria;
    private String direccion;
    private String provincia;
    private String canton;
    private String distrito;
    private String telefono;
    private String email;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="imc")
    private Set<Imc> imc;

    public Atleta() {


    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechNacimiento() {
        return fechNacimiento;
    }

    public void setFechNacimiento(Date fechNacimiento) {
        this.fechNacimiento = fechNacimiento;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Imc> getImc() {
        return imc;
    }

    public void setImc(Set<Imc> imc) {
        this.imc = imc;
    }

}
