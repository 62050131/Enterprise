/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import javax.ejb.Remote;

/**
 *
 * @author USER-WIN10
 */
@Remote
public interface StatelessCounterBeanRemote {

    int increment();

    float fToC(int F);
    
}
