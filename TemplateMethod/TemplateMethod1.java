/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author marqu
 */
public class TemplateMethod1 {
    public static void main(String[] args){
        SanduicheTemplate xburguer = new XBurguer();
        SanduicheTemplate hotdog = new HotDog();
        
        xburguer.preparar();
        hotdog.preparar();
    }
}

abstract class SanduicheTemplate{
    
    public final void preparar(){
        cortarPao();
        adicionarCarne();
        adicionarCondimentos();
        embalar();
    }
    
    public void cortarPao(){
        System.out.println("Cortando pão...");
    }
    public void embalar(){
        System.out.println("Embaladno...");
    }
    
    abstract void adicionarCarne();
    abstract void adicionarCondimentos();
}


class HotDog extends SanduicheTemplate{
    @Override
    public void adicionarCarne(){
        System.out.println("Adicionando salsicha...");
    }
    
    @Override
    public void adicionarCondimentos(){
        System.out.println("Adicionando batata palha...");
    }
}

class XBurguer extends SanduicheTemplate{
    @Override
    public void adicionarCarne(){
        System.out.println("Adicionando bife de boi...");
    }
    @Override
        public void adicionarCondimentos(){
            System.out.println("Adicionando cebola...");
        }
}