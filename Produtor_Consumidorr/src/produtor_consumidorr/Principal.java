/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package produtor_consumidorr;

import java.util.concurrent.Semaphore;

/**
 *
 * @author suelenmapa
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    static int N = 5;                     // tamanho do buffer
    static int[] dados = new int[N];      // o buffer
    static int entrada = 0;               // onde o produtor coloca
    static int saida = 0;                 // de onde o consumidor tira
    static Semaphore vazio = new Semaphore(5);
    static Semaphore cheio = new Semaphore(0);
    static Semaphore buffer = new Semaphore(1);
    
    public static void main(String[] args) {
       Produtor p = new Produtor();
       Consumidor c = new Consumidor();
       
       p.start();
       c.start();
    }
    
}
