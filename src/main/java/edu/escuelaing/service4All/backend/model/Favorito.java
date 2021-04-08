package edu.escuelaing.service4All.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favoritos")
public class Favorito {

    @Id
    @Column(name = "idservicio")
    private int idservicio;

    @Column(name = "idusuario")
    private int idusuario;

    public Favorito(int idSer, int idUse) {
        this.idservicio=idSer;
        this.idusuario=idUse;
    }

    public Favorito() {

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
}
