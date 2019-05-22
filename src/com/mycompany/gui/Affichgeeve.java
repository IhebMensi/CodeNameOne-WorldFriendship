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
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.ServiceEvenement;
import com.mycompany.Service.ServicePub;
import java.io.IOException;
/**
 *
 * @author Marwa
 */
public class Affichgeeve {
   
      Form f,form;
    SpanLabel lb;
    private Image img,img1;
    private String url,url1;
       private ImageViewer imgv,imgv1;
       private EncodedImage enc,enc1;
        public static Button suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn,annulerbtn,like,dislike;
 
    public Affichgeeve() {
        Evenement e = Affichagecat.kaa;
  
        System.out.println("mo"+e.getIdevenement());
              ServiceEvenement se = new ServiceEvenement();
              System.out.println(se.find().getIdevenement());
                form = new Form(BoxLayout.y());
                Label lbser = new Label("ok");
                Label lbser1 = new Label();
                Label lbser2 = new Label();
                Label Title = new Label("Les details de l'évenement");

                Container F3 = new Container(BoxLayout.y());
                F3.add(Title);

                F3.add(lbser);
                F3.add(lbser1);
                F3.add(lbser2);

                System.out.println("imaage");

              

                form.add(F3);
                 form.show();
                

        
        
//          form.getToolbar().addCommandToRightBar("back", null, (ev1)->{HomeForm h=new HomeForm();
//          h.getF().show();
//          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    

}
