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
public class Observer2 {
    public static void main(String[] args){
        GerenciarTempo geren = new GerenciarTempo();
        IObservador cel = new CelularObs();
        IObservador painel = new PainelObs();
        IObservador termo = new TermostatoObs();

        geren.adicionar(cel);
        geren.adicionar(painel);
        geren.adicionar(termo);
    }
}

class Estacao{
    double temp;
    
    public Estacao(double temp){
        this.temp = temp;
    }   
}

class GerenciarTempo{
    private List<IObservador> observador;
    
    public GerenciarTempo(){
        observador = new ArrayList<>();
    }
    
    public void adicionar(IObservador observador){
        this.observador.add(observador);
    }
    
    public void remover(IObservador observador){
        this.observador.remove(observador);
    }
    
    public void MudarTempo(double temp){
        System.out.println("Tempo mudou.");
        notificar(temp);
    }
    
    public void notificar(double temp){
        for(IObservador observador: observador){
            observador.atualizar(temp);
        }
    }
}

interface IObservador{
    public void atualizar(double temp);
}

class CelularObs implements IObservador{
    @Override
    public void atualizar(double temp){
        System.out.println("Nova temperatura: " + temp);
    }
}

class PainelObs implements IObservador{
    @Override
    public void atualizar(double temp){
        System.out.println("Nova temperatura: " + temp);
    }
}

class TermostatoObs implements IObservador{
    @Override
    public void atualizar(double temp){
        System.out.println("Nova temperatura: " + temp);
    }
}