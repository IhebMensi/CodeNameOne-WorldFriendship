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
import com.mycompany.Entite.participation_evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marwa
 */
public class Serviceeve {
    
    public ArrayList<Evenement> parseListEveJson(String json) {

        ArrayList<Evenement> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
   
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {//Création des tâches et récupération de leurs données
                Evenement e = new Evenement();

                float id = Float.parseFloat(obj.get("idevenement").toString());

                e.setIdevenement((int) id);
                e.setNomevenement(obj.get("nomevenement").toString());
                e.setDescriptionevenement(obj.get("descriptionevenement").toString());
                e.setNomimage(obj.get("nomimage").toString());
                  e.setPays(obj.get("pays").toString());
                float nb= Float.parseFloat(obj.get("nbrparticipants").toString());
                e.setNbrparticipants((int)nb);
                float nbrplacestotal = Float.parseFloat(obj.get("nbrplacestotal").toString());
                e.setNbrplacestotal((int) nbrplacestotal );
                        System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<Evenement> listTasks = new ArrayList<>();
    
    public ArrayList<Evenement> getList(int idd){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/meseve/"+idd);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvenement ser = new ServiceEvenement();
                listTasks = ser.parseListEveJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    
    
    
    public ArrayList<participation_evenement> parseListEveJson1(String json) {

        ArrayList<participation_evenement> listTasks1 = new ArrayList<>();

        try {
            JSONParser j1 = new JSONParser();
   
            Map<String, Object> tasks1 = j1.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list1 = (List<Map<String, Object>>) tasks1.get("root");

            for (Map<String, Object> obj1 : list1) {//Création des tâches et récupération de leurs données
                participation_evenement e = new participation_evenement();
          
                Evenement id = (Evenement)obj1.get("even");
              int idev = id.getIdevenement();
               Utilisateur idu = (Utilisateur) obj1.get("user");
//               float id1=Float.parseFloat((id.getIdevenement());
               int idutil= idu.getId();
               e.setEven_id(   idev );
                System.out.println("+5"+id);
              e.setUser_id( idutil);
                
                listTasks1.add(e);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks1);
        return listTasks1;

    }
    
    
    ArrayList<participation_evenement> listTasks2 = new ArrayList<>();
    
    public ArrayList<participation_evenement> getList1(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/participerall");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvenement ser = new ServiceEvenement();
                listTasks2 = ser.parseListEveJson1(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks2;
    }
    
    
    
    
         ArrayList<Evenement> listTasks1 = new ArrayList<>();
    Evenement p1 = new Evenement();
    Evenement task = new Evenement();
        public Evenement find(){       
        ConnectionRequest con = new ConnectionRequest();
        int us = 116;
        //String mp ="123";
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/eve/find/"+us);  
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> reservation = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + reservation.get("root"));

                          

                float id = Float.parseFloat(reservation.get("idevenement").toString());

                        task.setIdevenement((int) Float.parseFloat(reservation.get("idevenement").toString()));

                        task.setNomevenement(reservation.get("nomevenement").toString());
                         task.setDescriptionevenement(reservation.get("descriptionevenement").toString());
//                          task.setNomimage(reservation.get("nomimage").toString());

                       

                    
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listTasks1);
        return task;

    }

}
    
