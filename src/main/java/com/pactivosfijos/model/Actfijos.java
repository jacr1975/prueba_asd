/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "actfijos", catalog = "jpa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Actfijos.findAll", query = "SELECT a FROM Actfijos a")
    , @NamedQuery(name = "Actfijos.findBySerial", query = "SELECT a FROM Actfijos a WHERE a.serial = :serial")
    , @NamedQuery(name = "Actfijos.findBySerialNII", query = "SELECT a FROM Actfijos a WHERE a.serialNII = :serialNII")
    , @NamedQuery(name = "Actfijos.findByNombre", query = "SELECT a FROM Actfijos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actfijos.findByDescripcion", query = "SELECT a FROM Actfijos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Actfijos.findByTipo", query = "SELECT a FROM Actfijos a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Actfijos.findByPeso", query = "SELECT a FROM Actfijos a WHERE a.peso = :peso")
    , @NamedQuery(name = "Actfijos.findByAlto", query = "SELECT a FROM Actfijos a WHERE a.alto = :alto")
    , @NamedQuery(name = "Actfijos.findByAncho", query = "SELECT a FROM Actfijos a WHERE a.ancho = :ancho")
    , @NamedQuery(name = "Actfijos.findByLargo", query = "SELECT a FROM Actfijos a WHERE a.largo = :largo")
    , @NamedQuery(name = "Actfijos.findByValorcompra", query = "SELECT a FROM Actfijos a WHERE a.valorcompra = :valorcompra")
    , @NamedQuery(name = "Actfijos.findByFechacompra", query = "SELECT a FROM Actfijos a WHERE a.fechacompra = :fechacompra")
    , @NamedQuery(name = "Actfijos.findByFechabaja", query = "SELECT a FROM Actfijos a WHERE a.fechabaja = :fechabaja")
    , @NamedQuery(name = "Actfijos.findByEstadoactual", query = "SELECT a FROM Actfijos a WHERE a.estadoactual = :estadoactual")
    , @NamedQuery(name = "Actfijos.findByColor", query = "SELECT a FROM Actfijos a WHERE a.color = :color")
    , @NamedQuery(name = "Actfijos.findByIdPer2", query = "SELECT a FROM Actfijos a WHERE a.idPer2 = :idPer2")
    , @NamedQuery(name = "Actfijos.findByIdArea2", query = "SELECT a FROM Actfijos a WHERE a.idArea2 = :idArea2")})
public class Actfijos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Serial")
    private Integer serial;
    @Column(name = "SerialNII")
    private Integer serialNII;
    @Size(max = 40)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 15)
    @Column(name = "Tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Peso")
    private Double peso;
    @Column(name = "Alto")
    private Double alto;
    @Column(name = "Ancho")
    private Double ancho;
    @Column(name = "Largo")
    private Double largo;
    @Column(name = "Valor_compra")
    private Double valorcompra;
    @Column(name = "Fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechacompra;
    @Column(name = "Fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechabaja;
    @Size(max = 20)
    @Column(name = "Estado_actual")
    private String estadoactual;
    @Size(max = 20)
    @Column(name = "Color")
    private String color;
    @Column(name = "IdPer2")
    private Integer idPer2;
    @Column(name = "IdArea2")
    private Integer idArea2;

    public Actfijos() {
    }

    public Actfijos(Integer serial) {
        this.serial = serial;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Integer getSerialNII() {
        return serialNII;
    }

    public void setSerialNII(Integer serialNII) {
        this.serialNII = serialNII;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(Double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public String getEstadoactual() {
        return estadoactual;
    }

    public void setEstadoactual(String estadoactual) {
        this.estadoactual = estadoactual;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIdPer2() {
        return idPer2;
    }

    public void setIdPer2(Integer idPer2) {
        this.idPer2 = idPer2;
    }

    public Integer getIdArea2() {
        return idArea2;
    }

    public void setIdArea2(Integer idArea2) {
        this.idArea2 = idArea2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actfijos)) {
            return false;
        }
        Actfijos other = (Actfijos) object;
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.websystique.springmvc.model.Actfijos[ serial=" + serial + " ]";
    }
    
}
