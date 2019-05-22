/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import static com.codename1.charts.util.ColorUtil.CYAN;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;

import com.mycompany.Entite.Pub;
import com.mycompany.Service.ServicePub;

/**
 *
 * @author ihebm
 */
public class ModifPub {
            Form f;
    TextField tnompub;
    TextField tcontenupub;
    
    Button btnMod,btnAnnuler;

//    ModifForm(Event li, Resources res) {
//    }

    public  ModifPub( Pub p,Resources res) {
        f = new Form("Modification");
        tnompub = new TextField(p.getNompublicite());
        tnompub.getAllStyles().setFgColor(CYAN);
        tcontenupub = new TextField(p.getContenupublicte());
        tcontenupub.getAllStyles().setFgColor(CYAN);
    
        
        btnMod = new Button("Modifier");
        btnAnnuler=new Button("Annuler");
        f.add(tnompub);
        f.add(tcontenupub);
  
        
        f.add(btnMod);
        f.add(btnAnnuler);
        btnMod.addActionListener((e) -> {
            ServicePub ser = new ServicePub();
            p.setNompublicite(tnompub.getText());
           
            p.setContenupublicte(tcontenupub.getText());

//            Event t = new Event( ttitre.getText(),
//                    tlieu.getText() ,
//                    Double.valueOf(tprix.getText()), 
//                   // Double.parseDouble(tprix.getText()),
//                    tdescription.getText(),     
//                    Integer.parseInt(tnbreticket.getText()));
//            //Event t = new Event( ttitre.getText(), tdescription.getText(), Double.parseDouble(tprix.getText()), tlieu.getText() ,Integer.parseInt(tnbreticket.getText()));

            System.out.println("9bal modif");
            
            ser.modifierPub(p);
            
            System.out.println("baad l modif");
//                        Dialog.show("Succés", "Evenement modifié", "ok", null);

            

        }); 
        
        btnAnnuler.addActionListener((e)->{
        Affichagep a=new Affichagep();
        a.getF().show();
        });
        
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{testaff2 h=new testaff2(res);
          h.show();
          });
        f.show();
        
    }

    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

//    public TextField getTnom() {
//        return ttitre;
//    }
//
//    public void setTnom(TextField ttitre) {
//        this.ttitre = ttitre;
//    }

}
