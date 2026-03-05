/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author marqu
 */
public class State3 {
    public static void main(String[] args){
        Video video = new Video();
        
        video.pausar();
        video.executar();
    }
}

class Video{
    private Acao acao;
    
    public void pausar(){
        acao.pausar(this);
    }
    
    public void executar(){
        acao.executar(this);
    }
    
    public Video(){
        this.acao = new Pausado(); 
    }
    
    public void setEstado(Acao acao){
        this.acao = acao;
    }
}

interface Acao{
    void pausar(Video v);
    void executar(Video v);
}

class Pausado implements Acao{
    @Override
    public void pausar(Video v){
        System.out.println("Ja esta pausado");
    }
    @Override
    public void executar(Video v){
        System.out.println("Executando");
        v.setEstado(new Tocando());
    }
}

class Tocando implements Acao{
    @Override
    public void pausar(Video v){
        System.out.println("Pausando");
        v.setEstado(new Pausado());
    }
    @Override
    public void executar(Video v){
        System.out.println("Ja esta tocando");
    }
}