/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author SAM
 */
public class FolderWatcher extends TimerTask {
    
  
    public String listFilesForFolder(final File folder) {
        File[] xn=folder.listFiles();
        
        if(xp == null){
           xp=xn; 
           //executing for the first time
           for(File f:xn){
             fileList.add(f.getName());
           }
          // new EmailOnlyClient(folder).broadcast(fileList.toString());
           new EmailAndSMSClient(folder).broadcast(fileList.toString());                    ///////////////////////////////Area to ADD your broadcster type
          // new SMSOnlyClient(folder).broadcast(fileList.toString()); 
            //  new TwitterOnlyClient(folder).broadcast(fileList.toString());
           
           
        }
        else
           if(xn.length>xp.length){
               //checking up whether new files have arrived
               fileList.clear();
               for(File f:xn){
               fileList.add(f.getName());
           }
               xp=xn;
              //new EmailOnlyClient(folder).broadcast(fileList.toString());                 ///////////////////////////////Area to ADD your broadcster type
              new EmailAndSMSClient(folder).broadcast(fileList.toString());
              //  new SMSOnlyClient(folder).broadcast(fileList.toString());
              //  new TwitterOnlyClient(folder).broadcast(fileList.toString());
              
        }
    return null;
               
    }

    private static List<String> fileList= new ArrayList<String>();
    private static File[] xp = null;;
    /**
     
     the automated folder check up is included here. just change your client type here. it works with your client type. you can define your client type and use too.
     
     */
    public void run() {
      final File folder = new File("D:\\TestFolder");  
      FolderWatcher watcher = new FolderWatcher();
      watcher.listFilesForFolder(folder);    
    }



    
    public static void main(String[] args) {
    
    Timer timer = new Timer();
    timer.schedule(new FolderWatcher(), 0, 5000);
        
    }
    
    
}
