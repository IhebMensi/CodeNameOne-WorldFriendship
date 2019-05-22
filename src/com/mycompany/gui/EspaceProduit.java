/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class EspaceProduit extends Form {
     

    private final Container mainContainer;
    

    private String url;
    
    public EspaceProduit(int idproduit,String nomproduit,String categorie,String descriptionproduit,float prix,String nomimage)
    { ServiceProduit a =new ServiceProduit();
        getToolbar().addCommandToLeftBar("back", null, e -> a.getList());
       
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
      
      
           

        this.add(BorderLayout.EAST, mainContainer);
    }
}





