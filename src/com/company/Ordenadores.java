package com.company;

import java.util.Random;

public class Ordenadores extends Thread{

    public Ordenadores() {

    }

    private String nombre = "";
    Random r = new Random();
    boolean proces = false;

    public void run(){

        try{

            while(!docProces()) {
                Impresora.proces(this);
            }

            if(docProces()){
                Impresora.imp(this);
            }

        }catch (InterruptedException var9) {
            var9.printStackTrace();
        }
    }

    public void setNombre(String x){
        this.nombre = x;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean docProces(){
        return r.nextInt(2)==1;
    }

}
