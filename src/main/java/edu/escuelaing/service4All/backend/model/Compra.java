package edu.escuelaing.service4All.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "idservicio")
    private int idservicio;
    @Column(name = "idusuario")
    private int idusuario;
    @Column(name = "Valor")
    private int valor;
    @Column(name = "creationdate")
    private Date creationdate;

    public Compra(int idServicio, int idComprador, int valor, Date fecha ) {
        this.idservicio = idServicio;
        this.idusuario = idComprador;
        this.valor = valor;
        this.creationdate = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}
