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
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Pub;
import com.mycompany.gui.Affichagep;
import com.mycompany.gui.Affichage1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ihebm
 */
public class ServicePub {
    public void ajoutPub(Pub p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(p.getNompublicite());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/new?nompublicite=" + p.getNompublicite()+
                "&contenupublicte="+p.getContenupublicte()
                +"&pays="+p.getPays()+"&region="+p.getRegion()
                +"&datepublicite"+p.getDatepublicite()+"&datepublicitefin"
                +p.getDatepublicitefin()+"&nomimage="+p.getNomimage()
                +"&point="+p.getPoint()+"&prixproduit="+p.getPrixproduit()+"&pourcentage="+p.getPourcentage()+
                "&prixremise="+p.getPrixremise();
        // + "/" + p.getContenupublicte();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
           con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Publicité ajouté", "ok", null);
            });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
        public void profitPub(Pub p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(p.getNompublicite());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/new?nompublicite=" + p.getNompublicite()+"&contenupublicte="+p.getContenupublicte()+"&datepublicite"+p.getDatepublicite()+"&datepublicitefin"+p.getDatepublicitefin()+"&nomimage="+p.getNomimage();
        // + "/" + p.getContenupublicte();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
           con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Publicité ajouté", "ok", null);
            });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
        public void supprimerPub(Pub p) {
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/supprimerPub/" + p.getIdpublicite();
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Publicité supprimé", "ok", null);
      
       
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
  
      public void modifierPub(Pub p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/updatePub/" + p.getIdpublicite() + "?nompublicite=" +p.getNompublicite()+
               "&contenupublicte="+p.getContenupublicte();
                
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "Publicite modifié", "ok", null);

      

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

              

    public ArrayList<Pub> parseListTaskJson(String json) {

        ArrayList<Pub> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
     // Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Pub e = new Pub();

                float id = Float.parseFloat(obj.get("idpublicite").toString());

                e.setIdpublicite((int) id);
                e.setNompublicite(obj.get("nompublicite").toString());
                e.setContenupublicte(obj.get("contenupublicte").toString());
                 e.setNomimage(obj.get("nomimage").toString());
                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
       public ArrayList<Pub> parseListPubJson(String json) {

        ArrayList<Pub> listTasks1 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
    
            Map<String, Object> tasks1 = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
         
            List<Map<String, Object>> list1 = (List<Map<String, Object>>) tasks1.get("root");

            for (Map<String, Object> obj : list1) {
                
               Pub e = new Pub();

                float id = Float.parseFloat(obj.get("idpublicite").toString());

                e.setIdpublicite((int) id);
                e.setNompublicite(obj.get("nompublicite").toString());
                e.setContenupublicte(obj.get("contenupublicte").toString());
                  e.setNomimage(obj.get("nomimage").toString());
                System.out.println(e);
                
                listTasks1.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
       
          public ArrayList<Pub> parseListrechPubJson(String json) {

        ArrayList<Pub> listTasks2 = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
    
            Map<String, Object> tasks1 = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
         
            List<Map<String, Object>> list1 = (List<Map<String, Object>>) tasks1.get("root");

            for (Map<String, Object> obj : list1) {
                
               Pub e = new Pub();

                float id = Float.parseFloat(obj.get("idpublicite").toString());

                e.setIdpublicite((int) id);
                e.setNompublicite(obj.get("nompublicite").toString());
                e.setContenupublicte(obj.get("contenupublicte").toString());
                  e.setNomimage(obj.get("nomimage").toString());
                System.out.println("lol"+e);
                
                listTasks2.add(e);

            }

        } catch (IOException ex) {
        }
        
       
        System.out.println(listTasks2);
        return listTasks2;

    }
       
       
       
    ArrayList<Pub> listTasks = new ArrayList<>();
    
    public ArrayList<Pub> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServicePub ser = new ServicePub();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
      ArrayList<Pub> listTasks1 = new ArrayList<>();
    Pub p1 = new Pub();
    Pub task = new Pub();
        public Pub find(){       
        ConnectionRequest con = new ConnectionRequest();
        int id =1;
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/find/"+id);  
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                     /*
//                On doit convertir notre réponse texte en CharArray à fin de
//            permettre au JSONParser de la lire et la manipuler d'ou vient 
//            l'utilité de new CharArrayReader(json.toCharArray())
//            
//            La méthode parse json retourne une MAP<String,Object> ou String est 
//            la clé principale de notre résultat.
//            Dans notre cas la clé principale n'est pas définie cela ne veux pas
//            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
//            qui est root.
//            En fait c'est la clé de l'objet qui englobe la totalité des objets 
//                    c'est la clé définissant le tableau de tâches.
//            */
                    
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> reservation = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + reservation.get("root"));

                          

                float id = Float.parseFloat(reservation.get("idpublicite").toString());

                        task.setIdpublicite((int) Float.parseFloat(reservation.get("idpublicite").toString()));

                        task.setNompublicite(reservation.get("nompublicite").toString());
                         task.setContenupublicte(reservation.get("contenupublicte").toString());
                         task.setPays(reservation.get("pays").toString());
                          task.setNomimage(reservation.get("nomimage").toString());

                       

                    
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listTasks);
        return task;

    }
        
    
          ArrayList<Pub> listTasks2 = new ArrayList<>();
    Pub p2 = new Pub();
  
        public ArrayList<Pub> recherchepub(String nompublicite){       
        ConnectionRequest con = new ConnectionRequest();
      //  String nompublicite="marwam";
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/pub/chercher/"+nompublicite);  
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                
                              ServicePub ser = new ServicePub();
                listTasks2 = ser.parseListrechPubJson(new String(con.getResponseData()));
            }});
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listTasks2);
        return listTasks2;

    }

        
        
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                ServicePub ser = new ServicePub();
//                listTasks1 = ser.parseListTaskJson(new String(con.getResponseData()));
//                System.out.println("lo"+listTasks1);
//            }
//        });
//            System.out.println(listTasks1);
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listTasks1;
//    }
  
}
