/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.type_evenement;
import com.mycompany.Service.ServiceEvenement;
import java.io.IOException;
import java.util.ArrayList;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author Marwa
 */
public class Ajoutereve11 extends Form { 
       Form f;
    TextField tnomev;
    TextField tdesc;
        TextField    image;
            ComboBox<type_evenement> Type;

//    Button btnajout,btnimage;
//    Picker picker1;
//    Picker picker2;
    String path;
    public Ajoutereve11(Resources theme,Resources res) {
       
     
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
            setUIID("addevent");
            
         Container welcome = FlowLayout.encloseCenter(
              
                new Label("World Friendship", "WelcomeBlue")
        );
         Container welcome2 = FlowLayout.encloseCenter(
                new Label(" ", "WelcomeWhite")
             
        );
           Container welcome3 = FlowLayout.encloseCenter(
                new Label(" ", "WelcomeWhite")
             
        );
             Container welcome4 = FlowLayout.encloseCenter(
                new Label(" ", "WelcomeWhite")
             
        );
               Container welcome5 = FlowLayout.encloseCenter(
                new Label(" ", "WelcomeWhite")
             
        );
        Container welcome1 = FlowLayout.encloseCenter(
                new Label("Ajouter Evenement ", "WelcomeWhite")
             
        );
        getTitleArea().setUIID("Container");
        
        Image profilePic = theme.getImage("logofs.png");
       //// Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(400,400);
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
           TextField tnomev = new TextField("", "Nom Event", 20, TextField.EMAILADDR) ;
        TextField tdesc = new TextField("", "Description Event", 20, TextField.EMAILADDR) ;
        tnomev.getAllStyles().setMargin(LEFT, 0);
        tdesc.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_EVENT_NOTE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_BOOK, 3);
        Picker picker2=new Picker();
       Picker  picker1 = new Picker();
             picker2.getAllStyles().setMargin(LEFT, 0);
                 picker1.getAllStyles().setMargin(LEFT, 0);
   //     startDate = new Date();
picker1.setType(Display.PICKER_TYPE_DATE);
picker2.setType(Display.PICKER_TYPE_DATE);
//
  TextField pays = new TextField("", "Pays", 20, TextField.EMAILADDR) ;
        //TextField adress = new TextField("", "Region", 20, TextField.EMAILADDR) ;
        pays.getAllStyles().setMargin(LEFT, 0);
       // adress.getAllStyles().setMargin(LEFT, 0);
          TextField region = new TextField("", "Region", 20, TextField.EMAILADDR) ;
        TextField nbr = new TextField("", "Nbr pari", 20, TextField.EMAILADDR) ;
        region.getAllStyles().setMargin(LEFT, 0);
        nbr.getAllStyles().setMargin(LEFT, 0);
//    Type = new ComboBox<type_evenement>();
//        ServiceEvenement ser1 = new ServiceEvenement();
//        ArrayList<type_evenement> listev = (ArrayList<type_evenement>) ser1.getListTypeEv();
//        for (type_evenement b : listev) {
//            Type.addItem(b);
//        }
  image = new TextField();
                
            Button     btnimage = new Button("Inserer Image");
             btnimage.setUIID("LoginButton");
        btnimage.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        path = (String) ev.getSource();
                        System.out.println(path.substring(7));
                        Image img = null;
                        image.setText(path.substring(7));//image heya just label nsob feha fel path
                        try {
                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                            System.out.println(img);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }, Display.GALLERY_IMAGE);
        });
        
        
               ServiceEvenement se = new ServiceEvenement();
  System.out.println(se.find());
//     ServiceUser sm = new ServiceUser();
//         System.out.println( sm.find()); 
        Button loginButton = new Button("Ajouter Eventem");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
           
       FileUploader fc = new FileUploader("localhost/PIDev_WorldFriendship/web/");
            try {
                String f = fc.upload(image.getText());
                System.out.println("lo"+f);
            ServiceEvenement ser = new ServiceEvenement();
           DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
    
            //  startDate =  picker1.getda;
       
          
            
               //  System.out.println("1"+startDate);
                 System.out.println("2"+picker2.getValue());
                 System.out.println(tdesc.getText());
             //    System.out.println(picker1.getFormatter(new SimpleDateFormat("MM/dd/yyyy")));
            Evenement ee = new Evenement(0, tnomev.getText(),tdesc.getText(), picker1.getDate(),picker2.getDate(),f,pays.getText(),region.getText(),Integer.parseInt(nbr.getText()));
            ser.ajoutEvenement(ee);
            Dialog.show("Ajout avec succes", "succes" , "OK", null);
           
           ProfileForm k = new ProfileForm(res);
           k.show();

        }   catch (Exception ex) {
         
            }
        });
//   
//        btnajout = new Button("ajouter");
//   
//        f.add(tnomev);
//        f.add(tdesc);
//          f.add(picker1);
//        f.add(picker2);
//        f.add(btnimage);
//        f.add(btnajout);
//       // f.add(tnomev);
//       // f.add(tdesc);
//    
//       // f.add(btnajout);
//
//                
////        btnajout.addActionListener((e) -> {
////            ServiceTask ser = new ServiceTask();
////            Task p = new Task( 0,tnom.getText(),tetat.getText());
////            ser.ajoutTask(p);
////            
////
////        });
//             btnajout.addActionListener((e) -> {
//                             FileUploader fc = new FileUploader("localhost/PIDev_WorldFriendship/web/");
//            try {
//                String f = fc.upload(image.getText());
//                System.out.println("lo"+f);
//            ServiceEvenement ser = new ServiceEvenement();
//           DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
//    
//            //  startDate =  picker1.getda;
//       
//          
//            
//               //  System.out.println("1"+startDate);
//                 System.out.println("2"+picker2.getValue());
//                 System.out.println(tdesc.getText());
//             //    System.out.println(picker1.getFormatter(new SimpleDateFormat("MM/dd/yyyy")));
//            Evenement ee = new Evenement(0, tnomev.getText(),tdesc.getText(), picker1.getDate(),picker2.getDate(),f);
//            ser.ajoutEvenement(ee);
//            
//
//        }   catch (Exception ex) {
//         
//            }
//            
//             });
       
      Container by = BoxLayout.encloseY(
                profilePicLabel,
               welcome,
              welcome2,
            welcome3,
               welcome1,
               welcome4,
            
                BorderLayout.center(tnomev).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(tdesc).
                        add(BorderLayout.WEST, passwordIcon),
                   BorderLayout.center(picker1),
                      BorderLayout.center(picker2),
                      BorderLayout.center(pays),
                      BorderLayout.center(region),
                      BorderLayout.center(nbr),
                      Type,
                      btnimage,
                    
                loginButton
              
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

  

    }
    

