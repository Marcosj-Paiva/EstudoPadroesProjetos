/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author marqu
 */
public class TemplateMethod2 {
    public static void main(String[] args){
        Relatorio mensagem = new Mensagem();
        
        String texto = "Descreevo com uma criatura horenda...";
        
        mensagem.gerarRelatorio(texto);
    }
}

abstract class Relatorio{
    public final void gerarRelatorio(String mensagem){
        cabecalho();
        corpoDoTexto(mensagem);
        rodape();
    }
    
    public void cabecalho(){
        System.out.println("EMPRESA AREA52 - CONFIDENCIAL");
    }
    
    public void rodape(){
        System.out.println("Contato: area51secrets@gmail.com");
    }
    
    abstract void corpoDoTexto(String mensagem);
}

class Mensagem extends Relatorio{
    @Override
    public void corpoDoTexto(String mensagem){
        System.out.println(mensagem);
    }
}