/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;

import com.mycompany.Entite.Reclamation;

/**
 *
 * @author ihebm
 */
public class ServiceReclamation {

public void ajoutReclamation(Reclamation p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
     //   System.out.println(p.getNompublicite());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/rec/new?titrereclam=" + p.getTitrereclam()+"&descriptionreclam="+p.getDescriptionreclam()+"&etatreclam=non";
        // + "/" + p.getContenupublicte();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
           con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Reclamation ajouté", "ok", null);
            });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }



    
}
