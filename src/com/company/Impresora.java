package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {

    private static final Semaphore impresora = new Semaphore(1, true);
    private static Ordenadores ordenador;

    public Impresora() {
    }

    public static void proces(Ordenadores ordenador) throws  InterruptedException{
        impresora.acquire();
        boolean aux = false;
        Random r = new Random();
        System.out.println(ordenador.getNombre()+" ha enviado el texto.");
        Thread.sleep(r.nextInt(5000-3000)+3000);
        aux = ordenador.docProces();
        if(aux){
            System.out.println("Texto aceptado.");
        } else System.out.println("Texto denegado.");
        impresora.release();
    }

    public static void imp(Ordenadores ordenador) throws InterruptedException {
        impresora.acquire();
        System.out.println("Comienza la impresion de "+ordenador.getNombre());
        Thread.sleep(5000);
        System.out.println("Texto impreso.");
        impresora.release();
        ordenador.interrupt();
    }

}
