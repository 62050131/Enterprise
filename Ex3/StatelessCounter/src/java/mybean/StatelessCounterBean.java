/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import javax.ejb.Stateless;

/**
 *
 * @author USER-WIN10
 */
@Stateless
public class StatelessCounterBean implements StatelessCounterBeanRemote {
    
    private int count = 0;
    private float C=0;
    
    @Override
    public int increment() {
        return ++count;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public float fToC(int F) {
        C=(float) ((5/9) * (F - 32));
        return C;
    }

   
}
