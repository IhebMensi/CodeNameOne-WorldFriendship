/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class EspaceFAv extends SideMenuBaseForm  {
      private EncodedImage enc;
   private  ConnectionRequest connectionRequest;
     Form  listOfBooks = new Form();
          Form  f = new Form();

        private Image img,img1;
    private ImageViewer imgv;
private Label l1,l2,l3,l4;
private SpanLabel Nomprod,descprod,prixprod,catprod;
private TextField Nomprod1,descprod1,prixprod1,catprod1;
    private String url;
  ArrayList<String> libsNoms = new ArrayList<>();
private Container mainContainer,ImageContainer,favContainer;
    ServiceProduit s =new  ServiceProduit();
    public EspaceFAv(Resources res ) throws IOException
    {  super(BoxLayout.y());  
    ArrayList<Produit> Ar=s.getList2();
        for(Produit p :Ar)    
    {
        aaditem(p);
    }
        Toolbar tb=  f.getToolbar();
     tb.addCommandToLeftBar("back", null,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
            Tousprod t=new Tousprod(res);
              }
          });

        f.show();
    
                    com.codename1.ui.List uiLibsList = new com.codename1.ui.List();
    com.codename1.ui.list.DefaultListModel<String>  listModel= new com.codename1.ui.list.DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Produit currentfav = Ar.get(uiLibsList.getCurrentSelected());
                        new FavoritInterface(currentfav.getIdproduit(),currentfav.getNomproduit(),
                                currentfav.getPrix(),currentfav.getDescriptionproduit(),
                                currentfav.getCategorie(),currentfav.getNomimage()
                        ).show();
                    }
                });
    }
    
    
    public void aaditem(Produit l) throws IOException
    {
        try{
    enc =EncodedImage.create("/load.png");
    }  catch (IOException ex) {
            //Logger.gtLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
                      Container cc2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Container cc=new Container(new BoxLayout(BoxLayout.X_AXIS));
        String url="http://localhost/PIDev_WorldFriendship/web/imagesEvents/"+l.getNomimage();
             System.out.println(url);
         img=URLImage.createToStorage(enc,/*Nom image lorsque bch isobha f telifoun*/ url, url, URLImage.RESIZE_SCALE); 
             imgv=new ImageViewer(img);
             imgv.setWidth(500);
             imgv.setHeight(1000);
             Label l1=new Label(l.getNomproduit());
             cc.add(l.getNomproduit());
             Button det=new Button("details");
             
             cc.add(det);
             cc2.add(imgv);
                      
             
                 

          //   cc.add(cc2);
          f.add(img);
             f.add(cc);
             
                    libsNoms.add(l1.getText());

                    det.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
      new FavoritInterface(l.getIdproduit(),l.getNomproduit(),
                                l.getPrix(),l.getDescriptionproduit(),
                                l.getCategorie(),l.getNomimage()
                        ).show();
                         
            }
                                  
                });
    }
          @Override
    protected void showOtherForm(Resources res) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    }  }
