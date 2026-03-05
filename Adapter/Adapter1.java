/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author marqu
 */
public class Adapter1 {
    
}



// TARGET: O que a parede da casa espera (Interface padrão)
interface TomadaAntiga {
    void ligarNoFioDoisPinos();
}

// ADAPTEE: O objeto novo que queremos usar, mas não encaixa
class GeladeiraModerna {
    public void ligarNoFioTresPinos() {
        System.out.println("Ligado com segurança e aterramento (3 pinos)!");
    }
}

// CLIENTE: O sistema elétrico da casa
class Casa {
    public void fornecerEnergia(TomadaAntiga tomada) {
        tomada.ligarNoFioDoisPinos();
    }
}

class AdaptadorTomada implements TomadaAntiga{
    private GeladeiraModerna geladeira;
    
    public AdaptadorTomada(GeladeiraModerna geladeira){
        this.geladeira = geladeira;
    }
    
    @Override
    public void ligarNoFioDoisFinos(){
        geladeira.ligarNoFioTresPinos();
    }
    
}

public class Main {
    public static void main(String[] args) {
    
        Casa casa = new Casa();
        GeladeiraModerna minhaGeladeira = new GeladeiraModerna();
        TomadaAntiga adaptador = new AdaptadorTomada(minhaGeladeira);
        
        casa.fornecerEnercia(adaptador);
    }
}