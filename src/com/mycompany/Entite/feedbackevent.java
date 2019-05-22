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
public class feedbackevent {
      private Utilisateur user_id ;
    private Evenement even_id;
    private String nomfeed ;
    private int idfeed ;
 private int id ;

    public feedbackevent() {
    }

    public feedbackevent(int user_id, int even_id, String nomfeed, int idfeed) {
         this.user_id = new Utilisateur(user_id);
        this.even_id = new Evenement(even_id);
        this.nomfeed = nomfeed;
        this.idfeed = idfeed;
       
    }

    public feedbackevent(Evenement even_id, int idfeed) {
        this.even_id = even_id;
        this.idfeed = idfeed;
    }

    
     public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id =  new Utilisateur(user_id) ;
    }

    public Evenement getEven_id() {
        return even_id;
    }

    public void setEven_id(int  even_id) {
        this.even_id = new Evenement(even_id) ;
    }
    
    public String getNomfeed() {
        return nomfeed;
    }

    public void setNomfeed(String nomfeed) {
        this.nomfeed = nomfeed;
    }

    public int getIdfeed() {
        return idfeed;
    }

    public void setIdfeed(int idfeed) {
        this.idfeed = idfeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final feedbackevent other = (feedbackevent) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "feedbackevent{" + "user_id=" + user_id + ", even_id=" + even_id.getIdevenement() + ", nomfeed=" + nomfeed + ", idfeed=" + idfeed + ", id=" + id + '}';
    }
 
 
 
 
 
}
