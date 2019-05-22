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
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.events.ScrollListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Pub;
import com.mycompany.Service.ServicePub;
import java.io.IOException;
//import com.sun.org.apache.bcel.internal.classfile.Code;
import java.util.ArrayList;


/**
 *
 * @author bhk
 */
public class Affichagep {
    public static Button suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn;
    Form f,form,F2;
    SpanLabel lb;
    private Image img,img1,img3;
    private String url,url1,url3;
    private TextField chnompub;
       private ImageViewer imgv,imgv1,imgv3;
       private EncodedImage enc,enc1,enc3;
    public Affichagep() {
        
        f = new Form(BoxLayout.y());
       F2 = new Form(BoxLayout.y());
        
        chnompub = new TextField();
        chnompub.setHint("titre");
        btnchercher = new Button("chercher");
        f.add(btnchercher);
        f.add(chnompub);
        ServicePub SP = new ServicePub();
        btnchercher.addActionListener((e) -> {
            Form F2 = new Form(BoxLayout.y());
            String d = chnompub.getText();
            ArrayList<Pub> liche = SP.recherchepub(d);
            System.out.println("nnn"+liche);
            for (Pub lis : liche) {
                  
                  url3="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+lis.getNomimage(); 
       
         try {
            enc3=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img3=URLImage.createToStorage(enc3,url3 , url3, URLImage.RESIZE_SCALE);
        imgv3=new ImageViewer(img3);
        
 F2.add(imgv3);
                Label aa1 = new Label("Nom publicite  : " + lis.getNompublicite());
                Label nbpl = new Label("Contenu publicite :" + lis.getContenupublicte());
              
                F2.add(aa1);
                //F2.add(datee);
                //F2.add(prixx);
                F2.add(nbpl);
               // F2.add(desc);
              
                F2.show();
                  F2.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });}
        });
        
        
        
        //lb = new SpanLabel("");
       // f.add(lb);
        ServicePub servicepub=new ServicePub();
        //lb.setText(servicepub.getList2().toString());
      //  Pub p = new Pub();
         //   ArrayList<Pub> listTasks1 = new ArrayList<>();
        ArrayList<Pub> po = servicepub.getList2();
        for ( Pub  p : po )
        {
                 suppbtn = new Button("Supprimer");
            modifbtn = new Button("Modifier");
            partagerbtn = new Button("Partager");
            participerbtn = new Button("Participer");
        Label  l = new Label(p.getNompublicite())  ;
        f.add(l);
        String k = p.getNomimage();
        System.out.println(k);
     
       url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+k; 
       
         try {
            enc=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img=URLImage.createToStorage(enc,url , url, URLImage.RESIZE_SCALE);
        imgv=new ImageViewer(img);
        
 f.add(imgv);
    lb = new SpanLabel(p.getContenupublicte());
        f.add(lb);
        
       
                 l.addPointerPressedListener((b) -> {

                //     AEvent a = new AEvent();
                form = new Form(BoxLayout.y());
                Label lbser = new Label();
                Label lbser1 = new Label();
                Label lbser2 = new Label();
                Label Title = new Label("Les details de l'évenement");

                Container F3 = new Container(BoxLayout.y());
                F3.add(Title);

                F3.add(lbser);
                F3.add(lbser1);
                F3.add(lbser2);

                System.out.println("imaage");


                ConnectionRequest con = new ConnectionRequest();
                ConnectionRequest con2 = new ConnectionRequest();

                String url = "http://localhost/madame/web/app_dev.php/pi_mobile/findEvent/" + p.getIdpublicite();
                con.setUrl(url);

                con.addResponseListener((le) -> {
//                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
                    lbser.setText("Titre   :   " + p.getNompublicite());
                    
                       
       url1="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+p.getNomimage(); 
       
         try {
            enc1=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img1=URLImage.createToStorage(enc1,url1 , url1, URLImage.RESIZE_SCALE);
        imgv1=new ImageViewer(img1);
        
 form.add(imgv1);
                    lbser1.setText("Description  :  " + p.getContenupublicte());
                   // lbser2.setText("Lieu  :   " + li.getLieu());
                    suppbtn.addActionListener((e) -> {
                        ServicePub ser = new ServicePub();
                        ser.supprimerPub(p);
           Dialog.show("Succés", "Evenement supprimé", "ok", null);
                    });
                    modifbtn.addActionListener((e) -> {
//                                             
        });
       // f.show();

                    
//                    partagerbtn.addActionListener((e) -> {
//                        ServiceEvent ser = new ServiceEvent();
////                      String filePath = (String) li.getImage();
////                       int fileNameIndex = filePath.lastIndexOf("/") + 1;
////                     String fileName = filePath.substring(fileNameIndex);
////                     try {
////                         ser.shareImageOnFacebook(filePath,li.getTitre(),li.getDescription());
////                     } catch (IOException ex) {
////                     }
//
//                    });
                    F3.add(suppbtn);
                    F3.add(modifbtn);
                    F3.add(partagerbtn);
                    F3.add(participerbtn);
                    // HomeForm ft = new HomeForm();
                    // ft.getF().show();

                });

                NetworkManager.getInstance().addToQueueAndWait(con);

                System.out.println("test el F3");
//                add(F3);
                // f.add(F3);
                form.add(F3);
                 form.show();
                //  f.add(lbser);
            });
        
        }
        
//          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
//          h.getF().show();
//          });
    }
//    private Container makeScrollable(final Component scrollable, Image thumb) {
//    scrollable.setScrollVisible(false);
//    final Slider scroll = new Slider();
//    scroll.setThumbImage(thumb);
//    Container sc = new Container(new BorderLayout());
//    sc.addComponent(BorderLayout.CENTER, scrollable);
//    sc.addComponent(BorderLayout.EAST, scroll);
//    scroll.setVertical(true);
//    scroll.setMinValue(0);
//    scroll.setEditable(true);
//    scroll.setMaxValue(scrollable.getScrollDimension().getHeight());
//    scroll.setProgress(scroll.getMaxValue());
//    final boolean[] lock = new boolean[1];
//    scroll.addDataChangedListener(new DataChangedListener() {
//        public void dataChanged(int type, int index) {
//            if(!lock[0]) {
//                lock[0] = true;
//                scrollable.scrollRectToVisible(0, scroll.getMaxValue() - index, 5, scrollable.getHeight(), scrollable);
//                lock[0] = false;
//            }
//        }
//    });
//    scrollable.addScrollListener(new ScrollListener() {
//        public void scrollChanged(int scrollX, int scrollY, int oldscrollX, int oldscrollY) {
//            if(!lock[0]) {
//                lock[0] = true;
//                scroll.setProgress(scroll.getMaxValue() - scrollY);
//                lock[0] = false;
//            }
//        }
//    });        
//    return sc;
//}

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
