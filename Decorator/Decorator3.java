/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author marqu
 */
public class Decorator3 {
    public static void main(String[] args){
        Notificar notificacao = new Basico();
        System.out.println(notificacao.getNotificacao());
        
        notificacao = new Medio(notificacao);
        System.out.println(notificacao.getNotificacao());
        
        
        notificacao = new Critico(notificacao);
        System.out.println(notificacao.getNotificacao());
    }
}

abstract class Notificar{
    String notificacao;
    
    abstract public String getNotificacao();
}


class Basico extends Notificar{
    @Override
    public String getNotificacao(){
        return "Logar";
    }
}

abstract class NotificarDecorator extends Notificar{
    Notificar basico;
    
    public NotificarDecorator(Notificar basico){
       this.basico = basico;
   }
    
    @Override
    abstract public String getNotificacao();
}

class Medio extends NotificarDecorator{
    
    public Medio(Notificar basico){
        super(basico);
    }

    @Override
    public String getNotificacao(){
        return basico.getNotificacao() + "Madar SMS ";
    }
}

class Critico extends NotificarDecorator{

    public Critico(Notificar basico){
        super(basico);
    }
    
    @Override
    public String getNotificacao(){
        return basico.getNotificacao() + "Tocar Sirene ";
    }
}