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
public class ServiceUser {
    ArrayList<Utilisateur> listTasks2 = new ArrayList<>();
    Utilisateur p1 = new Utilisateur();
    Utilisateur task1 = new Utilisateur();
        public Utilisateur find(){       
        ConnectionRequest con = new ConnectionRequest();
        String us = "ma";
        String  mp ="123";
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/mpp1/" + us+"/"+mp);  
          con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {
                    
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> reservation = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + reservation.get("root"));

                          
//
//                float id = Float.parseFloat(reservation.get("id").toString());
//
//                        task.setId((int) Float.parseFloat(reservation.get("id").toString()));

                        task1.setUsername(reservation.get("nom").toString());
                         
                        
                    
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listTasks2);
        return task1;

    }
}
