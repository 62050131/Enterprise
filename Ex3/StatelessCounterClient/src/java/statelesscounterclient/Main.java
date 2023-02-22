/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelesscounterclient;

import java.util.Scanner;

/**
 *
 * @author USER-WIN10
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter degree in Fahrenheit: ");
        int F=sc.nextInt();
        MyThread myThread1 = new MyThread(F);
//        MyThread myThread2 = new MyThread(2);
//        MyThread myThread3 = new MyThread(3);
//        MyThread myThread4 = new MyThread(4);
        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
        try {
            myThread1.join();
//            myThread2.join();
//            myThread3.join();
//            myThread4.join();
        }
        catch(Exception e) {
            
        }
    }
    
}
