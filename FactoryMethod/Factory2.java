/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author marqu
 */
public class Factory2 {
    public static void main(String[] args){
        FabricaEditora fabrica1 = new LivroFisicoFactory();
        fabrica1.publicar();
    
        FabricaEditora fabrica2 = new LivroDigitalFactory();
        fabrica2.publicar();
    }
}

interface Produto{
    void usar();
}

abstract class FabricaEditora{
    
    public void publicar(){
        final Produto produto = this.criarProduto();
        produto.usar();
    }
    
    abstract Produto criarProduto();
}

class LivroFisico implements Produto{
    @Override
    public void usar(){
        System.out.println("Lendo papel");
    }
}

class LivroDigital implements Produto{
    @Override
    public void usar(){
        System.out.println("Lendo Kindle");
    }
}

class LivroFisicoFactory extends FabricaEditora{
    @Override
    public Produto criarProduto(){
        return new LivroFisico();
    }
}

class LivroDigitalFactory extends FabricaEditora{
    @Override
    public Produto criarProduto(){
        return new LivroDigital();
    }
}