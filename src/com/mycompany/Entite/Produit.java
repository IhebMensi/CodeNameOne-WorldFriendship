/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import javafx.stage.FileChooser;

/**
 *
 * @author asus
 */
public class Produit {
      private int nbrlike=0;
    private int nbrdislike=0;
    private String etat;
    private FileChooser image;
    private String descriptionproduit;
    private   int userid ;
     private int idproduit;
    private String nomproduit;
        private String nomimage;
        private String AcptProd;

    private String datemisevente;
    private float prix;
    private String categorie;

    public Produit(String etat, FileChooser image, String descriptionproduit, int userid, int idproduit, String nomproduit, String nomimage, String AcptProd, String datemisevente, float prix, String categorie) {
        this.etat = etat;
        this.image = image;
        this.descriptionproduit = descriptionproduit;
        this.userid = userid;
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.nomimage = nomimage;
        this.AcptProd = AcptProd;
        this.datemisevente = datemisevente;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit() {
    }

    public Produit(int userid, int idproduit, String nomproduit, float prix, String categorie) {
        this.userid = userid;
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit(String nomproduit , float prix, String descriptionproduit , String categorie) {
        this.descriptionproduit = descriptionproduit;
        this.nomproduit = nomproduit;
        this.prix = prix;
        this.categorie = categorie;
    }
public Produit( int idproduit,String nomproduit , float prix, String descriptionproduit , String categorie,String nomimage) {
        this.descriptionproduit = descriptionproduit;
        this.nomproduit = nomproduit;
        this.prix = prix;
                this.idproduit = idproduit;

        this.categorie = categorie;
        this.nomimage=nomimage;
    }
public Produit( String nomproduit , float prix, String descriptionproduit , String categorie,String nomimage) {
        this.descriptionproduit = descriptionproduit;
        this.nomproduit = nomproduit;
        this.prix = prix;

        this.categorie = categorie;
        this.nomimage=nomimage;
    }
    public int getNbrlike() {
        return nbrlike;
    }

    public void setNbrlike(int nbrlike) {
        this.nbrlike = nbrlike;
    }

    public int getNbrdislike() {
        return nbrdislike;
    }

    public void setNbrdislike(int nbrdislike) {
        this.nbrdislike = nbrdislike;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public FileChooser getImage() {
        return image;
    }

    public void setImage(FileChooser image) {
        this.image = image;
    }

    public String getDescriptionproduit() {
        return descriptionproduit;
    }

    public void setDescriptionproduit(String descriptionproduit) {
        this.descriptionproduit = descriptionproduit;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }

    public String getAcptProd() {
        return AcptProd;
    }

    public void setAcptProd(String AcptProd) {
        this.AcptProd = AcptProd;
    }

    public String getDatemisevente() {
        return datemisevente;
    }

    public void setDatemisevente(String datemisevente) {
        this.datemisevente = datemisevente;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "nbrlike=" + nbrlike + ", nbrdislike=" + nbrdislike + ", etat=" + etat + ", image=" + image + ", descriptionproduit=" + descriptionproduit + ", userid=" + userid + ", idproduit=" + idproduit + ", nomproduit=" + nomproduit + ", nomimage=" + nomimage + ", AcptProd=" + AcptProd + ", datemisevente=" + datemisevente + ", prix=" + prix + ", categorie=" + categorie + '}';
    }
    
}
