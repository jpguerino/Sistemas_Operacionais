/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor_consumidorr;

/**
 *
 * @author suelenmapa
 */
class Consumidor extends Thread {

    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {

                Principal.cheio.acquire();
                Principal.buffer.acquire();

                int item = Principal.dados[Principal.saida];
                Principal.saida = (Principal.saida + 1) % Principal.N;
                System.out.println("    Consumiu " + item);

                Principal.buffer.release();
                Principal.vazio.release();

                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
        }
    }
}
