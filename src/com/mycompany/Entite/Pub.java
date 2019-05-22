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
public class Pub {
 
    private int idpublicite;
    private String nompublicite;          
    private String contenupublicte;
    private String pays;
    private String region;
    private String nomimage;
    private Date datepublicite;
    private Date datepublicitefin;
    private int point;
    private int prixproduit; 
    private int pourcentage; 
    private int prixremise ;
    public Pub() {
    }

    public Pub(int idpublicite, String nompublicite, String contenupublicte, String nomimage) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.contenupublicte = contenupublicte;
        this.nomimage = nomimage;
    }

    public Pub(String nompublicite) {
        this.nompublicite = nompublicite;
    }

    public Pub(int idpublicite, String nompublicite) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
    }

    public Pub(String nompublicite, String contenupublicte) {
        this.nompublicite = nompublicite;
        this.contenupublicte = contenupublicte;
    }

    
    
    public Pub(int idpublicite, String nompublicite, String contenupublicte) {
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.contenupublicte = contenupublicte;
    }

    public Pub(int idpublicite,String nompublicite, String contenupublicte,String pays,String region, Date datepublicite, Date datepublicitefin,String nomimage,int point,int prixproduit,int pourcentage,int prixremise) {
        
        this.idpublicite = idpublicite;
        this.nompublicite = nompublicite;
        this.contenupublicte = contenupublicte;
        this.pays=pays;
        this.region=region;
        this.datepublicite = datepublicite;
        this.datepublicitefin = datepublicitefin;
            this.nomimage = nomimage;
            this.point=point;
            this.prixproduit=prixproduit;
            this.pourcentage=pourcentage;
            this.prixremise = prixremise;
            
    }

    public int getPrixremise() {
        return prixremise;
    }

    public void setPrixremise(int prixremise) {
        this.prixremise = prixremise;
    }

    
    
    
    
    public int getIdpublicite() {
        return idpublicite;
    }

    public void setIdpublicite(int idpublicite) {
        this.idpublicite = idpublicite;
    }

    public String getNompublicite() {
        return nompublicite;
    }

    public void setNompublicite(String nompublicite) {
        this.nompublicite = nompublicite;
    }

    public String getContenupublicte() {
        return contenupublicte;
    }

    public void setContenupublicte(String contenupublicte) {
        this.contenupublicte = contenupublicte;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public Date getDatepublicite() {
        return datepublicite;
    }

    public void setDatepublicite(Date datepublicite) {
        this.datepublicite = datepublicite;
    }

    public Date getDatepublicitefin() {
        return datepublicitefin;
    }

    public void setDatepublicitefin(Date datepublicitefin) {
        this.datepublicitefin = datepublicitefin;
    }

    public int getPrixproduit() {
        return prixproduit;
    }

    public void setPrixproduit(int prixproduit) {
        this.prixproduit = prixproduit;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Pub{" + "idpublicite=" + idpublicite + ", nompublicite=" + nompublicite + ", contenupublicte=" + contenupublicte + ", pays=" + pays + ", region=" + region + ", nomimage=" + nomimage + ", datepublicite=" + datepublicite + ", datepublicitefin=" + datepublicitefin + ", point=" + point + ", prixproduit=" + prixproduit + ", pourcentage=" + pourcentage + '}';
    }

    
    
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idpublicite;
        hash = 47 * hash + Objects.hashCode(this.nompublicite);
        hash = 47 * hash + Objects.hashCode(this.contenupublicte);
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
        final Pub other = (Pub) obj;
        if (this.idpublicite != other.idpublicite) {
            return false;
        }
        if (!Objects.equals(this.nompublicite, other.nompublicite)) {
            return false;
        }
        if (!Objects.equals(this.contenupublicte, other.contenupublicte)) {
            return false;
        }
        return true;
    }
    
    
    
}
