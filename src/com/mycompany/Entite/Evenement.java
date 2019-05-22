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
 * @author Marwa
 */
public class Evenement {
    public int idevenement;
    public String nomevenement;
    public String descriptionevenement;
     private  String pays;
    private  String region;
     private String adresse;
     private Date  datedebut;
    private  Date  datefin ;
  private int nbrparticipants ;
    private int nbrplacestotal ;
     private  int payment ;
    private int nbrtickets;
    private float  prixtickets;
    private  String nomimage;
    private  int nbrlikes;
    private int nbrdislikes ;
   private  int nbsignal ;
   private int typeevenement_id;
   private  int user_id;

    public Evenement() {
    }

    public Evenement(int idevenement, String nomevenement, String descriptionevenement) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
    }

    public Evenement(String nomevenement, String descriptionevenement, String pays, String nomimage) {
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
        this.pays = pays;
        this.nomimage = nomimage;
    }

    public Evenement(int idevenement,String nomevenement, String descriptionevenement, Date datedebut, Date datefin, String nomimage,String pays, String region,int nbrplacestotal) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nomimage = nomimage;
        this.pays= pays;
        this.region=region;
        this.nbrplacestotal=nbrplacestotal;
       // this.typeevenement_id= typeevenement_id;
    }
    
    
    

    public Evenement(int idevenement, String nomevenement) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
    }

    public Evenement(String nomevenement, String descriptionevenement) {
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
    }

    public Evenement(int idevenement) {
        this.idevenement = idevenement;
    }

 
    public int getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(int idevenement) {
        this.idevenement = idevenement;
    }

    public String getNomevenement() {
        return nomevenement;
    }

    public void setNomevenement(String nomevenement) {
        this.nomevenement = nomevenement;
    }

    public String getDescriptionevenement() {
        return descriptionevenement;
    }

    public void setDescriptionevenement(String descriptionevenement) {
        this.descriptionevenement = descriptionevenement;
    }

 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idevenement;
        hash = 83 * hash + Objects.hashCode(this.nomevenement);
        hash = 83 * hash + Objects.hashCode(this.descriptionevenement);
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
        final Evenement other = (Evenement) obj;
        if (this.idevenement != other.idevenement) {
            return false;
        }
        if (!Objects.equals(this.nomevenement, other.nomevenement)) {
            return false;
        }
        if (!Objects.equals(this.descriptionevenement, other.descriptionevenement)) {
            return false;
        }
        return true;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Evenement(int idevenement, String nomevenement, String descriptionevenement, String nomimage) {
        this.idevenement = idevenement;
        this.nomevenement = nomevenement;
        this.descriptionevenement = descriptionevenement;
        this.nomimage = nomimage;
    }

   

    public int getNbrparticipants() {
        return nbrparticipants;
    }

    public void setNbrparticipants(int nbrparticipants) {
        this.nbrparticipants = nbrparticipants;
    }

    public int getNbrplacestotal() {
        return nbrplacestotal;
    }

    public void setNbrplacestotal(int nbrplacestotal) {
        this.nbrplacestotal = nbrplacestotal;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getNbrtickets() {
        return nbrtickets;
    }

    public void setNbrtickets(int nbrtickets) {
        this.nbrtickets = nbrtickets;
    }

    public float getPrixtickets() {
        return prixtickets;
    }

    public void setPrixtickets(float prixtickets) {
        this.prixtickets = prixtickets;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public int getNbrlikes() {
        return nbrlikes;
    }

    public void setNbrlikes(int nbrlikes) {
        this.nbrlikes = nbrlikes;
    }

    public int getNbrdislikes() {
        return nbrdislikes;
    }

    public void setNbrdislikes(int nbrdislikes) {
        this.nbrdislikes = nbrdislikes;
    }

    public int getNbsignal() {
        return nbsignal;
    }

    public void setNbsignal(int nbsignal) {
        this.nbsignal = nbsignal;
    }

    public int getTypeevenement_id() {
        return typeevenement_id;
    }

    public void setTypeevenement_id(int typeevenement_id) {
        this.typeevenement_id = typeevenement_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idevenement=" + idevenement + ", nomevenement=" + nomevenement + ", descriptionevenement=" + descriptionevenement + ", pays=" + pays + ", region=" + region + ", adresse=" + adresse + ", datedebut=" + datedebut + ", datefin=" + datefin + ", nbrparticipants=" + nbrparticipants + ", nbrplacestotal=" + nbrplacestotal + ", payment=" + payment + ", nbrtickets=" + nbrtickets + ", prixtickets=" + prixtickets + ", nomimage=" + nomimage + ", nbrlikes=" + nbrlikes + ", nbrdislikes=" + nbrdislikes + ", nbsignal=" + nbsignal + ", typeevenement_id=" + typeevenement_id + ", user_id=" + user_id + '}';
    }

   
    
    
}
