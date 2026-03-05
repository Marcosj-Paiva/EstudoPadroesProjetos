/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author marqu
 */
public class Decorator1 {
    public static void main(String[] args){
        Bebida espresso = new Espresso();
        System.out.println(espresso.getDescricao() + "R$:" + espresso.getCusto());
        
        espresso = new Leite(espresso);
        System.out.println(espresso.getDescricao() + "R$:" + espresso.getCusto());
        
        espresso = new Chocolate(espresso);
        
        System.out.println(espresso.getDescricao());
        System.out.println(espresso.getCusto());
        
    }
}

abstract class Bebida{
    String descricao = "Bebida desconhecida";
    
    public String getDescricao(){
        return descricao;
    }
    
    abstract double getCusto();
}

class Espresso extends Bebida{
    
    public Espresso(){
        descricao = "Espresso";
    }

    @Override
    public double getCusto(){
        return 5.0;
    }
}

abstract class IgredienteDecorator extends Bebida{
    protected Bebida bebida;
   
    public IgredienteDecorator(Bebida bebida){
       this.bebida = bebida;
    }
    
    public abstract String getDescricao();
}

class Leite extends IgredienteDecorator{

    public Leite(Bebida bebida){
        super(bebida);
    }
    
    @Override
    public String getDescricao(){
        return bebida.getDescricao() + ", Leite";
    }
    
    @Override
    public double getCusto(){
        return bebida.getCusto() + 2.0;
    }
}

class Chocolate extends IgredienteDecorator{
    
    public Chocolate(Bebida bebida){
        super(bebida);
    }
    
    @Override
    public String getDescricao(){
        return bebida.getDescricao() + ", Chocolate";
    }
    
    @Override
    public double getCusto(){
        return bebida.getCusto() + 3.0;
    }
}