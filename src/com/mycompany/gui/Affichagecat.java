/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.Pub;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Entite.participation_evenement;
import com.mycompany.Service.ServiceEvenement;
import com.mycompany.Service.ServicePub;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author bhk
 */
public class Affichagecat extends SideMenuBaseForm{
public static Evenement kaa ;
Container F3;
      Form f,form;
    SpanLabel lb;
    private Image img,img1;
    private String url,url1;
       private ImageViewer imgv,imgv1;
       private EncodedImage enc,enc1;
        public static Button suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn,annulerbtn,like,dislike;
 
    public Affichagecat(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("logofs.png");
   
        profilePic = profilePic.fill(300,300);
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
       
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        


        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label("World Friendship", "Title")
                                   
                                )
                            ).add(BorderLayout.WEST, profilePicLabel),
                        GridLayout.encloseIn(2)
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.setVisible(false);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
      //  fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
                        
        
     
        setupSideMenu(res);
        
        
          
 //    Container   f = new Form(BoxLayout.y());
      //  Label no = new Label("Liste des Evenements ");
   String ms = "no";
       
        //lb = new SpanLabel("");
       // f.add(lb);
        ServiceEvenement serviceevenement = new ServiceEvenement();
        //lb.setText(servicepub.getList2().toString());
      //  Pub p = new Pub();
         //   ArrayList<Pub> listTasks1 = new ArrayList<>();
        ArrayList<Evenement> eve = serviceevenement.getList();
        for ( Evenement  e : eve )
        { kaa =e;
            Container cc = new Container(BoxLayout.x());
        Label  l = new Label(e.getNomevenement()+"                                                 .")  ;
       // f.add(l);
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_FORWARD, "TitleCommand", 3);
     
      //  f.add(icon);
    //  cc.add(l);
   //   cc.add(icon);
      add(l);
       // FontImage img = FontImage.createMaterial(FontImage.MATERIAL_THUMB_UP, style);
        String k = e.getNomimage();
        System.out.println(k);
      Image placeholder = Image.createImage(300, 300);
       url="http://localhost/PIDev_WorldFriendship/web/images2/"+k; 
       
         try {
            enc=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img=URLImage.createToStorage(enc,url , url, URLImage.RESIZE_SCALE);
        imgv=new ImageViewer(img.scaled(900, 550));
       
 add(imgv);
    lb = new SpanLabel(e.getDescriptionevenement());
        add(lb);
        
     
            l.addPointerPressedListener((b)  -> {
             
                //     AEvent a = new AEvent();
                form = new Form(BoxLayout.y());
                Label lbser = new Label();
                Label lbser1 = new Label();
                Label lbser2 = new Label();
                Label Title = new Label("Les details de l'évenement");

                 F3 = new Container(BoxLayout.y());
                F3.add(Title);

                F3.add(lbser);
                F3.add(lbser1);
                F3.add(lbser2);

                System.out.println("imaage");

              

                ConnectionRequest con = new ConnectionRequest();
                ConnectionRequest con2 = new ConnectionRequest();

                String url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/eve/find/" + e.getIdevenement();
                con.setUrl(url);

                con.addResponseListener((le) -> {
//                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
                    lbser.setText("Titre   :   " + e.getNomevenement());
                    lbser1.setText("Description  :  " + e.getDescriptionevenement());
                    lbser2.setText("Lieu  :   "+e.getPays() );
                     url1="http://localhost/PIDev_WorldFriendship/web/images2/"+e.getNomimage(); 
       
         try {
            enc1=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img1=URLImage.createToStorage(enc1,url1 , url1, URLImage.RESIZE_SCALE);
        imgv1=new ImageViewer(img1.scaled(1450, 550));
       F3.add(imgv1);
                    System.out.println(e.getNbrplacestotal());
                     System.out.println(e.getNbrparticipants());
                    Utilisateur u1 = new Utilisateur(1);
 participerbtn.addActionListener((pi) -> {
       ConnectionRequest con5 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/participer/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con5.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con5.addResponseListener((s) -> {
            String str = new String(con5.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con5);
   
        });
 
 
  annulerbtn.addActionListener((ml) -> {
       ConnectionRequest con5 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/AnnulerEventes/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con5.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con5.addResponseListener((f) -> {
            String str = new String(con5.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con5);
   
        });
    like.addActionListener((pi) -> {
       ConnectionRequest con6 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/likeEventes/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con6.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con6.addResponseListener((a) -> {
            String str = new String(con6.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con6);
   
        });
      dislike.addActionListener((bn) -> {
       ConnectionRequest con7 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/dislikeEventes/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con7.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con7.addResponseListener((bv) -> {
            String str = new String(con7.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con7);
   
        });
 
//                  
                     F3.add(participerbtn);
                    F3.add(annulerbtn);
                    F3.add(like);
                    F3.add(dislike);
                   
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
       
        
    }

  
        
        
   
    
    private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }
  public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }  
}