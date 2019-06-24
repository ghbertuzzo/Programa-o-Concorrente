/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide10.Collections;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Produtor implements Runnable {
    
    ArrayBlockingQueue<String> array;

    public Produtor(ArrayBlockingQueue<String> array) {
        this.array = array;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                produz();
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void produz() throws InterruptedException {
        Random rand = new Random();
        Integer num = rand.nextInt(100);
        System.out.println("Thread "+Thread.currentThread().getName()+" Produzi: Objeto "+num);
        array.put("Objeto "+num);
    }
    
}
