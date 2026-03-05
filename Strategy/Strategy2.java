/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prova.Strategy;

/**
 *
 * @author marqu
 */
public class Strategy2 {
    public static void main(String[] args){
        
        Compra minhaCompra = new Compra(1000);
        
        minhaCompra.finalizar();
        
        minhaCompra.setEstrategiaPagamento(new Pix());
        minhaCompra.finalizar();
        
        minhaCompra.setEstrategiaPagamento(new Boleto());
        minhaCompra.finalizar();
    }
}

interface ImetodoPagameto{
    public void calcular(double valorTotal);
}

class Pix implements ImetodoPagameto{
    @Override
    public void calcular(double valorTotal){
        System.out.println("Pagamento via PIX com 10% de desconto: R$ " + (valorTotal * 0.9));
    }
}

class Cartao implements ImetodoPagameto{
    @Override
    public void calcular(double valorTotal){
        System.out.println("Pagamento via PIX com 10% de desconto: R$ " + valorTotal);
    }
}

class Boleto implements ImetodoPagameto{
    @Override
    public void calcular(double valorTotal){
        System.out.println("Pagamento via PIX com 10% de desconto: R$ " + valorTotal);
    }
}

class Compra{
    private double valorTotal;
    private ImetodoPagameto estrategiaPagamento;
    
    public Compra(double valorTotal){
        this.valorTotal = valorTotal;
        this.estrategiaPagamento = new Cartao();
    }
    
    public void setEstrategiaPagamento(ImetodoPagameto metodo){
        this.estrategiaPagamento = metodo;
    }
    
    public void finalizar(){
        this.estrategiaPagamento.calcular(this.valorTotal);
    }
}