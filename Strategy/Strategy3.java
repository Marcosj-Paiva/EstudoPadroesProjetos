/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prova.Strategy;

/**
 *
 * @author marqu
 */
public class Strategy3 {
    public static void main(String[] args){
        ConstruirRotas construct = new ConstruirRotas(new Carro());
        construct.construir("Alegre", "Maratizes");
        
        construct.setMetodo(new Bike());
        construct.construir("Molevade", "Inglaterra");
        
        construct.setMetodo(new Pe());
        construct.construir("Rio de Janeiro", "São Paulo");
        
    }
}

class ConstruirRotas{
    private IRotas rotas;
    
    public ConstruirRotas(IRotas rotas){
        this.rotas = rotas;
    }
    
    public void setMetodo(IRotas rotas){
        this.rotas = rotas;
    }
    
    public void construir(String A, String B){
        this.rotas.rotas(A, B);
    }
}

interface IRotas{
    void rotas(String A, String B);
}

class Carro implements IRotas{
    @Override
    public void rotas(String A, String B){
        System.out.println("Rota de Carro: Pegando a rodovia para ir de " + A + " até " + B);
    }
}
class Bike implements IRotas{
    @Override
    public void rotas(String A, String B){
        System.out.println("Rota de Bike: Indo pelas ciclovias de " + A + " até " + B);
    }
}
class Pe implements IRotas{
    @Override
    public void rotas(String A, String B){
        System.out.println("Rota a Pé: Cortando caminho pelo parque de " + A + " até " + B);
    }
}