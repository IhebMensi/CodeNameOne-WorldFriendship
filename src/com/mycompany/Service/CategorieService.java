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
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Utilisateur;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 *
 * @author sfaxidorra
 */
public class CategorieService {
  
    public ArrayList<Categorie> parseListCatJson(String json) {

        ArrayList<Categorie> list = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> categories = j.parseJSON(new CharArrayReader(json.toCharArray()));
                      
            List<Map<String, Object>> list1 = (List<Map<String, Object>>) categories.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list1) {
                //Création des tâches et récupération de leurs données
                Categorie e = new Categorie();

                float id = Float.parseFloat(obj.get("idcategorie").toString());

                e.setIdcategorie((int) id);
                e.setNomcategorie(obj.get("nomcategorie").toString());
                e.setImgcategorie(obj.get("imagecategorie").toString());
                float nbr = Float.parseFloat(obj.get("nbrabonnees").toString());
                e.setNbrabonnees((int) nbr);
                e.setDescriptioncategorie(obj.get("descriptioncategorie").toString());
                e.setImgcategorie(obj.get("imagecategorie").toString());
                System.out.println(e.toString());
                
                list.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(list);
        return list;

    }
    
    ArrayList<Categorie> list = new ArrayList<>();
    
    public ArrayList<Categorie> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/listCategorieApi");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CategorieService ser = new CategorieService();
                list = ser.parseListCatJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(list);
        return list;
    }
    
    public void sabonner(Categorie c)
    {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/suivreApi?idC="+c.getIdcategorie()+"&idU="+1 ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
         NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public static ArrayList<Categorie> listTrie = new ArrayList();
   
    public ArrayList<Categorie> recherche(String text) throws UnsupportedEncodingException, IOException
    {
         
        String url =("http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/rechercheNomApi" + text);
          
        ConnectionRequest con = new ConnectionRequest();
        con.setHttpMethod("GET");
        con.setUrl(url);
        Label lb = new Label();
        con.addResponseListener(evvvv -> {
            String reponse = new String(con.getResponseData());
            lb.setText(reponse);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        if (!lb.getText().equals("{}")) {
            Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(con.getResponseData()), "UTF-8"));
            
            List<Map<String, Object>> res = (List<Map<String, Object>>) result.get("root");
            for (Map<String, Object> r : res) {
                Categorie e = new Categorie();
                e.setIdcategorie(((Double) r.get("idcategorie")).intValue());
                e.setNomcategorie((String) r.get("nomgecategorie"));
                e.setImgcategorie((String) r.get("imagecategorie"));
                e.setDescriptioncategorie((String) r.get("descriptioncategorie"));
                e.setNbrabonnees((int) (double) r.get("nbrabonnees"));
                
                listTrie.add(e);
                System.out.println(e);
            } 
        }
        return listTrie;
    
    }
     
}
