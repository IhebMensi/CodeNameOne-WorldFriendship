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
public class likeevenement1 {
    
    
        
    private int user_id ;
    private int even_id;
    private String comment ;

    public likeevenement1() {
    }

    public likeevenement1(int user_id, int even_id, String comment) {
        this.user_id = user_id;
        this.even_id = even_id;
        this.comment = comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEven_id() {
        return even_id;
    }

    public void setEven_id(int even_id) {
        this.even_id = even_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.user_id;
        hash = 97 * hash + this.even_id;
        hash = 97 * hash + Objects.hashCode(this.comment);
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
        final likeevenement1 other = (likeevenement1) obj;
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.even_id != other.even_id) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "likeevenement{" + "user_id=" + user_id + ", even_id=" + even_id + ", comment=" + comment + '}';
    }
    
    
    
    
    
}
