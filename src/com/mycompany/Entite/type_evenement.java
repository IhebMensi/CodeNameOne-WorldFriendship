/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;
/**
 *
 * @author Marwa
 */
public class type_evenement {
  private int idtype;
       private String  nomtype ;

    public type_evenement() {
    }

    public type_evenement(int idtype, String nomtype) {
        this.idtype = idtype;
        this.nomtype = nomtype;
    }

    public type_evenement(String nomtype) {
        this.nomtype = nomtype;
    }

    public type_evenement(int idtype) {
        this.idtype = idtype;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idtype;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final type_evenement other = (type_evenement) obj;
        if (this.idtype != other.idtype) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   nomtype ;
    }
       
       
}
