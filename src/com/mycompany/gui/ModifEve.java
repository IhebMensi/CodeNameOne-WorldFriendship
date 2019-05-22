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
import com.mycompany.Entite.Evenement;
import com.mycompany.Service.ServiceEvenement;

/**
 *
 * @author Marwa
 */
public class ModifEve {
             Form f;
    TextField tnomeve;
    TextField tdesceve;
    
    Button btnMod,btnAnnuler;

//    ModifForm(Event li, Resources res) {
//    }

    public  ModifEve( Evenement e,Resources res) {
        f = new Form("Modification");
        tnomeve = new TextField(e.getNomevenement());
        tnomeve.getAllStyles().setFgColor(CYAN);
        tdesceve = new TextField(e.getDescriptionevenement());
        tdesceve.getAllStyles().setFgColor(CYAN);
    
        
        btnMod = new Button("Modifier evenement");
        btnAnnuler=new Button("Annuler");
        f.add(tnomeve);
        f.add(tdesceve);
  
        
        f.add(btnMod);
        f.add(btnAnnuler);
        btnMod.addActionListener((k) -> {
            ServiceEvenement ser = new ServiceEvenement();
            e.setNomevenement(tnomeve.getText());
           
            e.setDescriptionevenement(tdesceve.getText());

//            Event t = new Event( ttitre.getText(),
//                    tlieu.getText() ,
//                    Double.valueOf(tprix.getText()), 
//                   // Double.parseDouble(tprix.getText()),
//                    tdescription.getText(),     
//                    Integer.parseInt(tnbreticket.getText()));
//            //Event t = new Event( ttitre.getText(), tdescription.getText(), Double.parseDouble(tprix.getText()), tlieu.getText() ,Integer.parseInt(tnbreticket.getText()));

            System.out.println("9bal modif");
            
            ser.modifierEvenement(e);
            
            System.out.println("baad l modif");
//                        Dialog.show("Succés", "Evenement modifié", "ok", null);

            

        }); 
        
        btnAnnuler.addActionListener((f)->{
        testaff2 a=new testaff2(res);
        a.show();
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


 
    
}
