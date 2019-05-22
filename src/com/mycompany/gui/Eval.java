/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import static com.codename1.charts.util.ColorUtil.CYAN;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Feedback;
import com.mycompany.Service.ServiceFeedback;

/**
 *
 * @author ihebm
 */
public class Eval extends SideMenuBaseForm{
    Form f;
Label l;
TextField t;
Button ajouteval,btnback;
   int x;
    public Eval(Resources res) {
   
        
  
    f = new Form("Evaluation de notre application");
          Slider s = createStarRankSlider();
      f.add(s);
      Label l =new Label();
      f.add(l);
        t = new TextField("", "Comment", 20, TextField.ANY);
        t.getAllStyles().setFgColor(CYAN);
      f.add(t);
      ajouteval= new Button("Ajouter evaluation");
      f.add(ajouteval);
             String com = t.getText();
      s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                x= s.getProgress() ;
                System.out.println(x);
             //   authuser.user.setNote(x);
                l.setText("La note attribuer est :"+String.valueOf(x));
               
            }
      });
                 ajouteval.addActionListener((e) -> {
               Feedback f1 = new Feedback(0, x, t.getText());
                ServiceFeedback ser= new ServiceFeedback();
                ser.ajoutFeedback(f1);
        });
                 
                  f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProfileForm h=new ProfileForm(res);
          h.show();
          });
    }
      
      
         private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }
         private  Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(5);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(8, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte)0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5 , fullStar.getHeight()));
        return starRank;
    }
         
       private void showStarPickingForm() {
        Form hi = new Form("Star Slider", new BoxLayout(BoxLayout.Y_AXIS));
        hi.add(FlowLayout.encloseCenter(createStarRankSlider()));
         

        hi.show();
    }

    public Form getF() {
        return f;
    }

    @Override
    protected void showOtherForm(Resources res) {
         }

 
    
}
