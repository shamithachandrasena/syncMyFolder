/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;

/**
 *
 * @author SAM
 */
public class Subject {
    
   private List<Observer> observers = new ArrayList<Observer>();
      
   private String state;

   public  String getState() {
      return state;
   }
   
  
   public void setState(String state) {
      this.state = state;
      notifyAllObservers(this.state);
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }
   
   public void detach(Observer observer){
      observers.remove(observer);
   }
   
   public void notifyAllObservers(String state){
      for (Observer observer : observers) {
         observer.updateFolderStatus(state);
      }
   } 	

    
}
