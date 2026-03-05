/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marqu
 */
public class Observer3 {
    public static void main(){
        Grupo grupo = new Grupo();
        Usuarios us1 = new Usuarios();
        Usuarios us2 = new Usuarios();
        Usuarios us3 = new Usuarios();
    
        grupo.adicionar(us1);
        grupo.adicionar(us2);
        grupo.adicionar(us3);
        
        grupo.novaMensagem("Fala Galeraaa!!");
    }
}

class Grupo{
    private List<IObservador> observador;
    
    public Grupo(IObservador observador){
        this.observador = new ArrayList<>();
    }
    
    public void adicionar(IObservador observador){
        this.observador.add(observador);
    }
    
    public void remover(IObservador observdor){
        this.observador.remove(observador);
    }
    
    public void novaMensagem(String mensagem){
        System.out.println("Nova mensagem");
        notificar(mensagem);
    }
    
    public void notificar(String mensagem){
        for(IObservador observador: observador){
            observador.atualizar(mensagem);
        }
    }
}

interface IObservador{
    public void atualizar(String mensagem);
}

class Usuarios implements IObservador{
    @Override
    public void atualizar(String mensagem){
        System.out.println(mensagem);
    }
}