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
    private Date creationdate;
	
	@Column(name = "reclamo")
    private String reclamo;

    
    public Reclamo() {
    	
    }
    public Reclamo( int idusuario,int idservicio, Date creationdate, String reclamo, int id) {
        this.idservicio= idservicio;
        this.idusuario = idusuario;
        this.reclamo = reclamo;
        this.creationdate = creationdate;
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public Date getCreatioDate() {
        return creationdate;
    }


    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
    
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public int getIdservicio() {
        return idservicio;
    }
   
}
