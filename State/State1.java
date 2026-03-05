/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author marqu
 */
public class State1 {
    public static void main(String[] args){
        Semaforo semaforo = new Semaforo();
        
        System.err.println("Iniciando" + semaforo.getName());
        
        semaforo.trocar();
        System.err.println(semaforo.getName());
        semaforo.trocar();
        System.err.println(semaforo.getName());
        semaforo.trocar();
        System.err.println(semaforo.getName());
        semaforo.trocar();
    }
}

interface States{
    String getName();
    void proximo(Semaforo semaforo);
}

class Verde implements States{
    
    @Override
    public String getName(){
        return "VERDE";
    }
    
    @Override
    public void proximo(Semaforo semaforo){
        semaforo.setState(new Amarelo());
    }
}

class Amarelo implements States{
    
    @Override
    public String getName(){
        return "AMARELO";
    }
    
    @Override
    public void proximo(Semaforo semaforo){
        semaforo.setState(new Vermelho());
    }
}

class Vermelho implements States{
    
    @Override
    public String getName(){
        return "VERMELHO";
    }
    
    @Override
    public void proximo(Semaforo semaforo){
        semaforo.setState(new Verde());
    }
}

class Semaforo{
    
    private States estado = new Verde();
    
    public void setState(States estado){
        this.estado = estado;
    }
    
    public String getName(){
        return this.estado.getName();
    }

    public void trocar(){
        estado.proximo(this);
    }
}