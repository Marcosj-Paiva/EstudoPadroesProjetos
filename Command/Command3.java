/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author marqu
 */
public class Command3 {
    public static void main(String[] args){
        Aplicativo app = new Aplicativo();
        ArCondicionado ar = new ArCondicionado();
        Som som = new Som();
        Command ligandoAr = new LigarAr(ar);
        Command tocarMusica = new TocarMusica(som);
        
        app.setComando(ligandoAr);
        app.apertarBotao();
        
        app.setComando(tocarMusica);
        app.apertarBotao();
    }
}

class Aplicativo{
    Command comando;
    
    public void setComando(Command comando){
        this.comando = comando;
    }
    
    public void apertarBotao(){
        comando.executar();
    }
}

interface Command{
    void executar();
}

class LigarAr implements Command{
    ArCondicionado ar;
    
    public LigarAr(ArCondicionado ar){
        this.ar = ar;
    }
    
    @Override
    public void executar(){
        ar.ligar();
    }
}

class ArCondicionado{
    public void ligar(){
        System.out.println("Ar ligado");
    }
}

class TocarMusica implements Command{
    Som som;
    
    public TocarMusica(Som som){
        this.som = som;
    }
    
    @Override
    public void executar(){
        som.tocar();
    }
}

class Som{
    public void tocar(){
        System.out.println("Tocando musica");
    }
}