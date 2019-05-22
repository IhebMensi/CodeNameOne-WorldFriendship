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
import com.mycompany.Entite.Reclamation;
import com.mycompany.Service.ServiceReclamation;

/**
 *
 * @author ihebm
 */
public class RecForm extends SideMenuBaseForm{
    Form f;
    TextField titre;
    TextField description;
    Button btnajout;

    public RecForm(Resources res) {
         f= new Form("rec");
        titre = new TextField("","titre");
        description= new TextField("","description");
        btnajout =new Button("ajout reclamation");
        f.add(titre);
        f.add(description);
        f.add(btnajout);
                     btnajout.addActionListener((e) -> {
      
                         ServiceReclamation ser = new ServiceReclamation();
          
    
            //  startDate =  picker1.getda;
        
             //    System.out.println(picker1.getFormatter(new SimpleDateFormat("MM/dd/yyyy")));
            Reclamation p = new Reclamation(0,titre.getText(),description.getText());
            ser.ajoutReclamation(p);
            

        
            
             });
                      
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProfileForm h=new ProfileForm(res);
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

    @Override
    protected void showOtherForm(Resources res) {
            }
    
    
}
