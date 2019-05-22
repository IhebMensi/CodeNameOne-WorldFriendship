/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Evenement;

import com.mycompany.Service.ServiceEvenement;



/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff,btnaff1;

    public HomeForm( Resources res  ) {
        f = new Form("home");
        tnom = new TextField("","nom");
        tetat = new TextField("","état");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
          btnaff1=new Button("Affichage1");
        f.add(tnom);
        f.add(tetat);
        f.add(btnajout);
        f.add(btnaff);
        f.add(btnaff1);
//        btnajout.addActionListener((e) -> {
//            ServiceTask ser = new ServiceTask();
//            Task p = new Task( 0,tnom.getText(),tetat.getText());
//            ser.ajoutTask(p);
//            
//
//        });
             btnajout.addActionListener((e) -> {
              ServiceEvenement a=new ServiceEvenement();
            Evenement eve = new Evenement(0, tnom.getText());
           a.ajoutEvenement(eve);
            

        });
        btnaff.addActionListener((e)->{
        Affichagecat a=new Affichagecat(res);
        a.getF().show();
        });
           btnaff1.addActionListener((e)->{
        Affichgeeve a=new Affichgeeve();
//        a.getF().show();
        });
    }

    HomeForm() {
         }

   
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
