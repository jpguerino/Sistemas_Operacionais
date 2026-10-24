/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor_consumidorr;

/**
 *
 * @author suelenmapa
 */
class Produtor extends Thread {

    public void run() {
        try {
            for (int item = 1; item <= 20; item++) {
                Thread.sleep(100);

                Principal.vazio.acquire();
                Principal.buffer.acquire();

                Principal.dados[Principal.entrada] = item;
                Principal.entrada = (Principal.entrada + 1) % Principal.N;
                System.out.println("Produziu " + item);

                Principal.buffer.release();
                Principal.cheio.release();

            }
        } catch (InterruptedException e) {
        }
    }
}
