/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.FavoritProduit;
import com.mycompany.Entite.Produit;
import com.mycompany.gui.EspaceFAv;
import com.mycompany.gui.EspaceMyProduit;
import com.mycompany.gui.EspaceProduit;
import com.mycompany.gui.FavoritInterface;
import com.mycompany.gui.InterfaceAjoutProduit;
import com.mycompany.gui.Mail;
import com.mycompany.gui.SMS;
import com.mycompany.gui.Tousprod;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;



/**
 *
 * @author asus
 */
public class ServiceProduit {
   private  ConnectionRequest connectionRequest;
      private EncodedImage enc;

        private Image img,img1;
    private ImageViewer imgv;
private Label l1,l2,l3,l4;
private SpanLabel Nomprod,descprod,prixprod,catprod;
private TextField Nomprod1,descprod1,prixprod1,catprod1;

private Container mainContainer,ImageContainer,favContainer;
 Resources res;
    private String url;
   public ArrayList<Produit> GetTousProduits(String json){

               
                    
                  //  System.out.println(content);
                   ArrayList<Produit> produits = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
   
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String,Object> obj : list) {
             //   System.out.println(obj.get("id_DossierReclamation"));

                        produits.add(new Produit(
                                (int) (double) obj.get("idproduit"),
                                (String) obj.get("nomproduit"),
                                (float) (double) obj.get("prix"),
                                (String) obj.get("descriptionproduit"),
                                (String) obj.get("categorie"),
                                (String) obj.get("nomimage"))
                      
                        );
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            
        
    return produits;
                }
   ArrayList<Produit> produits = new ArrayList<>();
    
    public ArrayList<Produit> getList(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduit ser = new ServiceProduit();
                produits = ser.GetTousProduits(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return produits;
    }
    
     public ArrayList<Produit> GetMyProduits(String json){
      
                   ArrayList<Produit> produits = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
   
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String,Object> obj : list) {

                        produits.add(new Produit((int) (double) obj.get("idproduit"),(String) obj.get("nomproduit"),
                                (float) (double) obj.get("prix"),
                                (String) obj.get("descriptionproduit"),
                                (String) obj.get("categorie"),
                        (String) obj.get("nomimage"))
                                
                        );
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
        return produits;
            }
 public ArrayList<Produit> getList1(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/finduser/3");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduit ser = new ServiceProduit();
                produits = ser.GetMyProduits(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return produits;
    }
            
        

    

    public void removeProduit(int p){   // remove book by title
        System.out.println("kkkkkkkkk");
        connectionRequest = new ConnectionRequest(){
        @Override
            protected void postResponse() {
            
                   
           Dialog d = new Dialog("Remove book from database");
           Dialog d1;
          
           {}
            }  
        };
        connectionRequest.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/del/"+p);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
    public void updateProduit(Produit p,int id){
        ConnectionRequest cnx = new ConnectionRequest() ;
         String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/upd/"+id;
            cnx.setPost(true);
       // cnx.setUrl(Url);
       cnx.setUrl(Url);
        cnx.addArgument("nomproduit", p.getNomproduit());
        cnx.addArgument("prix", String.valueOf(p.getPrix()));
      cnx.addArgument("descriptionproduit", p.getDescriptionproduit());
        cnx.addArgument("categorie", p.getCategorie());

        cnx.addResponseListener((e) -> {
            String str = new String(cnx.getResponseData());
            System.out.println(str);
     
          });
          NetworkManager.getInstance().addToQueueAndWait(cnx);          
      
    }
    
     public void addProduit(Produit p){
       ConnectionRequest connectionRequest=new ConnectionRequest();
         System.out.println(p.getNomimage());
           
            Dialog d = new Dialog("Produit ajoutée avec succès");     
            int h = Display.getInstance().getDisplayHeight();
d.setDisposeWhenPointerOutOfBounds(true);
//d.show(h /8 * 7, 1, 0, 0);
Button close = new Button("Close");
close.addActionListener((ee) -> d.dispose());
Label l=new Label("              ");
Label l1=new Label("                ");
d.add(l1);
d.add(l);
d.addComponent(close);
d.show(h/3, h/2, 1, 1);   
            

         System.out.println("aaaaaaaaaaa"+p.toString());
         String url="http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/new?nomproduit="+p.getNomproduit()+"&prix="+p.getPrix()+"&descriptionproduit="+p.getDescriptionproduit()+"&categorie="+p.getCategorie()+"&nomimage="+p.getNomimage();
         connectionRequest.setUrl(url);
           connectionRequest.addResponseListener((s) -> {
            String str = new String(connectionRequest.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);
//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    } 
     
 public void Add_Favoris_Produit(int idu,int idp){
         ConnectionRequest connectionRequest=new ConnectionRequest(){
            @Override
            protected void postResponse() {
            Dialog d = new Dialog("Produit ajoutée avec succès");     
            int h = Display.getInstance().getDisplayHeight();
d.setDisposeWhenPointerOutOfBounds(true);
//d.show(h /8 * 7, 1, 0, 0);
Button close = new Button("Close");
close.addActionListener((ee) -> d.dispose());
Label l=new Label("              ");
Label l1=new Label("                ");
d.add(l1);
d.add(l);
d.addComponent(close);
d.show(h/3, h/2, 1, 1);
            }};        
 connectionRequest.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/fav?user="+idu+"&prod="+idp);
              //    System.out.println("url= "+connectionRequest.getUrl());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    
     }
 public ArrayList<Produit> All_Favoris_Produit(String json){
     
       // List<Produit> Produits = new ArrayList<>();
          
                   ArrayList<Produit> produits = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
   
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String,Object> obj : list)  {
                        produits.add(
new Produit(
                                (int) (double) obj.get("idproduit"),
                                (String) obj.get("nomproduit"),
                                (float) (double) obj.get("prix"),
                                (String) obj.get("descriptionproduit"),
                                (String) obj.get("categorie"),
                                (String) obj.get("nomimage"))
                      
                        );                        
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
        return produits;
            }

                           
           
        
        
     
 public ArrayList<Produit> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/allfav");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduit ser = new ServiceProduit();
                produits = ser.All_Favoris_Produit(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return produits;
    }
    
    public void removeProduitfav(int idp){   // remove book by title
      //  System.out.println("kkkkkkkkk");
        connectionRequest = new ConnectionRequest(){
        @Override
            protected void postResponse() {
            
                   
           Dialog d = new Dialog("Remove book from database");
           Dialog d1;
          
           {}
            }  
        };
        System.out.println("idp dans service produit.removeproduitfav= "+idp);
        connectionRequest.setUrl("http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/fav/"+idp);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
    

    
}
   

