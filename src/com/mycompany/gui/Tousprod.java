/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import javafx.scene.control.ToolBar;

/**
 *
 * @author asus
 */
public class Tousprod extends SideMenuBaseForm {
    private EncodedImage enc;
   private  ConnectionRequest connectionRequest;
   
     Form  listOfBooks = new Form();
          Form  f = new Form();

        private Image img,img1;
    private ImageViewer imgv;
private Label l1,l2,l3,l4;
private SpanLabel Nomprod,descprod,prixprod,catprod;
private TextField Nomprod1,descprod1,prixprod1,catprod1;
    private String url;
  ArrayList<String> libsNoms = new ArrayList<>();
private Container mainContainer,ImageContainer,favContainer;
ServiceProduit s =new ServiceProduit();

    public Tousprod(Resources res)
    {super(BoxLayout.y());   
ArrayList<Produit>list =s.getList();
        for(Produit l :list)    
    {
        System.out.println("aaa");
        try {
            enc =EncodedImage.create("/load.png");
        } catch (IOException ex) {
            //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
             url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+l.getNomimage();
             System.out.println(url);
         img=URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE); 
             imgv=new ImageViewer(img);
                    libsNoms.add(l.getNomproduit()+"      "+l.getPrix()+"dt");
                      Container cc=new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container cc2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                      cc2.add(""+l.getPrix());
					cc2.add(l.getNomproduit());
                                        Button Favorite = new Button("Add To Favorite");
                                        Button Mail = new Button("Mail");
                                        Button SMS = new Button("SMS");
                                        Button b = new Button("Détails");
                                        b.addActionListener((ActionListener) (ActionEvent evt) -> {
                                            Form detailProduit=new Form("Details Produit");
                                                                         Toolbar tb=detailProduit.getToolbar();
               tb.addCommandToLeftBar("back", null,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
            Tousprod t=new Tousprod(res);
              }
          });
                                                Form favProduit=new Form();

                                                      Button retour=new Button("Back");


               detailProduit.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
               String url1="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+l.getNomimage();
               img1=URLImage.createToStorage(enc,/*Nom image lorsque bch isobha f telifoun*/ url1, url1, URLImage.RESIZE_SCALE);
            ImageViewer imgDetails=new ImageViewer(img1);
            Label nomDetails=new Label("");
            String url2="http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/find/"+l.getIdproduit(); 
            ConnectionRequest con =new ConnectionRequest(); 
            con.setUrl(url2); 
            con.addResponseListener((t)->{ 
            String str=new String(con.getResponseData()); 
            nomDetails.setText(l.getNomproduit()+"         "+l.getPrix()+"DT");
            }); 
            NetworkManager.getInstance().addToQueueAndWait(con);
           // Label quantite=new Label("Quantitée: ");
          
//            detailProduit.add(imgDetails);
//            detailProduit.add(nomDetails);
            //detailProduit.add(quantite);
            ImageContainer=new Container();
        ImageContainer.setLayout(new FlowLayout(CENTER,CENTER));
         mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
         l1 = new Label("Title:");
        Nomprod = new SpanLabel(l.getNomproduit()); 
        l2 = new Label("Category:");
        descprod = new SpanLabel(l.getDescriptionproduit());
        l3 = new Label("Desc:");
        catprod=new SpanLabel(l.getCategorie());
        l4 = new Label("Prix:");
        prixprod= new SpanLabel(""+l.getPrix());
     ImageContainer.add(img1);
      favContainer = new Container();
  favContainer.setLayout(new FlowLayout());
  Label lab =new Label("                                         ");
  favContainer.add(lab);
  favContainer.add(Favorite);
  
        //mainContainer.add(new Label());
     //   Statics.setLabelStyle(l2);
        mainContainer.add(l1);
      //  Statics.setLabelStyle(l3);
        mainContainer.add(Nomprod);
        mainContainer.add(l2);
        mainContainer.add(catprod);
      //  Statics.setLabelStyle(l4);
        mainContainer.add(l3);
        mainContainer.add(descprod);
       // Statics.setLabelStyle(l5);
        mainContainer.add(l4);
       // mainContainer.add(categoryTf1);
        mainContainer.add(prixprod);
        mainContainer.add("Contacter Moi par :");
        mainContainer.add(new Label());
        mainContainer.add(Mail);
        mainContainer.add(SMS);
         mainContainer.add(retour);
        detailProduit.add(favContainer);
        //favProduit.show();
        detailProduit.add(ImageContainer);
               detailProduit.add(mainContainer);
               detailProduit.show();
               
                      Favorite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      if(Dialog.show("Alert", "Vous êtes sûre d'ajouté ce produit aux favoris", "Ok", "Cancel"))
         {
         
          new  ServiceProduit().Add_Favoris_Produit(3,l.getIdproduit());
         }
      else {System.out.println("");}
           }});                 
                                        });
                                         Mail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nom=Nomprod.getText();
       new Mail(nom);
           }});       
                                         SMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                                      new SMS();
                    }});    
                                         
                                        cc2.add(b);
                                        cc.add(imgv);
					cc.add(cc2);
                                        f.add(cc); 
    }
        
        com.codename1.ui.List uiLibsList = new com.codename1.ui.List();

                
                 com.codename1.ui.list.DefaultListModel<String> listModel = new com.codename1.ui.list.DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Produit currentBook = (Produit) list.get(uiLibsList.getCurrentSelected());
                       new EspaceProduit(
                               currentBook.getIdproduit(),
                               currentBook.getNomproduit(),
                               currentBook.getDescriptionproduit(),
                               currentBook.getCategorie(),
                               currentBook.getPrix(),
                               currentBook.getNomimage()
                       ).show();
                    }
                });
                listOfBooks.add(f);
              
                                                                     Toolbar tb=listOfBooks.getToolbar();
               tb.addCommandToLeftBar("back", null,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
           // Affichge1 t=new Affichge1();
              }
          });
                   
           listOfBooks.show();     
                      
    }
    public void aaditem(Produit l)
    {

        try {
            enc =EncodedImage.create("/load.png");
        } catch (IOException ex) {
            //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
             url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+l.getNomimage();
             System.out.println(url);
         img=URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE); 
             imgv=new ImageViewer(img);
                    libsNoms.add(l.getNomproduit()+"      "+l.getPrix()+"dt");
                      Container cc=new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container cc2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                      cc2.add(""+l.getPrix());
					cc2.add(l.getNomproduit());
                                        Button Favorite = new Button("Add To Favorite");
                                        Button Mail = new Button("Mail");
                                        Button SMS = new Button("SMS");
                                        Button b = new Button("Détails");
                                        b.addActionListener((ActionListener) (ActionEvent evt) -> {
                                            Form detailProduit=new Form("Details Produit");
                                                Form favProduit=new Form();

                                                      Button retour=new Button("Back");


               detailProduit.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
               String url1="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+l.getNomimage();
               img1=URLImage.createToStorage(enc,/*Nom image lorsque bch isobha f telifoun*/ url1, url1, URLImage.RESIZE_SCALE);
            ImageViewer imgDetails=new ImageViewer(img1);
            Label nomDetails=new Label("");
            String url2="http://localhost/PIDev_WorldFriendship/web/app_dev.php/client/ven/tasks/find/"+l.getIdproduit(); 
            ConnectionRequest con =new ConnectionRequest(); 
            con.setUrl(url2); 
            con.addResponseListener((t)->{ 
            String str=new String(con.getResponseData()); 
            nomDetails.setText(l.getNomproduit()+"         "+l.getPrix()+"DT");
            }); 
            NetworkManager.getInstance().addToQueueAndWait(con);
           // Label quantite=new Label("Quantitée: ");
          
//            detailProduit.add(imgDetails);
//            detailProduit.add(nomDetails);
            //detailProduit.add(quantite);
            ImageContainer=new Container();
        ImageContainer.setLayout(new FlowLayout(CENTER,CENTER));
         mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
         l1 = new Label("Title:");
        Nomprod = new SpanLabel(l.getNomproduit()); 
        l2 = new Label("Category:");
        descprod = new SpanLabel(l.getDescriptionproduit());
        l3 = new Label("Desc:");
        catprod=new SpanLabel(l.getCategorie());
        l4 = new Label("Prix:");
        prixprod= new SpanLabel(""+l.getPrix());
     ImageContainer.add(img1);
      favContainer = new Container();
  favContainer.setLayout(new FlowLayout());
  Label lab =new Label("                                         ");
  favContainer.add(lab);
  favContainer.add(Favorite);
  
        //mainContainer.add(new Label());
     //   Statics.setLabelStyle(l2);
        mainContainer.add(l1);
      //  Statics.setLabelStyle(l3);
        mainContainer.add(Nomprod);
        mainContainer.add(l2);
        mainContainer.add(catprod);
      //  Statics.setLabelStyle(l4);
        mainContainer.add(l3);
        mainContainer.add(descprod);
       // Statics.setLabelStyle(l5);
        mainContainer.add(l4);
       // mainContainer.add(categoryTf1);
        mainContainer.add(prixprod);
        mainContainer.add("Contacter Moi par :");
        mainContainer.add(new Label());
        mainContainer.add(Mail);
        mainContainer.add(SMS);
         mainContainer.add(retour);
        detailProduit.add(favContainer);
        //favProduit.show();
        detailProduit.add(ImageContainer);
               detailProduit.add(mainContainer);
               detailProduit.show();
                      Favorite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      if(Dialog.show("Alert", "Vous êtes sûre de supprimé ce produit", "Ok", "Cancel"))
         {
         
          new  ServiceProduit().Add_Favoris_Produit(3,l.getIdproduit());
         }
      else {System.out.println("");}
           }});                 
                                        });
                                         Mail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nom=Nomprod.getText();
       new Mail(nom);
           }});       
                                         SMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                                      new SMS();
                    }});    
                                         
                                        cc2.add(b);
                                        cc.add(imgv);
					cc.add(cc2);
                                        f.add(cc);                      
         
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
     
     private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }
  public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
