/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author marqu
 */
public class Command4 {
    public static void main(String[] args){
        Botao comprar = new Botao();
        Carrinho carrinho = new Carrinho();
        Command adicionarBotao = new AdicionarCarrinho(carrinho);
        
        comprar.setCommand(adicionarBotao);
        comprar.precionarBotao();
    }
}

class Botao{
    Command command;
    
    public void setCommand(Command command){
        this.command = command;
    }
    
    public void precionarBotao(){
        command.executar();
    }
}

interface Command{
    void executar();
}

class AdicionarCarrinho implements Command{
    Carrinho carrinho;
    
    public AdicionarCarrinho(Carrinho carrinho){
        this.carrinho = carrinho;
    }
    
    @Override
    public void executar(){
        carrinho.adicionar();
    }
}

class Carrinho{
    public void adicionar(){
        System.out.println("Item adicionado");
    }
}