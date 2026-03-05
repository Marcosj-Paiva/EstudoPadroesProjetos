/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainsOfResponsability;

/**
 *
 * @author marqu
 */
public class Chains1 {
    
}


public class Solicitacao{
    private double valor;
    
    public Solicitacao(double valor){
        this.valor = valor;
    }
    
    public double getValor(){
        return valor;
    }
}

public abstract class Processar{
    protected Processar proxProcessar;
    
    public void setProxProcessar(Processar proxProcessar){
        this.proxProcessar = proxProcessar;
    }
    
    public abstract void tratar(Solicitacao solicitacao);
    public abstract double getValorSolicitacao();
}

public class Gerente extends Processar{
    @Override
    public void tratar(Solicitacao solicitacao){
        if(solicitacao.getValor() <= getTipoSolicitacao() ){
            System.out.println("Gerente aprovou o pedido de R$ " + solicitacao.getValor());
        }else if(proxProcessar != null){
                proxProcessar.tratar(solicitacao);
        }
    }
    @Override
    public double getTipoSolicitacao(){
        return 1000;
    }
}

public class Diretor extends Processar{
    @Override
    public void tratat(Solicitacao solicitacao){
        if(solicitacao.getValor() <= getTipoSolicitacao()){
            System.out.println("Diretor aprovou o pedido de R$ " + solicitacao.getValor());
        }else if(proxProcessar != null){
            proxProcessar.tratar(solicitacao);
        }
    }
    @Override
    public double getTipoSolicitacao(){
        return "10000";
    }
}

public class Ceo extends Processar{
    @Override
    public void tratat(Solicitacao solicitacao){
        System.out.println("CEO aprovou o pedido de R$ " + solicitacao.getValor());  
    }
}

public class Main {
    public static void main(String[] args) {
        Processar gerente = new Gerente();
        Processar diretor = new Diretor();
        Processar ceo = new Ceo();
        
        gerente.setProxProcessar(diretor);
        diretor.setProxProcessar(ceo);
        
        Solicitacao solicitao1 = new Solicitacao(500);
        Solicitacao solicitao2 = new Solicitacao(6000);
        Solicitacao solicitao3 = new Solicitacao(80000);
        
        gerente.tratar(solicitacao1);
        gerente.tratar(solicitacao2);
        gerente.tratar(solicitacao3);
        
    }
}
