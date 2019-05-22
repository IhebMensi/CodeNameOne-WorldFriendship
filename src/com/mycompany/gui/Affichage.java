/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.CategorieService;
import com.mycompany.Service.ServiceTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhk
 */
public class Affichage {

    
    Form f;
    Label l;
    SpanLabel lb;
    Container x;
    Container b;
    Image img;
    int test = 0;
    ImageViewer iv;
    CategorieService service=new CategorieService();
    List <Categorie> list =service.getList2();
    private String url="http://localhost/PIDev_WorldFriendship/web/images/";

    
    public Affichage() throws IOException {
        
        f = new Form();
         f = new Form(BoxLayout.y());
         
        b = new Container(BoxLayout.y());
        

        TextField re = new TextField("", "Find Categorie");
        
        re.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    Toolbar.setGlobalToolbar(true);
                     f = new Form(" Search ",BoxLayout.y());
                    f.add(new InfiniteProgress());
                         try 
                         {service.recherche(re.getText());
                            test = 0;
                             list = new ArrayList<>(service.listTrie);
                            Affichage f;
                            try {
                                f = new Affichage();
                                f.f.revalidate();
                            } catch (IOException ex) { System.out.println(ex.getMessage());}
                            if (test == 1) {list = new ArrayList<>(service.getList2());}
                            if (test == 0) { list = new ArrayList<>(service.listTrie); }
        
                        System.out.println("valeur test " + test);
                        System.out.println("testtttt" + list);
                        
                         }catch (IOException ex) { System.out.println(ex.getMessage());}
                 }});
        b.add(re);
        l= new Label("Toutes les categorie "+list.size());
        
        f.add(l);
        f.add(b);

        for (Categorie a : list) {
                        try {
                            x = addItem(a);
                            f.add(x);
                        } catch (IOException ex) {System.out.println(ex.getMessage());}
        }

        f.show();
          //lb.setText(service.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    } 
        
                
    public Container addItem(Categorie e) throws IOException {
        Label title = new Label(e.getNomcategorie());
        Label desc = new Label(e.getDescriptioncategorie());
        Label nb = new Label("nombre d'abonnés :"+e.getNbrabonnees());
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(), 200), true);
        String path = e.getImgcategorie();

        Image image = URLImage.createToStorage(placeholder, path + "44", url + e.getImgcategorie());
        SpanLabel contenu = new SpanLabel();

        contenu.add(BorderLayout.NORTH, image.scaled(Display.getInstance().getDisplayWidth(), 200));

        Button sm = new Button("s'abonner");
        sm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(e);
               if( Dialog.show("CONFIRMATION", "Voulez vous vraiment vous abboner a  "+e.getNomcategorie(), "OUI", "ANNULER") )
               {
                   service.sabonner(e);
                   System.out.println(e);
                  Affichage f;
                    try {
                        f = new Affichage();
                         f.f.revalidate();
                    } catch (IOException ex) {
                    }
                 
               }
               
                

            }
        });
        Container cnt1 = new Container(BoxLayout.x());
        //cnt1.add(title);
        cnt1.add(desc);
        cnt1.add(nb);

        Container cnt2 = new Container(BoxLayout.y());

        cnt2.add(contenu);
        cnt2.add(title);
        cnt2.add(cnt1);
        cnt2.add(sm);

        return cnt2;
    }
    
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
