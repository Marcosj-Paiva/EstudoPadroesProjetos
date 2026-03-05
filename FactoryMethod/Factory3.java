/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author marqu
 */
public class Factory3 {
    public static void main(String[] args){
        TransporteFactory transporte1 = new MotoFactory();
        transporte1.criar();

        TransporteFactory transporte2 = new CaminhaoFactory();
        transporte2.criar();
    }
}

interface Transporte{
    void entregar();
}

class Moto implements Transporte{
    @Override 
    public void entregar(){
        System.out.println("Entrega de moto");
    }
}

class Caminhao implements Transporte{
    @Override 
    public void entregar(){
        System.out.println("Entrega de caminhao");
    }
}

abstract class TransporteFactory{
    public void criar(){
        final Transporte transporte = this.criarTransporte();
        transporte.entregar();
    }
    
    abstract Transporte criarTransporte();
}

class MotoFactory extends TransporteFactory{
    @Override
    public Transporte criarTransporte(){
        return new Moto();
    }
}

class CaminhaoFactory extends TransporteFactory{
    @Override
    public Transporte criarTransporte(){
        return new Caminhao();
    }
}