/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 *
 * @author marqu
 */
public class Singleton3 {
    
}

class Logger {
    
    private static Logger instancia = null;
    
    public static Logger getInstancia(){
        if(instancia == null){
            instancia = new Logger();
        }
        return instancia;
    }
    
    private Logger() {
    }

    public void log(String mensagem) {
        System.out.println("[LOG]: " + mensagem);
    }
}

class ModuloFinanceiro {
    public void registrarVenda() {
        Logger logger = Logger.getInstancia(); 
        logger.log("Venda de R$ 50,00");
    }
}

class ModuloUsuario {
    public void registrarLogin() {
        Logger logger = Logger.getInstancia();
        logger.log("Usuário entrou");
    }
}