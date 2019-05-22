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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Marwa
 */
public class ServiceUser1 {
  //  ArrayList<Utilisateur> listTasks2 = new ArrayList<>();
    Utilisateur p1 = new Utilisateur();
    Utilisateur task1 = new Utilisateur();
        public Utilisateur find(){       
        ConnectionRequest con = new ConnectionRequest();
        String us = "ma";
        String  mp ="1";
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/finduser/1");  
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> reservation = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + reservation.get("root"));
                    
                    System.out.println("roooo1:" + reservation.get("root").toString());
//                  
//               Utilisateur k = (Utilisateur) reservation.get("root");
//                    System.out.println(k);
//                             float id = Float.parseFloat(reservation.get("id").toString());
//                    System.out.println(id);
//                        task1.setId((int) id );

                    
//
                //     float id = Float.parseFloat(reservation.get("id").toString());

                  //      task1.setId((int) Float.parseFloat(reservation.get("id").toString()));

                  
                  
                //  task1.setNom(.get("nom").toString());
                         
                        
                    
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
     //   System.out.println(listTasks2);
        return task1;

    }
}
