/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package ChainsOfResponsability;

/**
 *
 * @author marqu
 */
public class Chains3{
    Dispersor dispersor100 = new Dispersor100();
    Dispersor dispersor50 = new Dispersor50();
    Dispersor dispersor10 = new Dispersor10();
    
    dispersor100.setProxDispersor(dispersor50);
    dispersor50.setProxDispersor(dispersor10);
    
    Notas notas1 = new Notas(500);
    Notas notas2 = new Notas(40);
    Notas notas3 = new Notas(580);
    
    dispersor100.tratar(notas1);
    dispersor100.tratar(notas2);
    dispersor100.tratar(notas3);
    
    
    
}

class Notas{
   private double valor;
   
   public Notas(double valor){
       this.valor = valor;
   }
   
   public double getValor(){
       return valor;
   }
}

abstract class Dispersor{
    protected Dispersor proxDispersor;
    
    public void setProxDispersor(Dispersor proxDispersor){
        this.proxDispersor = proxDispersor;
    }
    
    public abstract void tratar(Notas notas);
    public abstract double getValor(); 
}

class Dispersor100 extends Dispersor{
    @Override
    public void tratar(Notas notas){
        if(notas.getValor() >= getValor()){
            double qtd = notas.getValor() / getValor();
            System.out.println("Entregando " + (int)qtd + "notas de 100");
            if(proxDispersor != null){
                proxDispersor.tratar(notas);
            }
        }else if(proxDispersor != null){
            proxDispersor.tratar(notas);
        }
    }
    
    @Override
    public double getValor(){
        return 100;
    }
}

class Dispersor50 extends Dispersor{
    @Override
    public void tratar(Notas notas){
        if(notas.getValor() >= getValor()){
            double qtd = notas.getValor() / getValor();
            System.out.println("Entregando " + (int)qtd + "notas de 50");
            if(proxDispersor != null){
                proxDispersor.tratar(notas);
            }
        }else if(proxDispersor != null){
            proxDispersor.tratar(notas);
        }
    }
    
    @Override
    public double getValor(){
        return 50;
    }
}

class Dispersor10 extends Dispersor{
    @Override
    public void tratar(Notas notas){
        if(notas.getValor() >= getValor()){
            double qtd = notas.getValor() / getValor();
            System.out.println("Entregando " + (int)qtd + "notas de 10");
            if(proxDispersor != null){
                proxDispersor.tratar(notas);
            }
        }else if(proxDispersor != null){
            proxDispersor.tratar(notas);
        }
    }
    
    @Override
    public double getValor(){
        return 10;
    }
}