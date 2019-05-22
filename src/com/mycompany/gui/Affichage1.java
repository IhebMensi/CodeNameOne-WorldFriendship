    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Pub;
import com.mycompany.Service.ServicePub;
import java.io.IOException;
import java.util.ArrayList;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author ihebm
 */
public class Affichage1 {
       Form f;
    SpanLabel lb;
   private Image img;
    private String url;
    private Button btnsupp;
       private ImageViewer imgv;
       private EncodedImage enc;
    public Affichage1() {
        
        f = new Form("l",BoxLayout.y());
        ServicePub SP= new ServicePub();
  ArrayList<Pub> lis = SP.getList2();
        ServicePub servicepub=new ServicePub();
       // lb.setText(servicepub.find().toString());
       Label l = new Label(servicepub.find().getNompublicite());
       btnsupp=new Button("Supprimer");
       f.add(l);
       String k = servicepub.find().getNomimage();
        System.out.println(k);
        
     //  C:\xampp\htdocs\PIDev_WorldFriendship\web\images
       url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+k; 
       
         try {
            enc=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img=URLImage.createToStorage(enc,url , url, URLImage.RESIZE_SCALE);
        imgv=new ImageViewer(img);
 f.add(imgv);
 f.add(btnsupp);
    lb = new SpanLabel(servicepub.find().getContenupublicte());
        f.add(lb);
//          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
//          h.getF().show();
//          });
//          for (Pub p :lis)
//          {
//            btnsupp.addActionListener((e) -> {
//             ServicePub ser = new ServicePub();
////            ser.supprimerPub(p);
//            });
//            

    
//            
//             } 
}

    

 

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
