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
public class Feedback {
    private int idfeedback;
    private int note;
    private String descriptionfeedback;
    private Date datefeedback;

    public Feedback() {
    }

    public Feedback(int idfeedback, int note, String descriptionfeedback, Date datefeedback) {
        this.idfeedback = idfeedback;
        this.note = note;
        this.descriptionfeedback = descriptionfeedback;
        this.datefeedback = datefeedback;
    }

    public Feedback(int note, String descriptionfeedback, Date datefeedback) {
        this.note = note;
        this.descriptionfeedback = descriptionfeedback;
        this.datefeedback = datefeedback;
    }

    public Feedback(int idfeedback, int note, String descriptionfeedback) {
        this.idfeedback = idfeedback;
        this.note = note;
        this.descriptionfeedback = descriptionfeedback;
    }
    
    

    public int getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(int idfeedback) {
        this.idfeedback = idfeedback;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getDescriptionfeedback() {
        return descriptionfeedback;
    }

    public void setDescriptionfeedback(String descriptionfeedback) {
        this.descriptionfeedback = descriptionfeedback;
    }

    public Date getDatefeedback() {
        return datefeedback;
    }

    public void setDatefeedback(Date datefeedback) {
        this.datefeedback = datefeedback;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idfeedback;
        hash = 97 * hash + this.note;
        hash = 97 * hash + Objects.hashCode(this.descriptionfeedback);
        hash = 97 * hash + Objects.hashCode(this.datefeedback);
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
        final Feedback other = (Feedback) obj;
        if (this.idfeedback != other.idfeedback) {
            return false;
        }
        if (this.note != other.note) {
            return false;
        }
        if (!Objects.equals(this.descriptionfeedback, other.descriptionfeedback)) {
            return false;
        }
        if (!Objects.equals(this.datefeedback, other.datefeedback)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Feedback{" + "idfeedback=" + idfeedback + ", note=" + note + ", descriptionfeedback=" + descriptionfeedback + ", datefeedback=" + datefeedback + '}';
    }
    
}
