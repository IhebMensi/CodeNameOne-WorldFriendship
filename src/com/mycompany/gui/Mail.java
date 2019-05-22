/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.messaging.*;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;


/**
 *
 * @author asus
 */
public class Mail extends Object{
   Message m ;

public Mail(String n){
 m = new Message("");
String x="";
//m.getAttachments().put(textAttachmentUri,"text/plain");
//m.getAttachments().put(imageAttachmentUri, "image/png");
m.sendMessage(new String[]
        {"worldfriendship.esprit@gmail.com"},
        "concernant l'achat du produit intitulé : "+n
        ,m);

        
        }
//
//public Mail(){
//m = new Message("SALUT");
//m.setMimeType(Message.MIME_HTML);
//
//// notice that we provide a plain text alternative as well in the send method
//boolean success = m.sendMessageViaCloudSync("Codename One", "worldfriendship.esprit@gmail.com",
//        "Name Of User", "Message Subject",
//                            "https://www.codenameone.com/");
//}

}
