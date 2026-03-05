/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author marqu
 */
public class Adapter2 {
    
}

// 1. Interface (O que a loja espera)
interface ProcessadorPagamento {
    void debitar(double valorEmReais);
}

// 2. A Classe Externa (O que o PayPal espera)
class PayPalAmericano {
    public void sendPayment(double amountInDollars) {
        System.out.println("PAYPAL: Charging $" + amountInDollars + " USD successfully.");
    }
}

// 3. O ADAPTADOR (A Casa de Câmbio)
class AdaptadorPayPal implements ProcessadorPagamento {
    private PayPalAmericano paypal;

    public AdaptadorPayPal(PayPalAmericano paypal) {
        this.paypal = paypal;
    }

    @Override
    public void debitar(double valorEmReais) {
        // AQUI ESTÁ A MÁGICA: A CONVERSÃO DE DADOS
        double valorEmDolar = valorEmReais / 5.0; 
        
        System.out.println("Adaptador: Convertendo R$ " + valorEmReais + " para US$ " + valorEmDolar);
        
        // Chamamos o método do gringo com o valor já convertido
        this.paypal.sendPayment(valorEmDolar);
    }
}

// 4. A Loja (Cliente)
class Loja {
    private ProcessadorPagamento processador;

    public Loja(ProcessadorPagamento processador) {
        this.processador = processador;
    }

    public void finalizarVenda(double valorReais) {
        processador.debitar(valorReais);
    }
}

// 5. Execução
public class Main {
    public static void main(String[] args) {
        // Criamos o PayPal (Adaptee)
        PayPalAmericano apiPayPal = new PayPalAmericano();
        
        // Criamos o Adaptador encapando o PayPal
        ProcessadorPagamento adaptador = new AdaptadorPayPal(apiPayPal);
        
        // A loja usa o adaptador como se fosse um processador nacional
        Loja minhaLoja = new Loja(adaptador);
        
        // Venda de 1000 Reais -> Vai virar 200 Dólares
        minhaLoja.finalizarVenda(1000.00);
    }
}