/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author marqu
 */
public class Decorator2 {
    public static void main(String[] args){
        Texto texto = new TextoSimples("Texto para teste");
        System.out.println(texto.getTexto());
        
        texto = new Italico(texto);
        System.out.println(texto.getTexto());
        
        texto = new Negrito(texto);
        System.out.println(texto.getTexto());
        
        texto = new Colchetes(texto);
        System.out.println(texto.getTexto());
    }
}

abstract class Texto{
    String texto;

    abstract String getTexto();
}

class TextoSimples extends Texto{
    
    public TextoSimples(String texto){
        this.texto = texto;
    }
    
    @Override
    public String getTexto(){
        return texto;
    }
}

abstract class FormatacaoDecorator extends Texto{
    Texto texto;
    
    public FormatacaoDecorator(Texto texto){
        this.texto = texto;
    }
    
    public abstract String getTexto();
       
}

class Italico extends FormatacaoDecorator{
    public Italico(Texto texto){
        super(texto);
    }
    
    @Override
    public String getTexto(){
        return "<i>" + texto.getTexto() + "</i>";
    }
}

class Negrito extends FormatacaoDecorator{
    public Negrito(Texto texto){
        super(texto);
    }
    
    @Override
    public String getTexto(){
        return "<b>" + texto.getTexto() + "</b>";
    }
}

class Colchetes extends FormatacaoDecorator{
    public Colchetes(Texto texto){
        super(texto);
    }
    
    @Override
    public String getTexto(){
        return "[" + texto.getTexto() + "</]>";
    }
}