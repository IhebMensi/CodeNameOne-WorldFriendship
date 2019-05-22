/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.codename1.util.Base64;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author asus
 */
public class SMS {
    String accountSID = "AC4477e016a7504235b97769a4a0e862d2";
String authToken = "70e6e9849569abff59ff622b83c5472d";
String fromPhone = "+21690374161";
String to = "+21656420205";

  //  Random r = new Random(); 
    String val = "" ;
    public SMS()
  {
    while(val.length()<4)
    { val = "0ppppppppppppppppp" + val;
    }
Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/"+
        accountSID + "/Messages.json").
        queryParam("To", to).
        queryParam("From", fromPhone).
        queryParam("Body", val).
        header("Authorization", "Basic " +
        Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
        getAsJsonMap();

if(result.getResponseData() != null) 
{ String error = (String)result.getResponseData().get("error_message");
if(error != null) { ToastBar.showErrorMessage(error);
} } 
else 
{ 
    ToastBar.showErrorMessage("Error sending SMS: "+result.getResponseCode()); }

    }
    
}
//NexmoClient client = new NexmoClient.Builder()
//  .apiKey("0d4cd74f")
//  .apiSecret("x4OmWQF87q02mdyu")
//  .build();
//
//String messageText = "Hello from Nexmo";
//TextMessage message = new TextMessage("Nexmo", "21656420205", messageText);
//
////SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
//
//for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
//    System.out.println(responseMessage);
//}
//}

