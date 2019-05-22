/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Service.ServiceEvenement;
import com.mycompany.Service.ServiceUser;
import static com.mycompany.gui.Affichagecat.participerbtn;

/**
 *
 * @author Marwa
 */
public class Login extends Form{
    
     public Login(Resources theme) {
       
         
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome, ", "WelcomeWhite"),
                new Label("World Friendship", "WelcomeBlue")
        );
        
        getTitleArea().setUIID("Container");
        
        Image profilePic = theme.getImage("logofs.png");
       //// Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(400,400);
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
    //    profilePicLabel.setMask(mask.createMask());
        
        TextField login = new TextField("", "Login", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
         ServiceEvenement se = new ServiceEvenement();
        // System.out.println(se.find());
//     ServiceUser sm = new ServiceUser();
//         System.out.println( sm.find()); 
        Button loginButton = new Button("LOGIN");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
            System.out.println(login.getText());
            System.out.println(password.getText());
       ConnectionRequest con5 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/mpp/" + login.getText()+"/"+password.getText();
        // + "/" + p.getContenupublicte();// création de l'URL
        con5.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con5.addResponseListener((s) -> {
           
            String str = new String(con5.getResponseData());//Récupération de la réponse du serveur
              System.out.println(str);
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
   
            int k = Integer.parseInt(str);
            System.out.println("lo "+k);
       if (k == 1)
       { 
     Toolbar.setGlobalToolbar(false);
            new WalkthruForm(theme).show();
            Toolbar.setGlobalToolbar(true);
        }
       else {  Dialog.show("non", "verifier" , "OK", null);}
      
      
      
        });
       
        NetworkManager.getInstance().addToQueueAndWait(con5);
   
        });
        
        Button createNewAccount = new Button("CREATE NEW ACCOUNT");
        createNewAccount.setUIID("CreateNewAccountButton");
        
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        Container by = BoxLayout.encloseY(
                welcome,
                profilePicLabel,
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton,
                createNewAccount
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
    
   
}
