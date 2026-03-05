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
public class Composite2 {
    public static void main(String[] args){
        Item item1 = new Item("Hot Dog", 5);
        Item item2 = new Item("Coca-Cola", 3);
        Item item3 = new Item("Batata Frita", 8);
        Item item4 = new Item("Hamburguer", 10);
        
        Combo combo1 = new Combo("Mata Fome", 7);
        Combo combo2 = new Combo("Americano", 16);
        Combo combo3 = new Combo("Americano Completo", 18);
        
        combo1.adicionar(item1);
        combo1.adicionar(item2);
        System.out.println(combo1.getNome() + " : " + combo1.getPreco());
        
        combo2.adicionar(item2);
        combo2.adicionar(item3);
        combo2.adicionar(item4);
        System.out.println(combo2.getNome() + " : " + combo2.getPreco());
        
        combo3.adicionar(combo1);
        combo3.adicionar(combo2);
        System.out.println(combo3.getNome() + " : " + combo3.getPreco());
        
    }
}

abstract class Componente{
    String nome;
    double preco;
    
    public Componente(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
    
    abstract String getNome();
    abstract double getPreco();
}

class Item extends Componente{    
    public Item(String nome, double preco){
        super(nome, preco);
    }
    
    @Override
    public String getNome(){
        return nome;
    }
    
    @Override
    public double getPreco(){
        return preco;
    }
}

class Combo extends Componente{
    List<Componente> itens = new ArrayList<>();
    
    public Combo(String nome, double preco){
        super(nome, preco);
    }
    
    public void adicionar(Componente componente){
        this.itens.add(componente);
    }
    
    public void remover(Componente componente){
        this.itens.remove(componente);
    }
    
    @Override
    public String getNome(){
        StringBuilder nomes = new StringBuilder();
        for(Componente item : this.itens){
            nomes.append("\n").append(item.getNome());
        }
        return nomes.toString();
    }
    
    @Override
    public double getPreco(){
        double precoTotal = this.preco;
        for(Componente item: this.itens){
            precoTotal += item.getPreco();
        }
        return precoTotal;
    }
}