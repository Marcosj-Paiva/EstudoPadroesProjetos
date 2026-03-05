/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marqu
 */
public class Composite3 {
    public static void main(String[] args){
        Composite aparelho1 = new Aparelhos("tv", 340);
        Composite aparelho2 = new Aparelhos("video Game", 520);
        Tomadas tomada1 = new Tomadas("Regua", 0);
        Tomadas tomada2 = new Tomadas("Tomada da Sala", 0);
        
        tomada1.adicionar(aparelho1);
        tomada1.adicionar(aparelho2);
        
        tomada2.adicionar(tomada1);
        
        System.out.println("Iemt: " + tomada2.getNome() + "\nCusto: " + tomada2.getConsumo());
        
        
    }
}

abstract class Composite{
    String nome;
    double consumo;
    
    public Composite(String nome, double consumo){
        this.nome = nome;
        this.consumo = consumo;
    }
    
    abstract String getNome();
    abstract double getConsumo();
}

class Aparelhos extends Composite{
    public Aparelhos(String nome, double consumo){
        super(nome, consumo);
    }
    
    @Override String getNome(){
        return nome;
    }
    
    @Override double getConsumo(){
        return consumo;
    }
}

class Tomadas extends Composite{
    
    List<Composite> itens = new ArrayList<>();
    
    public Tomadas(String nome, double consumo){
        super(nome, consumo);
    }
    
    public void adicionar(Composite composite){
        itens.add(composite);
    }
    
    public void remover(Composite composite){
        itens.remove(composite);
    }
    
   @Override String getNome(){
       StringBuilder nomes = new StringBuilder();
       for(Composite itens: itens){
           nomes.append("\n").append(itens.getNome());
       }
       return nomes.toString();
    }
    
    @Override double getConsumo(){
        double consumoTotal = this.consumo;
        for(Composite itens: itens){
            consumoTotal += itens.getConsumo();
        }
        return consumoTotal;
    }
}