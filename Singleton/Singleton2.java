/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 *
 * @author marqu
 */
public class Singleton2 {
    public static void main(String[] args){
      Configuracao config1 = Configuracao.getInstancia();
        config1.setTema("Escuro");

        Configuracao config2 = Configuracao.getInstancia();
        System.out.println(config2.getTema());
    }
}

 class Configuracao {
    private static Configuracao instancia = null;
    private String tema = "Claro";

    public static Configuracao getInstancia(){
        if(instancia == null){
            instancia = new Configuracao();
        }
        return instancia;
    }
    
    private Configuracao(){
    }
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}