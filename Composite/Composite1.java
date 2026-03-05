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
public class Composite1 {
    public static void main(String[] args){
        Arquivo arquivo1 = new Arquivo(123, "Lary.txt");
        Arquivo arquivo2 = new Arquivo(46, "Gary.txt");
        Arquivo arquivo3 = new Arquivo(9873, "Bary.txt");
        Arquivo arquivo4 = new Arquivo(412, "Tary.txt");
        
        Pasta pastaPequena1 = new Pasta(500, "Lary.txt");
        Pasta pastaPequena2 = new Pasta(460, "Gary.txt");
        Pasta pastaMedia = new Pasta(132569, "Bary.txt");
        Pasta pastaGrande = new Pasta(9874, "Tary.txt");
        
        pastaPequena1.adicionar(arquivo1);
        pastaPequena2.adicionar(arquivo2);
        
        pastaMedia.adicionar(pastaPequena1);
        pastaMedia.adicionar(pastaPequena2);
        
        pastaGrande.adicionar(pastaMedia);
        pastaGrande.adicionar(arquivo3);
        pastaGrande.adicionar(arquivo4);
        
        System.out.println(pastaGrande.getNome());
        System.out.println(pastaGrande.getTamanho());
    }
}

abstract class Componente{
    protected double tamanho;
    protected String nome;
    
    public Componente(double tamanho, String nome){
        this.tamanho = tamanho;
        this.nome = nome;
    }
    
    public abstract double getTamanho();
    
    public abstract String getNome();
}

class Arquivo extends Componente{
    public Arquivo(double tamanho, String nome){
        super(tamanho, nome);
    }
    
    @Override
    public double getTamanho(){
        return this.tamanho;
    }
    
    @Override
    public String getNome(){
        return this.nome;
    }
}

class Pasta extends Componente{
    public Pasta(double tamanho, String nome){
        super(tamanho, nome);
    }
    
    List<Componente> itens = new ArrayList<>();
    
    public void adicionar(Componente componente){
        this.itens.add(componente);
    }
    
    public void remover(Componente componente){
        this.itens.remove(componente);
    }
    
    @Override
    public double getTamanho(){
        double tamanhoTotal = this.tamanho;
        for(Componente itens : this.itens){
            tamanhoTotal += itens.getTamanho();
        }
        return tamanhoTotal;
    }
    
    @Override
    public String getNome(){
        StringBuilder nomes = new StringBuilder(this.nome);
        for(Componente itens: this.itens){
            nomes.append("\n").append(itens.getNome());
        }
        return nomes.toString();
    }
}