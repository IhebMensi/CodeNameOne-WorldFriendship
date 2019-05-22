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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.Pub;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Entite.participation_evenement;
import com.mycompany.Entite.type_evenement;
import com.mycompany.gui.testaff2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marwa
 */
public class ServiceEvenement {
    public void ajoutEvenement(Evenement e) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/neweeve?nomevenement=" + e.getNomevenement()+"&descriptionevenement="+e.getDescriptionevenement()+"&idT=null" +
                "&datedebut="+e.getDatedebut()+"&datefin="+e.getDatefin()
                +"&nomimage="+e.getNomimage()+"&pays="+e.getPays()+"&region="+e.getRegion()+"&nbrplacestotal="+e.getNbrplacestotal();
        // + "/" + p.getContenupublicte();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((s) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
        public void partEvenement(Evenement e,Utilisateur u) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/participer/" + e.getIdevenement()+"/"+u.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((s) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
   

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
    
    public ArrayList<Evenement> getList(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/allevemobile");  
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
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/allevemobile1/"+us);  
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
        
            public void supprimerEvenement(Evenement e) {
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/suppeve/" + e.getIdevenement();
        con.setUrl(url);
        con.addResponseListener((f) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Evenement supprimé", "ok", null);
     
       
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
  
      public void modifierEvenement(Evenement e) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/updateeve/" + e.getIdevenement() + "?nomevenement=" +e.getNomevenement()+
               "&descriptionevenement="+e.getDescriptionevenement();
                
        con.setUrl(Url);

        con.addResponseListener((k) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Publicite modifié", "ok", null);

           

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public ArrayList<Evenement> parseListrechEveJson(String json) {

        ArrayList<Evenement> listTasks3 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
    
            Map<String, Object> tasks1 = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
         
            List<Map<String, Object>> list1 = (List<Map<String, Object>>) tasks1.get("root");

            for (Map<String, Object> obj : list1) {
                
               Evenement e = new Evenement();

                float id = Float.parseFloat(obj.get("idevenement").toString());

                e.setIdevenement((int) id);
                e.setNomevenement(obj.get("nomevenement").toString());
                e.setDescriptionevenement(obj.get("descriptionevenement").toString());
                  e.setNomimage(obj.get("nomimage").toString());
                System.out.println("lol"+e);
                
                listTasks3.add(e);

            }

        } catch (IOException ex) {
        }
        
       
        System.out.println(listTasks3);
        return listTasks3;

    }
       
      ArrayList<Evenement> listTasks3 = new ArrayList<>();  
           public ArrayList<Evenement> rechercheEvenement(String nomevenement){       
        ConnectionRequest con = new ConnectionRequest();
      //  String nompublicite="marwam";
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/rechercheeve/"+nomevenement);  
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                
                              ServiceEvenement ser = new ServiceEvenement();
                listTasks3 = ser.parseListrechEveJson(new String(con.getResponseData()));
            }});
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listTasks3);
        return listTasks3;

    }
           public ArrayList<type_evenement> parseListTaskJson18(String json) {

        ArrayList<type_evenement> listtype = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
       
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                type_evenement p = new type_evenement();

                float id = Float.parseFloat(obj.get("idtype").toString());
                p.setIdtype((int) id);

                p.setNomtype(obj.get("nomtype").toString());

                listtype.add(p);

            }

        } catch (IOException ex) {
        }
     return listtype;

    }
        
    ArrayList<type_evenement> listtype = new ArrayList<>();
     public ArrayList<type_evenement> getListTypeEv(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/afftypene");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              ServiceEvenement sp =new ServiceEvenement();  
                listtype = sp.parseListTaskJson18(new String(con.getResponseData()));    
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listtype;
    }

}
