/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import subject.Subject;

/**
 *
 * @author SAM
 */
public class SMSSender extends ObserverAbstract implements Observer {
    public SMSSender(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    
    @Override
    public void updateFolderStatus(String state) {
        System.out.println("sending SMS");
        System.out.println(state);
    }
}
