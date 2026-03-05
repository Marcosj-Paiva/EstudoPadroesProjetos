/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author marqu
 */

/*
Desafio: O Controle Remoto Universal
Contexto: Você está programando um Controle Remoto Inteligente. 
Ele tem um botão genérico. Hoje, você quer que esse botão ligue a Lâmpada da Sala. 
Amanhã, você quer reconfigurar esse mesmo botão para abrir o Portão da Garagem.

O Controle não pode saber como a lâmpada liga ou como o portão abre. 
Ele só sabe "apertar o botão".
*/

public class Command1 {
    public static void main(String[] args){
        Lampada lampada = new Lampada();
        Command acender = new AcenderCommand(lampada);
        Command apagar = new ApagarCommand(lampada);
        Portao portao = new Portao();
        Command abrir = new AbrirPortaoCommand(portao);
        Command fechar = new FecharPortaoCommand(portao);
        ControleRemoto controle = new ControleRemoto();
        
        controle.setComando(acender);
        controle.pressionarBotao();
        
        controle.setComando(abrir);
        controle.pressionarBotao();
        
        controle.setComando(apagar);
        controle.pressionarBotao();
        
        controle.setComando(fechar);
        controle.pressionarBotao();
    }
}

class ControleRemoto{
    Command comando;
    
    public void setComando(Command comando){
        this.comando = comando;
    }
    
    public void pressionarBotao(){
        comando.executar();
    }
}

interface Command{
    void executar();
}

class AcenderCommand implements Command{
    
    Lampada lampada;
    
    public AcenderCommand(Lampada lampada){
        this.lampada = lampada;
    }
    
    @Override
    public void executar(){
        lampada.acender();
    }
}

class ApagarCommand implements Command{
    
    Lampada lampada;
    
    public ApagarCommand(Lampada lampada){
        this.lampada = lampada;
    }
    
    @Override
    public void executar(){
        lampada.apagar();
    }
}

class Lampada{
    public void acender(){
        System.out.println("Luz acessa");
    }
    
    public void apagar(){
        System.out.println("Luz apagada");
    }
}

class AbrirPortaoCommand implements Command{
    
    Portao portao;
    
    public AbrirPortaoCommand(Portao portao){
        this.portao = portao;
    }
    
    @Override
    public void executar(){
        portao.abrir();
    }
}

class FecharPortaoCommand implements Command{
    
    Portao portao;
    
    public FecharPortaoCommand(Portao portao){
        this.portao = portao;
    }
    
    @Override
    public void executar(){
        portao.fechar();
    }
}

class Portao{
    public void abrir(){
        System.out.println("Portao aberto");
    }
    
    public void fechar(){
        System.out.println("Portao fechado");
    }
}