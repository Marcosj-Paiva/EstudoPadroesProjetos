/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author marqu
 */
public class Factory4 {
    public static void main(String[] args){
        Forja espada = new EspadaFactory();
        espada.forjar();
        
        Personagem guerreiro = new Personagem(espada);
        guerreiro.ataqueNormal();
    }
}

interface Armas{
    void tipoDeArma();
}

class Espada implements Armas{
    @Override
    public void tipoDeArma(){
        System.out.println("Espada");
    }
}

class Lanca implements Armas{
    @Override
    public void tipoDeArma(){
        System.out.println("Lanca");
    }
}

abstract class Forja{
    public void forjar(){
        final Armas arma = this.criarArma();
        arma.tipoDeArma();
    }
    
    abstract Armas criarArma();
}

class EspadaFactory extends Forja{
    @Override
    public Armas criarArma(){
        return new Espada();
    }
}

class LancaFactory extends Forja{
    @Override
    public Armas criarArma(){
        return new Lanca();
    }
}

class Personagem{
    Forja arma;
    State estado;
    
    public Personagem(Forja arma){
        this.arma = arma;
        this.estado = new Normal();
    }
    
    public void setEstado(State estado){
        this.estado = estado;
    }
    
    public void ataqueNormal(){
        estado.ataqueNormal(this);
    }
    
    public void ataqueFerido(){
        estado.ataqueFerido(this);
    }
}

interface State{
    void ataqueNormal(Personagem p);
    void ataqueFerido(Personagem p);
}

class Normal implements State{
    @Override
    public void ataqueNormal(Personagem p){
        System.out.println("Ataque de 100% de força");
    }
    @Override
    public void ataqueFerido(Personagem p){
        p.setEstado(new Ferido());
    }
}


class Ferido implements State{
    @Override
    public void ataqueNormal(Personagem p){
        p.setEstado(new Normal());
    }
    @Override
    public void ataqueFerido(Personagem p){
        System.out.println("Ataque de 50% de força");
    }
}
