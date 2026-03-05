/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author marqu
 */
public class Builder1 {
    public static void main(String[] args){
        CozinheiroDiretor cozinheiro = new CozinheiroDiretor();
        
        HamburguerBuilder builder1 = new HamburguerBuilder("Brioche", "Bife");
        cozinheiro.fazerXSalada(builder1);
        
        Hamburguer lanche1 = builder1.build();
        System.out.println("Pedido 1: " + lanche1);

        HamburguerBuilder builder2 = new HamburguerBuilder("7queijos", "Picanha");
        cozinheiro.fazerXTudo(builder2);
        
        System.out.println("Pedido 2: " + builder2.build());
    }
}

class CozinheiroDiretor {
    public void fazerXSalada(HamburguerBuilder builder){
        builder.comQueijo();
        builder.comSalada();
    }
    
    public void fazerXTudo(HamburguerBuilder builder){
        builder.comQueijo();
        builder.comBacon();
        builder.comSalada();
    }
}

class Hamburguer {
    String pao, carne;
    boolean temQueijo, temBacon, temSalada;
    
    Hamburguer(String pao, String carne, boolean temQueijo, boolean temBacon, boolean temSalada){
        this.pao = pao;
        this.carne = carne;
        this.temQueijo = temQueijo;
        this.temBacon = temBacon;
        this.temSalada = temSalada;
    }

    @Override
    public String toString() {
        return "Hamburguer [Pao=" + pao + ", Carne=" + carne + 
               ", Queijo=" + temQueijo + ", Bacon=" + temBacon + 
               ", Salada=" + temSalada + "]";
    }
}

class HamburguerBuilder {
    private String pao, carne;
    private boolean temQueijo, temBacon, temSalada;
    
    public HamburguerBuilder(String pao, String carne){
        this.pao = pao;
        this.carne = carne;
    }
    
    public HamburguerBuilder comQueijo(){
        this.temQueijo = true;
        return this;
    }
    
    public HamburguerBuilder comBacon(){
        this.temBacon = true;
        return this;
    }
    
    public HamburguerBuilder comSalada(){
        this.temSalada = true;
        return this;
    }
    
    public Hamburguer build(){
        return new Hamburguer(pao, carne, temQueijo, temBacon, temSalada);
    }
}