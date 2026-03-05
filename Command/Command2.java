/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author marqu
 */
public class Command2 {
    public static void main(String[] args){
        Garcom garcom = new Garcom();
        Chef chef = new Chef();
        Command pizza = new PedidoPizza(chef);
        Command hamburguer = new PedidoHamburguer(chef);
        
        garcom.setComando(pizza);
        garcom.anotarPedido();
        
        garcom.setComando(hamburguer);
        garcom.anotarPedido();
    }
}

interface Command{
    void executar();
}

class Garcom{
    Command comando;
    
    public void setComando(Command comando){
        this.comando = comando;
    }
    
    public void anotarPedido(){
        this.comando.executar();
    }
    
}

class Chef{
    public void prepararPizza(){
        System.out.println("Fazendo pizza");
    }
    
    public void prepararHamburguer(){
        System.out.println("Fazendo hamburguer");
    }
}

class PedidoPizza implements Command{
    Chef chef;
    
    public PedidoPizza(Chef chef){
      this.chef = chef;
    }
    
    @Override
    public void executar(){
        chef.prepararPizza();
    }
}

class PedidoHamburguer implements Command{
    Chef chef;
    
    public PedidoHamburguer(Chef chef){
      this.chef = chef;
    }
    
    @Override
    public void executar(){
        chef.prepararHamburguer();
    }
}