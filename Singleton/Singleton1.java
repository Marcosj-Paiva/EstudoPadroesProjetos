/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 *
 * @author marqu
 */
public class Singleton1 {
    
}


public class ConexaoBanco {
    
    private static ConexaoBanco instancia = null;
    
    private ConexaoBanco() {
    }
    
    public static ConexaoBanco getInstancia(){
        if(instancia == null){
            instancia = new ConexaoBanco();
        }
        return instancia;
    }

    public void executarQuery(String query) {
        System.out.println("Executando: " + query);
    }
}

public class Main {
    public static void main(String[] args) {

        ConexaoBanco c1 = new ConexaoBanco.getInstancia();
        ConexaoBanco c2 = new ConexaoBanco.getInstancia();
        ConexaoBanco c3 = new ConexaoBanco.getInstancia();
        
        System.out.println(c1); 
        System.out.println(c2); 
    }
}