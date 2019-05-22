/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.MultiButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author asus
 */
public class InterfaceAjoutProduit  extends Form{
       private final Label l1,l2,l3,l4,l5;
    private final TextField nomp,prix,nImage;
    private final TextArea description;
    private final Container mainContainer;
    private final Button addBtn;
    ServiceProduit Servicep = new ServiceProduit();
    
   public InterfaceAjoutProduit(){
       Validator vnom=new Validator();
      
       
        this.setLayout(new BorderLayout());
        Form hi = new Form ( " ComboBox " , new BoxLayout ( BoxLayout . Y_AXIS )); 
         ComboBox<Map<String, Object >> combo;
           combo = new ComboBox<> (
                   createListEntry("PC", "1996"),
                   createListEntry("Jeux_Vidéo", "1998"),
                   createListEntry("Jeux de Table", "2000"),
                   createListEntry("Musique", "1998")
                   
           );
           Toolbar tb=  hi.getToolbar();
     tb.addCommandToLeftBar("back", null,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
            ServiceProduit s=new ServiceProduit();
            s.getList();
              }
          });

        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,1));
        l1 = new Label("Ajouter un Produit");
        l1.setAlignment(CENTER);
        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(-16777216);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        l2 = new Label("Nom Produit:");
        nomp = new TextField(""); 
        l3 = new Label("Description:");
        description = new TextArea("");       
         l4 = new Label("Prix:");
        prix = new TextField(""); 
        l5 = new Label("Categorie:");
        //categorie = new TextField("");   
        addBtn= new Button("Ajouter");
        addBtn.getUnselectedStyle().setFgColor(5542241);
            Button    upload= new Button("Upload");
          
             nImage=new TextField(); 
             vnom.addConstraint(nomp, new LengthConstraint(2));
             vnom.addConstraint(description, new LengthConstraint(4));
           //  vnom.addConstraint(prix, new );

             TextField n =new TextField();
                //          upload.setUIID("LoginButton");

            upload.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                      String path;
                    if (ev != null && ev.getSource() != null) {
                        path =  (String) ev.getSource();
                       // System.out.println(path.substring(7));
                        Image img = null;
                        nImage.setText(path.substring(7));//image heya just label nsob feha fel path
                        try {
                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                        } catch (IOException ex) {
                        }
                        System.out.println(img);
                    }
                }
            }, Display.GALLERY_IMAGE);
        });
        mainContainer.add(l1);
        mainContainer.add(new Label());
       // Utils.setLabelStyle(l2);
        mainContainer.add(l2);
        mainContainer.add(nomp);  
    //    Utils.setLabelStyle(l3);
        mainContainer.add(l3);
          mainContainer.add(description);  
                mainContainer.add(l4);
                  mainContainer.add(prix);  
        mainContainer.add(l5);
          mainContainer.add(combo);  

        
            
        mainContainer.add(addBtn);
                mainContainer.add(nImage);
                mainContainer.add(n);

                mainContainer.add(upload);


        //backBtn = Utils.createBackBtn(); 
      //  mainContainer.add(backBtn);
        addBtn.addActionListener(e -> {
           
       try {
           
           // add a book
           
           FileUploader fc = new FileUploader("localhost/PIDev_WorldFriendship/web/");
           String f = fc.upload(nImage.getText());
               String txt=""+n.getText();
               System.out.println(f);
               Produit  p = new Produit();
                    p.setNomproduit(nomp.getText());
                       p.setPrix(Float.parseFloat(prix.getText()));
                       p.setDescriptionproduit(description.getText());
                       p.setCategorie(combo.getSelectCommandText().toString());
                       p.setNomimage(f)
                       
               ;
              // p.setNomimage(f);
           //    System.out.println(p.toString());
              Servicep.addProduit(p);
               
           } catch (Exception ex) {
           }
            
        });
       
        

   
   }
         private ArrayList<String> createListEntry(String name, String date) {
ArrayList<String> entry = new ArrayList<>(); 
entry.add( name);
    
    return entry;    

}
       
}
