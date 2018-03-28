/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import observer.EmailSender;
import observer.SMSSender;
import subject.Subject;

/**
 *
 * @author SAM
 */
public class EmailAndSMSClient implements Client{
    File folder;
    
    EmailAndSMSClient(File folder){
      this.folder=folder;  
    }
    
    @Override
    public void broadcast(String state) {
       
    //the connection profile of observers
      Subject subject = new Subject();

    //attaching and detaching observers
        new EmailSender(subject);
        new SMSSender(subject);
      //subject.detach();
      
    //broadcast
     // FolderWatcher watcher=new FolderWatcher();
      subject.setState("New files detected!. All the files are listed: \n"+state);
    }
    
}
