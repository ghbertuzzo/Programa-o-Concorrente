/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7.pag9;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giova
 */
public class Ex2Rendezvous {
    
    Semaphore semaforo;
    ThreadTrecho thread1;
    ThreadTrecho thread2;
    
    public Ex2Rendezvous() {
        this.semaforo = new Semaphore(1);
        this.thread1 = new ThreadTrecho(this,"T1");
        this.thread2 = new ThreadTrecho(this,"T2");
    }
    
    public void trecho(String message) throws InterruptedException{
        this.semaforo.acquire();
        System.out.println(message);
        this.semaforo.release();
    }
    
    public void stort(){
        this.thread1.start();
        this.thread2.start();
    }
}
