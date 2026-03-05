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
public class Composite4 {
    public static void main(String[] args){
        Produto produto1 = new Produto("Xiaomi note 9", 1200);
        Produto produto2 = new Produto("Fone de Ouvido", 1200);
        Produto produto3 = new Produto("Iphone 17", 8000);
        Categorias categoria1 = new Categorias("Eletronicos",0);
        Categorias categoria2 = new Categorias("Celulares",0);
        
        categoria2.adicionar(produto1);
        categoria2.adicionar(produto3);
        
        categoria1.adicionar(categoria2);
        categoria1.adicionar(produto2);
        
        System.out.println("Produtos: " + categoria1.getNome() + "\nValor: " + categoria1.getValor());
    }
}

abstract class Composite{
    protected String nome;
    protected double valor;
    
    public Composite(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
    
    abstract String getNome();
    abstract double getValor();
}

class Produto extends Composite{
    public Produto(String nome, double valor){
        super(nome, valor);
    }
    
    @Override
    public String getNome(){
        return nome;
    }
    
    @Override
    public double getValor(){
        return valor;
    }
}

class Categorias extends Composite{
    public List<Composite> itens = new ArrayList<>();
    
    public Categorias(String nome, double valor){
        super(nome, valor);
    }
    
    public void adicionar(Composite composite){
        itens.add(composite);
    }
    
    public void remover(Composite composite){
        itens.remove(composite);
    }
    
    @Override 
    public String getNome(){
        StringBuilder nomes = new StringBuilder();
        for(Composite itens: itens){
            nomes.append("\n").append(itens.getNome());
        }
        return nomes.toString();
    }
    
    @Override
    public double getValor(){
        double valorTotal = this.valor;
        for(Composite itens: itens){
            valorTotal += itens.getValor();
        }
        return valorTotal;
    }
}