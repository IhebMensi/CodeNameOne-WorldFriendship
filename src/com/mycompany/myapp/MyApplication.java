package com.mycompany.myapp;

import com.mycompany.gui.HomeForm;
import static com.codename1.ui.CN.*;

import com.codename1.ui.Form;
import com.codename1.ui.Dialog;

import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Display;
import com.codename1.ui.Toolbar;
import com.mycompany.gui.Ajoutereve;
import com.mycompany.gui.Eval;
import com.mycompany.gui.Login;
import com.mycompany.gui.RecForm;


/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class MyApplication {
    
      private Form current;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        Toolbar.setCenteredDefault(false);
        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
     //   Ajoutereve e = new Ajoutereve();
//        testaff e = new testaff(res);
//        e.getF().show();
      new Login(theme).show();
//   RecForm g = new RecForm();
//   g.getF().show();
//       Eval h =new Eval();
//     h.getF().show();
 //Stat t = new Stat(res);
//t.createPieChartForm(theme).show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }

//    private Form current;
//    private Resources theme;
//
//    public void init(Object context) {
//        theme = UIManager.initFirstTheme("/theme");
//
//        // Enable Toolbar on all Forms by default
//        Toolbar.setGlobalToolbar(true);
//
//        // Pro only feature
//        Log.bindCrashProtection(true);
//    }
//
//    public void start() {
//        if (current != null) {
//            current.show();
//            return;
//        }
//        Login h = new Login(theme);
//        h.getF().show();
//
//    }
//
//    public void stop() {
//        current = getCurrentForm();
//        if (current instanceof Dialog) {
//            ((Dialog) current).dispose();
//            current = getCurrentForm();
//        }
//    }
//
//    public void destroy() {
//    }

}
