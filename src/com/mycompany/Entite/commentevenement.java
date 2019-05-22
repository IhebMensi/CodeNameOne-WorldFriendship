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
public class commentevenement {
      private Utilisateur user_id ;
    private Evenement even_id;
    private String comment ;
    private int idcomment ;

    public commentevenement() {
    }

    public commentevenement(String comment, int idcomment) {
        this.comment = comment;
        this.idcomment = idcomment;
    }

    public commentevenement(int idcomment) {
        this.idcomment = idcomment;
    }

    public commentevenement(int user_id, int even_id, String comment, int idcomment) {
        this.user_id = new Utilisateur(user_id);
        this.even_id = new Evenement(even_id);
        this.comment = comment;
        this.idcomment = idcomment;
    }

     public commentevenement( String comment) {
      
        this.comment = comment;
          }
      public commentevenement(int user_id, int even_id, String comment) {
        this.user_id = new Utilisateur(user_id);
        this.even_id = new Evenement(even_id);
        this.comment = comment;
          }
      
    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(Utilisateur user_id) {
        this.user_id = user_id;
    }

  

    public Evenement getEven_id() {
        return even_id;
    }

    public void setEven_id(int  even_id) {
        this.even_id = new Evenement(even_id) ;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(int idcomment) {
        this.idcomment = idcomment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idcomment;
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
        final commentevenement other = (commentevenement) obj;
        if (this.idcomment != other.idcomment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commentevenement{" + "user_id=" + user_id + ", even_id=" + even_id + ", comment=" + comment + ", idcomment=" + idcomment + '}';
    }
    
    
    
    
    
    
}
