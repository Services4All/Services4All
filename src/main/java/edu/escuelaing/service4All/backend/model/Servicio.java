package edu.escuelaing.service4all.backend.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="servicio")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name = "idusuario")
    private int idusuario; //vendedor

    @Column(name = "idservicio")
    private int idservicio;

	@Column(name = "descripcion")
    private String descripcion;
	
	@Column(name = "nombre")
    private String nombre;

	@Column(name = "creationdate")
    private Date creationdate;

    @Column(name = "categoria")
    private String categoria;
	

    public Servicio(int id, int idUsuario,int idServicio, String nombre, String descripcion, Date creacion, String categoria) {
        this.id = id;
        this.idusuario = idUsuario;
        this.idservicio=idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creationdate = creacion;
        this.categoria=categoria;    }
    public Servicio() {
    	
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getCreationdate() {
        return creationdate;
    }
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getIdservicio() {
        return idservicio;
    }
    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

}