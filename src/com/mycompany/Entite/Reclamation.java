/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ihebm
 */
public class Reclamation {
    private int idreclam;
    private String titrereclam;
    private String descriptionreclam;
    private Date datereclam;
    private String etatrecam;

    public Reclamation() {
    }

    public Reclamation(int idreclam, String titrereclam, String descriptionreclam, Date datereclam, String etatrecam) {
        this.idreclam = idreclam;
        this.titrereclam = titrereclam;
        this.descriptionreclam = descriptionreclam;
        this.datereclam = datereclam;
        this.etatrecam = etatrecam;
    }

    public Reclamation(String titrereclam, String descriptionreclam, Date datereclam, String etatrecam) {
        this.titrereclam = titrereclam;
        this.descriptionreclam = descriptionreclam;
        this.datereclam = datereclam;
        this.etatrecam = etatrecam;
    }

    public Reclamation(int idreclam, String titrereclam, String descriptionreclam) {
        this.idreclam = idreclam;
        this.titrereclam = titrereclam;
        this.descriptionreclam = descriptionreclam;
    }

    
    
    public int getIdreclam() {
        return idreclam;
    }

    public void setIdreclam(int idreclam) {
        this.idreclam = idreclam;
    }

    public String getTitrereclam() {
        return titrereclam;
    }

    public void setTitrereclam(String titrereclam) {
        this.titrereclam = titrereclam;
    }

    public String getDescriptionreclam() {
        return descriptionreclam;
    }

    public void setDescriptionreclam(String descriptionreclam) {
        this.descriptionreclam = descriptionreclam;
    }

    public Date getDatereclam() {
        return datereclam;
    }

    public void setDatereclam(Date datereclam) {
        this.datereclam = datereclam;
    }

    public String getEtatrecam() {
        return etatrecam;
    }

    public void setEtatrecam(String etatrecam) {
        this.etatrecam = etatrecam;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idreclam;
        hash = 89 * hash + Objects.hashCode(this.titrereclam);
        hash = 89 * hash + Objects.hashCode(this.descriptionreclam);
        hash = 89 * hash + Objects.hashCode(this.datereclam);
        hash = 89 * hash + Objects.hashCode(this.etatrecam);
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
        final Reclamation other = (Reclamation) obj;
        if (this.idreclam != other.idreclam) {
            return false;
        }
        if (!Objects.equals(this.titrereclam, other.titrereclam)) {
            return false;
        }
        if (!Objects.equals(this.descriptionreclam, other.descriptionreclam)) {
            return false;
        }
        if (!Objects.equals(this.etatrecam, other.etatrecam)) {
            return false;
        }
        if (!Objects.equals(this.datereclam, other.datereclam)) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Reclamation{" + "idreclam=" + idreclam + ", titrereclam=" + titrereclam + ", descriptionreclam=" + descriptionreclam + ", datereclam=" + datereclam + ", etatrecam=" + etatrecam + '}';
    }
    
    
    
}
