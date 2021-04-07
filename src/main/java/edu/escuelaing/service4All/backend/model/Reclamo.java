package edu.escuelaing.service4All.backend.model;



import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reclamo")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="idservicio")
    private int idservicio;
	@Column(name = "idusuario")
    private int idusuario;
	
	@Column(name = "creationdate")
    private Date fecha;
	
	@Column(name = "reclamo")
    private String reclamo;

    public Reclamo(int idservicio, int idusuario, Date fecha, String reclamo, int id) {
        this.idservicio= idservicio;
        this.idusuario = idusuario;
        this.reclamo = reclamo;
        this.fecha = fecha;
        this.id = id;
    }
    public Reclamo() {
    	
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

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
