/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainsOfResponsability;

/**
 *
 * @author marqu
 */
public class Chains2 {
    public static void main(String[] args){
        Procedimentos robo = new Robo();
        Procedimentos suporte1 = new Suporte1();
        Procedimentos suporte2 = new Suporte2();
        
        robo.setProxProcedimento(suporte1);
        suporte1.setProxProcedimento(suporte2);
        
        Solicitacao sol1 = new Solicitacao("SENHA");
        Solicitacao sol2 = new Solicitacao("LENTIDAO");
        Solicitacao sol3 = new Solicitacao("ERRO_CRITICO");
        Solicitacao sol4 = new Solicitacao("ERRO2");
        
        robo.tratar(sol1);
        robo.tratar(sol2);
        robo.tratar(sol3);
        robo.tratar(sol4);
    }
}

class Solicitacao{
    private String tipo;
    
    public Solicitacao(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}


abstract class Procedimentos{
    protected Procedimentos proxProcedimento;
    
    public void setProxProcedimento(Procedimentos proximo){
        this.proxProcedimento = proximo;
    }
    
    public abstract void tratar(Solicitacao solicitacao);
    public abstract String tipo();
    
}

class Robo extends Procedimentos{
    @Override
    public void tratar(Solicitacao solicitacao){
        if(solicitacao.getTipo().equals(tipo())){
            System.out.println("Robô: Enviei um link para resetar sua senha.");
        }else if(proxProcedimento != null){
            proxProcedimento.tratar(solicitacao);
        }
    }
    
    @Override 
    public String tipo(){
        return "SENHA";
    }
}

class Suporte1 extends Procedimentos{
    @Override
    public void tratar(Solicitacao solicitacao){
        if(solicitacao.getTipo().equals(tipo())){
            System.out.println("Júnior: Por favor, reinicie seu computador.");
        }else if(proxProcedimento != null){
            proxProcedimento.tratar(solicitacao);
        }
    }
    
    @Override 
    public String tipo(){
        return "LENTIDAO";
    }
}

class Suporte2 extends Procedimentos{
    @Override
    public void tratar(Solicitacao solicitacao){
        if(solicitacao.getTipo().equals(tipo())){
            System.out.println("Júnior: Por favor, reinicie seu computador.");
        }else if(proxProcedimento != null){
            proxProcedimento.tratar(solicitacao);
        }else{
            System.out.println("Ninguém sabe resolver isso.");
        }
    }
    
    @Override 
    public String tipo(){
        return "ERRO_CRITICO";
    }
}