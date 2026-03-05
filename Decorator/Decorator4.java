/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author marqu
 */
public class Decorator4 {
    public static void main(String[] args){
        Entrega entrega1 = new EntregaPadrao();
        
        entrega1 = new EntregaExpressa(entrega1);
        entrega1 = new SeguroDeCarga(entrega1);
        entrega1 = new EmbalagemDePresente(entrega1);
        
        System.out.println("Serviço: " + entrega1.getTipo());
        System.out.println("Total: R$ " + entrega1.getValor());
    }
}

abstract class Entrega{
    private String tipo = "Entrega ";
    private double valor = 0;
    
    abstract String getTipo();
    abstract double getValor();
}

class EntregaPadrao extends Entrega{
    
    @Override
    public String getTipo(){
        return "Entega Padrao ";
    }
    
    @Override
    public double getValor(){
        return 10;
    }
}

abstract class EntregaDecorator extends Entrega{
    Entrega entrega;
    
    public EntregaDecorator(Entrega entrega){
        this.entrega = entrega;
    }
    
    abstract String getTipo();
    abstract double getValor();
}

class EntregaExpressa extends EntregaDecorator{
    public EntregaExpressa(Entrega entrega){
        super(entrega);
    }
    
     @Override
    public String getTipo(){
        return entrega.getTipo() + "+ Entega Expressa ";
    }
    
    @Override
    public double getValor(){
        return entrega.getValor() + 20;
    }
}

class SeguroDeCarga extends EntregaDecorator{
    public SeguroDeCarga(Entrega entrega){
        super(entrega);
    }
    
     @Override
    public String getTipo(){
        return entrega.getTipo() + "+ Seguro de Carga ";
    }
    
    @Override
    public double getValor(){
        return entrega.getValor() + 5;
    }
}

class EmbalagemDePresente extends EntregaDecorator{
    public EmbalagemDePresente(Entrega entrega){
        super(entrega);
    }
    
     @Override
    public String getTipo(){
        return entrega.getTipo() + "+ Embalagem de Presente ";
    }
    
    @Override
    public double getValor(){
        return entrega.getValor() + 2;
    }
}