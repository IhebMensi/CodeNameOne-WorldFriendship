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
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
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
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class EspaceMyProduit extends SideMenuBaseForm {
          ArrayList<String> libsNoms = new ArrayList<>();

    private  Label l2,l3,l4,l5,l6;
    private  TextField newNom,newdesc,newcategorie,newprix;
    private  Container mainContainer,ImageContainer,btnaddContainer;
    private  Button editBtn,removeBtnn;
    private Produit prod;
       private EncodedImage enc;
Resources res;
        private Image img;
    private ImageViewer imgv;
 
   private  ConnectionRequest connectionRequest;
   
     Form  listOfBooks = new Form();
          Form  f = new Form();
        private Image img1;
private SpanLabel Nomprod,descprod,prixprod,catprod;
private TextField Nomprod1,descprod1,prixprod1,catprod1;
    private String url;

ServiceProduit s =new ServiceProduit();
        public EspaceMyProduit(Resources res){
              super(BoxLayout.y());
              ArrayList<Produit>list =s.getList1();

          for(Produit p :list)    
    {
        additem(p);
    }
           Toolbar tb=  f.getToolbar();
     tb.addCommandToLeftBar("back", null,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
            Tousprod t=new Tousprod(res);
              }
          });
        f.show();
                com.codename1.ui.List uiLibsList = new com.codename1.ui.List();

com.codename1.ui.list.DefaultListModel<String> listModel = new com.codename1.ui.list.DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Produit currentBook = list.get(uiLibsList.getCurrentSelected());
                     
                     }
                });
                
                      
    }

        public void additem(Produit l)
        {
        try {
            enc =EncodedImage.create("/load.png");
        } catch (IOException ex) {
            //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
             url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+l.getNomimage();
             System.out.println(url);
         img=URLImage.createToStorage(enc,/*Nom image lorsque bch isobha f telifoun*/ url, url, URLImage.RESIZE_SCALE); 
             imgv=new ImageViewer(img);
//listOfBooks.add(imgv);
                    libsNoms.add(l.getNomproduit()+"      "+l.getPrix()+"dt");
                      Container cc=new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container cc2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                        
                      cc2.add(""+l.getPrix());
					cc2.add(l.getNomproduit());
                                        Button Supprimer = new Button("Supprimer");
                                        Button Modifier = new Button("Modifier");

                                        Button b = new Button("Détails");
                                        b.addActionListener((ActionListener) (ActionEvent evt) -> {
                                            Form detailProduit=new Form("Details Produit");
                                             Toolbar tb=  detailProduit.getToolbar();
     tb.addCommandToLeftBar("back", null,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
            Tousprod t=new Tousprod(res);
              }
          });
                                                //this.setLayout(new BorderLayout());

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
            Label l1 = new Label("Title:");
        Nomprod1 = new TextField(l.getNomproduit()); 
        l2 = new Label("Category:");
        descprod1 = new TextField(l.getDescriptionproduit());
        l3 = new Label("Desc:");
        catprod1=new TextField(l.getCategorie());
        l4 = new Label("Prix:");
        prixprod1= new TextField(""+l.getPrix());
     ImageContainer.add(img1);

        //mainContainer.add(new Label());
     //   Statics.setLabelStyle(l2);
        mainContainer.add(l1);
      //  Statics.setLabelStyle(l3);
              mainContainer.add(Nomprod1);
        mainContainer.add(l2);
        mainContainer.add(catprod1);
      //  Statics.setLabelStyle(l4);
        mainContainer.add(l3);
                mainContainer.add(descprod1);
       // Statics.setLabelStyle(l5);
        mainContainer.add(l4);
       // mainContainer.add(categoryTf1);
        mainContainer.add(prixprod1);
        mainContainer.add("Contacter Moi par :");
        mainContainer.add(new Label());

        mainContainer.add(Supprimer);
        Supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      if(Dialog.show("Alert", "Vous êtes sûre de supprimé ce produit", "Ok", "Cancel"))
         {
          new ServiceProduit().removeProduit(l.getIdproduit());
          new  ServiceProduit().getList1();
         }
      else {System.out.println("");}
           }}); 
        Button retour=new Button("Back");
        mainContainer.add(Modifier);
        mainContainer.add(retour);
        Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      if(Dialog.show("Alert", "Vous êtes sûre de supprimé ce produit", "Ok", "Cancel"))
         {
      
              Produit p=new Produit(
           Nomprod1.getText(),Float.parseFloat(prixprod1.getText()),descprod1.getText(),catprod1.getText()
           );
          new  ServiceProduit().updateProduit(p ,l.getIdproduit());
    new  ServiceProduit().getList1();

         }
      else {System.out.println("");}
           }}); 
        detailProduit.add(ImageContainer);
               detailProduit.add(mainContainer);
               detailProduit.show();
                                        });
        cc2.add(b);
        
        
                    cc.add(imgv);
					cc.add(cc2);
                                      
                                        f.add(cc);
  

                                        

                }

    @Override
    protected void showOtherForm(Resources res) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
