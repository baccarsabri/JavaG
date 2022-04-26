/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author bacca
 */
public class Facture {
    private int id;
    private Date created_at;

    public Facture() {
    }

    public Facture(int id, Date created_at) {
        this.id = id;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", created_at=" + created_at + '}';
    }
    
    
    
}
