/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.FavoritProduit;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;


/**
 *
 * @author asus
 */
public class FavoritInterface extends Form
{
        Resources res;
   private final Label l1,l2,l3,l4,l5;
    private final SpanLabel newNom,newdesc,newcategorie,newprix;
    private final Container mainContainer,ImageContainer;
    private final Button removeBtnn;
    private Produit prod;
       private EncodedImage enc;

        private Image img;
    private ImageViewer imgv;
   
public FavoritInterface(int idproduit,String nomproduit,float prix,String descriptionproduit,String categorie,String nomimage)
    {
         getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    EspaceFAv a = new EspaceFAv(res);
                } catch (IOException ex) {
                   // Logger.getLogger(FavoritInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        try {
            enc =EncodedImage.create("/load.png");
        } catch (IOException ex) {
            //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
                 prod = new Produit(idproduit,nomproduit, prix, descriptionproduit, categorie,nomimage);

        String url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+prod.getNomimage();
             System.out.println(url);
         img=URLImage.createToStorage(enc,/*Nom image lorsque bch isobha f telifoun*/ url, url, URLImage.RESIZE_SCALE); 
             imgv=new ImageViewer(img);
             imgv.setWidth(500);
                          imgv.setHeight(1000);
                 ImageContainer=new Container();
        ImageContainer.setLayout(new FlowLayout(CENTER,CENTER));
        ImageContainer.add(imgv);
        Form f= new Form("Produit Favoris");
//        f.add(ImageContainer);
//        f.show();
       // this.add(BoxLayout.X_AXIS_NO_GROW,ImageContainer);

    this.setLayout(new BorderLayout());
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
        l1 = new Label("Produit favoris");
        l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(-16777216);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        l2 = new Label("Nom Produit:");
        newNom = new SpanLabel(nomproduit); 
        l3 = new Label("Description:");
        newdesc = new SpanLabel(descriptionproduit);
        l4 = new Label("Categorie:");
        newcategorie= new SpanLabel(categorie);
        l5 = new Label("PRix:");
        newprix= new SpanLabel(""+(int) prix);
        
        removeBtnn= new Button("Retirer de mes FAV");
        removeBtnn.getUnselectedStyle().setFgColor(5542241);
        
        //mainContainer.add(l1);
Button retour=new Button("Back");
        mainContainer.add(l2);
                        mainContainer.add(newNom);
        mainContainer.add(l3);
                mainContainer.add(newdesc);
        mainContainer.add(l4);
                mainContainer.add(newcategorie);
        mainContainer.add(l5);
        mainContainer.add(newprix);
        mainContainer.add(removeBtnn);
       

    
       

removeBtnn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      if(Dialog.show("Alert", "Vous êtes sûre de supprimé ce produit de vos favoris", "Oui", "Non"))
        {System.out.println("ppppp"+idproduit);
          new ServiceProduit().removeProduitfav(idproduit);
           new  ServiceProduit().getList2();
         }
      else { System.out.println(""); }
           }}); 

 
        this.add(BorderLayout.NORTH,ImageContainer );
        this.add(BorderLayout.EAST, mainContainer);

    }
}
