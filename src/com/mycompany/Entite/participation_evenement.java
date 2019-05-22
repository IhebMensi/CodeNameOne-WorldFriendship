/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Objects;

/**
 *
 * @author Marwa
 */
public class participation_evenement {
    
     private Utilisateur user_id ;
    private Evenement even_id;

    public participation_evenement() {
    }


    public participation_evenement(int user_id) {
       this.user_id = new Utilisateur(user_id);
    }
    
    
      public participation_evenement(int user_id, int even_id) {
        this.user_id = new Utilisateur(user_id);
        this.even_id = new Evenement(even_id);
    
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

  
    
//
//    public participation_evenement(Utilisateur user_id, Evenement even_id) {
//        this.user_id = user_id;
//        this.even_id = even_id;
//    }
//
//    public participation_evenement(Evenement even_id) {
//        this.even_id = even_id;
//    }
//
//    public Utilisateur getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Utilisateur user_id) {
//        this.user_id = user_id;
//    }
//
//    public Evenement getEven_id() {
//        return even_id;
//    }
//
//    public void setEven_id(Evenement even_id) {
//        this.even_id = even_id;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.user_id);
        hash = 71 * hash + Objects.hashCode(this.even_id);
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
        final participation_evenement other = (participation_evenement) obj;
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.even_id, other.even_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "participation_evenement{" + "user_id=" + user_id + ", even_id=" + even_id + '}';
    }

   
    
}
