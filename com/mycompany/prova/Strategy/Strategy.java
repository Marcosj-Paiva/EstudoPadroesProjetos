/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prova.Strategy;

/**
 *
 * @author marqu
 */

//  STRATEGY

public class Strategy {
    public static void main(String[] args) {
        Iarmas arma = new Espada();
        Personagem geralt = new Personagem(arma);
        geralt.golpear();
        Iarmas armaSecundaria = new Arco();
        geralt.setArma(arma);
        geralt.golpear();
    }
}

public class Personagem {
    private Iarmas arma;

    public Personagem(Iarmas arma) {
        this.arma = arma;
    }

    public void golpear(){
        arma.atacar();
    }
    
    public void setArma(Iarmas novaArma) {
        this.arma = novaArma;
    }
}

interface Iarmas{
    public void atacar();
}

public class Espada implements Iarmas{
    @Override
    public void atacar(){
        System.out.println("Realizou um corte rápido com a espada!");
    }
}
public class Arco implements Iarmas{
    @Override
    public void atacar(){
        System.out.println("Disparou uma flecha à distância!");
    }
}
public class Punhos implements Iarmas{
    @Override
    public void atacar(){
        System.out.println("Deu um soco poderoso!");
    }
}