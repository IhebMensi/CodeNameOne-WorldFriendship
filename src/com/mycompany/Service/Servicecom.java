/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Entite.commentevenement;
import com.mycompany.Entite.participation_evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marwa
 */
public class Servicecom {
    
    
     public void ajoutcom(commentevenement e) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getComment());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/AjouterCommentmo?id="+1+"&idevenement="+e.getEven_id().getIdevenement()+"&comment="+e.getComment();
        // + "/" + p.getContenupublicte();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((s) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    
    public ArrayList<commentevenement> parseListEveJson(String json) {

        ArrayList<commentevenement> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
   
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {//Création des tâches et récupération de leurs données
               commentevenement e = new commentevenement();
               Object lo =   obj.get("user");
               String lpp = lo.toString();
                System.out.println(lpp);
               String idu =lpp.substring(lpp.indexOf("id=")+3 , lpp.indexOf(".0, username"));
                System.out.println("okkokok  "+idu);
                int idu1 = Integer.parseInt(idu);
           //     float id = Float.parseFloat(obj.get("user").toString());
           ServiceUser1  u1 = new ServiceUser1();
    e.setUser_id(u1.find());
           //     e.setIdevenement((int) id);
           
                e.setComment(obj.get("comment").toString());
               
//                e.setDescriptionevenement(obj.get("descriptionevenement").toString());
//                e.setNomimage(obj.get("nomimage").toString());
//                  e.setPays(obj.get("pays").toString());
//                float nb= Float.parseFloat(obj.get("nbrparticipants").toString());
//                e.setNbrparticipants((int)nb);
//                float nbrplacestotal = Float.parseFloat(obj.get("nbrplacestotal").toString());
//                e.setNbrplacestotal((int) nbrplacestotal );
//                        System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<commentevenement> listTasks = new ArrayList<>();
    
    public ArrayList<commentevenement> getList(int idd){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/affcom/"+idd);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Servicecom ser = new Servicecom();
                listTasks = ser.parseListEveJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    
    


}
    
