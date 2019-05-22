/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Marwa
 */
public abstract class SideMenuBaseForm extends Form{
    Form f;
     private Resources theme = UIManager.initFirstTheme("/theme");;
      //theme = UIManager.initFirstTheme("/theme");
    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        Image profilePic = res.getImage("logofs.png");
       // Image mask = res.getImage("round-mask.png");
       // mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(300,300);
        Label profilePicLabel = new Label("  World Friendship", profilePic, "SideMenuTitle");
//        profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        Affichage a ; 
       
        getToolbar().addComponentToSideMenu(sidemenuTop);
        getToolbar().addMaterialCommandToSideMenu("  Liste des Publicites", FontImage.MATERIAL_LIST,  e -> new testaff21(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Publicite", FontImage.MATERIAL_PUBLISH,  e ->  new Affichagecat(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Mes Pub", FontImage.MATERIAL_ACCESS_TIME,  e -> new testaff2(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Ajouter Publicite", FontImage.MATERIAL_ADD,  e -> new Ajoutereve(theme,res).show());
        
        getToolbar().addMaterialCommandToSideMenu("  Ajouter Reclamation", FontImage.MATERIAL_COMMENT,  e -> new RecForm(res).getF().show());
        getToolbar().addMaterialCommandToSideMenu("  Donner Feedback", FontImage.MATERIAL_RATE_REVIEW,  e -> new Eval(res).getF().show());
 getToolbar().addMaterialCommandToSideMenu("  Liste des evenements", FontImage.MATERIAL_DASHBOARD,  e -> new testaff(res).show());
      //  getToolbar().addMaterialCommandToSideMenu("  Stat", FontImage.MATERIAL_EVENT,  e ->   s.createPieChartForm(theme,res).show());
        getToolbar().addMaterialCommandToSideMenu("  Mes Evenements", FontImage.MATERIAL_ACCESS_TIME,  e -> new testaff2(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Ajouter Event", FontImage.MATERIAL_SETTINGS,  e -> new Ajoutereve11(theme,res).show());
     //   getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new ProfileForm(res));
 

//         try {
//            a = new Affichage();
//            getToolbar().addMaterialCommandToSideMenu("  cat", FontImage.MATERIAL_EXIT_TO_APP,  e -> a.getF().show());
//
//        } catch (IOException ex) {
//            //Logger.getLogger(SideMenuBaseForm.class.getName()).log(Level.SEVERE, null, ex);
//        }   
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new Login(res).show());
//     ArrayList<Produit> Ar =ServiceProduit.produits;
//     getToolbar().addMaterialCommandToSideMenu("Espace Vente ", FontImage.MATERIAL_EXIT_TO_APP,  e -> new Tousprod(Ar,res));
//      getToolbar().addMaterialCommandToSideMenu("Espace Favoris ", FontImage.MATERIAL_EXIT_TO_APP,  e -> {
//            try {
//                new EspaceFAv(Ar);
//            } catch (IOException ex) {
//             //   Logger.getLogger(SideMenuBaseForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//     getToolbar().addMaterialCommandToSideMenu(" Mon Espace ", FontImage.MATERIAL_EXIT_TO_APP,  e -> new EspaceMyProduit(Ar));
// 

 getToolbar().addMaterialCommandToSideMenu("Espace Vente", FontImage.MATERIAL_EXIT_TO_APP,  e -> new Tousprod(res));
            getToolbar().addMaterialCommandToSideMenu("Espace Mes Produits", FontImage.MATERIAL_EXIT_TO_APP,  e -> new EspaceMyProduit(res));
            getToolbar().addMaterialCommandToSideMenu("Espace Favoris", FontImage.MATERIAL_EXIT_TO_APP,  e -> {
            try {
                new EspaceFAv(res);
            } catch (IOException ex) {
               // Logger.getLogger(SideMenuBaseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
  });
    }
    
    protected abstract void showOtherForm(Resources res);   
    
    
      public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
