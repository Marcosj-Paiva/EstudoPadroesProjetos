/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author marqu
 */
public class Factory1 {
    public static void main(String[] args){
        VeiculosFactory motoFactory = new MotoFactory(); 
        Veiculos moto = motoFactory.factoryMethod("Cg");
        moto.aceitar("Leide");
        moto.parar();
        
        VeiculosFactory bicicletaFactory = new BicicletaFactory();
        Veiculos bicicleta = bicicletaFactory.factoryMethod("Monarc");
        bicicleta.aceitar("Joao");
        bicicleta.parar();
    }
}

interface Veiculos{
    void aceitar(String nome);
    void parar();
}

class Moto implements Veiculos{
    
    String nome;
    
    public Moto(String nome){
        this.nome = nome;
    }
    
    @Override
    public void aceitar(String nome){
        System.out.println(nome + "aceitou o pedido.");
    }
    
    @Override
    public void parar(){
        System.out.println(nome + "Parou!");
    }
}

class Bicicleta implements Veiculos{
    String nome;
    
    public Bicicleta(String nome){
        this.nome = nome;
    }
    
    @Override
    public void aceitar(String nome){
        System.out.println(nome + "aceitou o pedido.");
    }
    
    @Override
    public void parar(){
        System.out.println(nome + "Parou para descansar!");
    }
}

abstract class VeiculosFactory{
    abstract Veiculos factoryMethod(String nomeVeiculo);
    
    public void aceitar(String nome, String nomeVeiculo){
        final Veiculos veiculo = this.factoryMethod(nomeVeiculo);
        veiculo.aceitar(nome);        
    }
}

class MotoFactory extends VeiculosFactory{
    @Override
    public Veiculos factoryMethod(String nomeVeiculo){
        return new Moto(nomeVeiculo);
    }
}

class BicicletaFactory extends VeiculosFactory{
    @Override
    public Veiculos factoryMethod(String nomeVeiculo){
        return new Bicicleta(nomeVeiculo);
    }
}