/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author marqu
 */
public class State2 {
    public static void main(String[] args){
        Pedido pedido = new Pedido();

        System.out.println("--- Tentativa 1: Enviar sem pagar ---");
        pedido.enviar();

        System.out.println("\n--- Tentativa 2: Pagar ---");
        pedido.pagar();
        
        System.out.println("\n--- Tentativa 3: Pagar novamente ---");
        pedido.pagar();

        System.out.println("\n--- Tentativa 4: Enviar ---");
        pedido.enviar();
        
        System.out.println("\n--- Tentativa 5: Cancelar ---");
        pedido.cancelar();
    }
}

interface State{
    void pagar(Pedido p);
    void cancelar(Pedido p);
    void enviar(Pedido p);
}

class Pedido{
    private State estado;
    
    public Pedido(){
        this.estado = new AguardandoPagamento();
    }
    
    public void pagar(){
        estado.pagar(this);
    }
    
    public void cancelar(){
        estado.cancelar(this);
    }
    
    public void enviar(){
        estado.enviar(this);
    }
    
    public void setEstado(State novoEstado){
        this.estado = novoEstado;
    }
}

class AguardandoPagamento implements State{
    @Override
    public void pagar(Pedido p){
        System.out.println("Pagamento processado com sucesso!");
        p.setEstado(new Pago());
    }
    @Override
    public void cancelar(Pedido p) {
        System.out.println("Pedido cancelado pelo usuário.");
        p.setEstado(new Cancelado()); 
    }

    @Override
    public void enviar(Pedido p) {
        System.out.println("ERRO: Não é possível enviar um pedido que não foi pago.");
    }
}

class Pago implements State {
    @Override
    public void pagar(Pedido p) {
        System.out.println("ERRO: O pedido já foi pago anteriormente.");
    }

    @Override
    public void cancelar(Pedido p) {
        System.out.println("Cancelando... Reembolso solicitado. Pedido cancelado.");
        p.setEstado(new Cancelado());
    }

    @Override
    public void enviar(Pedido p) {
        System.out.println("Enviando produtos para a transportadora...");
        p.setEstado(new Enviado());
    }
}

class Cancelado implements State {
    @Override
    public void pagar(Pedido p) {
        System.out.println("ERRO: Pedido encerrado/cancelado. Não pode receber pagamentos.");
    }

    @Override
    public void cancelar(Pedido p) {
        System.out.println("ERRO: O pedido já está cancelado.");
    }

    @Override
    public void enviar(Pedido p) {
        System.out.println("ERRO: Não enviamos pedidos cancelados.");
    }
}

class Enviado implements State {
    @Override
    public void pagar(Pedido p) {
        System.out.println("ERRO: Já pago e enviado.");
    }

    @Override
    public void cancelar(Pedido p) {
        System.out.println("ERRO: Já enviado. Não é possível cancelar agora.");
    }

    @Override
    public void enviar(Pedido p) {
        System.out.println("ERRO: O pedido já foi enviado.");
    }
}