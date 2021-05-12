package edu.escuelaing.service4All.backend.model;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="suscripciones")
public class Suscripcion {

    @Id
    private int idvendedor;

    @Column(name = "mesesvigente")
    private int mesesvigente;

    @Column(name = "fechainicio")
    private Date fechainicio;

    public Suscripcion() {
    }

    public Suscripcion(int idvendedor, int mesesvigente, Date fechainicio) {
        this.idvendedor = idvendedor;
        this.mesesvigente = mesesvigente;
        this.fechainicio = fechainicio;
    }
    
    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public int getMesesvigente() {
        return mesesvigente;
    }

    public void setMesesvigente(int mesesvigente) {
        this.mesesvigente = mesesvigente;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

}
