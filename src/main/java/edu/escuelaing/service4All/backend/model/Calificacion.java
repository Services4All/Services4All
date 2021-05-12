package edu.escuelaing.service4All.backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Column(name = "idusuario")
    private int idusuario;

    @Column(name = "idservicio")
    private int idservicio;
	
	@Column(name = "calificacion")
    private int calif;


    public Calificacion(int id, int idservicio, int idusuario, int calificacion) {
        this.id = id;
        this.idservicio = idservicio;
        this.idusuario = idusuario;
        this.calif = calificacion;
    }
    public Calificacion() {
    	
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public int getCalificacion() {
        return calif;
    }
    public void setCalificacion(int calificacion) {
        this.calif = calificacion;
    }
    public int getIdservicio() {
        return idservicio;
    }
    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

}

