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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
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
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Evenement;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Entite.commentevenement;
import com.mycompany.Service.ServiceEvenement;
import com.mycompany.Service.Servicecom;
import java.io.IOException;
import java.util.ArrayList;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author Marwa
 */
public class testaff extends SideMenuBaseForm {
      Form f,form;
    SpanLabel lb;
    private Image img,img1,img3;
    private String url,url1,url3;
       private ImageViewer imgv,imgv1,imgv3;
       private EncodedImage enc,enc1,enc3;
       private TextField chnompub;
        public static Button suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn,annulerbtn,like,dislike;
 
    public testaff(Resources res) {
        
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
                chnompub = new TextField();
        chnompub.setHint("titre");
        btnchercher = new Button("chercher");
       add(btnchercher);
        add(chnompub);
        ServiceEvenement SP = new ServiceEvenement();
        btnchercher.addActionListener((e) -> {
            Form F2 = new Form(BoxLayout.y());
            String d = chnompub.getText();
            ArrayList<Evenement> liche = SP.rechercheEvenement(d);
            System.out.println("nnn"+liche);
            for (Evenement lis : liche) {
                  
                  url3="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+lis.getNomimage(); 
       
         try {
            enc3=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img3=URLImage.createToStorage(enc3,url3 , url3, URLImage.RESIZE_SCALE);
        imgv3=new ImageViewer(img3);
        
 F2.add(imgv3);
                Label aa1 = new Label("Nom Evenement  : " + lis.getNomevenement());
                Label nbpl = new Label("Description Evenement  :" + lis.getDescriptionevenement());
              
                F2.add(aa1);
                //F2.add(datee);
                //F2.add(prixx);
                F2.add(nbpl);
               // F2.add(desc);
              
                F2.show();
                  F2.getToolbar().addCommandToRightBar("back", null, (ev)->{testaff h=new testaff(res);
          h.show();
          });}
        });

        
          
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
        { 
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
       url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+k; 
       
         try {
            enc=EncodedImage.create("/load.png");
        } catch (IOException ex) {
          
        }
   img=URLImage.createToStorage(enc,url , url, URLImage.RESIZE_SCALE);
        imgv=new ImageViewer(img.scaled(1450, 550));
       
 add(imgv);
    lb = new SpanLabel(e.getDescriptionevenement());
        add(lb);
        
        l.addPointerPressedListener(b  -> {

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

                String url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/api/eve/find/" + e.getIdevenement();
                con.setUrl(url);

                con.addResponseListener((le) -> {
//                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
                    lbser.setText("Titre   :   " + e.getNomevenement());
                    lbser1.setText("Description  :  " + e.getDescriptionevenement());
                    lbser2.setText("Lieu  :   "+e.getPays() );
                     url1="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+e.getNomimage(); 
       
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
                    Container nv1 = new Container(BoxLayout.x());
                                        Container nv2 = new Container(BoxLayout.x());

                     Button participerbtn = new Button("participer");
        participerbtn.setUIID("SkipButton");
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
  Button annulerbtn = new Button("Annuler");
        annulerbtn.setUIID("SkipButton");
 
  annulerbtn.addActionListener((pi) -> {
       ConnectionRequest con5 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/AnnulerEventes/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con5.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con5.addResponseListener((s) -> {
            String str = new String(con5.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con5);
   
        });
  nv1.add(participerbtn);
  nv1.add(annulerbtn);
  Button like = new Button("Like");
        like.setUIID("SkipButton");
    like.addActionListener((pi) -> {
       ConnectionRequest con6 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/likeEventes/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con6.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con6.addResponseListener((s) -> {
            String str = new String(con6.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con6);
   
        });
    Button dislike = new Button("dislike");
        dislike.setUIID("SkipButton");
      dislike.addActionListener((pi) -> {
       ConnectionRequest con5 = new ConnectionRequest();// création d'une nouvelle demande de connexion
        System.out.println(e.getNomevenement());
        String Url = "http://localhost/PIDev_WorldFriendship/web/app_dev.php/eve/ze/dislikeEventes/" + e.getIdevenement()+"/"+u1.getId();
        // + "/" + p.getContenupublicte();// création de l'URL
        con5.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con5.addResponseListener((s) -> {
            String str = new String(con5.getResponseData());//Récupération de la réponse du serveur
            System.out.println("rrr  "+str);//Affichage de la réponse serveur sur la console
Dialog.show(str, str , "OK", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(con5);
   
        });
 
//                  
//                     F3.add(participerbtn);
//                    F3.add(annulerbtn);

Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_ADD, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
    nv2.add( passwordIcon);      
nv2.add(like);
      nv2.add(
              
              loginIcon);
                    nv2.add(dislike);
F3.add(nv1);
F3.add(nv2);                    
                    
                    
                    Servicecom serviceevenement1 = new Servicecom();
       Label  ll2 = new Label("Liste des Commentaires")  ;
       Label  ll3 = new Label("")  ;
        F3.add(ll2);
                    F3.add(ll3);
        ArrayList<commentevenement> com = serviceevenement1.getList(e.getIdevenement());
        for ( commentevenement  c : com)
        { 
            Container ccc = new Container(BoxLayout.x());
        Label  ll = new Label(c.getComment()+"")  ;
      //  Label  ll4 = new Label(c.getUser_id()+"")  ;
       // f.add(l);
        
  F3.add(ll);
//  F3.add(ll4);
        }
                   
                    // HomeForm ft = new HomeForm();
                    // ft.getF().show();
TextField comm = new TextField();
        
                     Button loginButton = new Button("Ajouter Com");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(ajc -> {
            try {
            Servicecom ser = new Servicecom();
          
            commentevenement ee = new commentevenement(1, e.getIdevenement(),comm.getText(),0);
            ser.ajoutcom(ee);
        }   catch (Exception ex) {
           }
        });
                   F3.add(comm);
                    F3.add(loginButton);
                });

                NetworkManager.getInstance().addToQueueAndWait(con);

                System.out.println("test el F3");
//                add(F3);
                // f.add(F3);
                form.add(F3);
                   form.getToolbar().addCommandToRightBar("back", null, (ev)->{testaff h=new testaff(res);
          h.show();
          });
                 form.show();
                //  f.add(lbser);
        
        });
        }
        
         getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });}

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();   }

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
 

   

   }
