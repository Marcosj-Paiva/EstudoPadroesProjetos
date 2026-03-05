/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author marqu
 */
public class TemplateMethod4 {
    public static void main(String[] args){
        PagamentoTemplate pagamento = new Pix();
        PagamentoTemplate pagamento2 = new QrCode();
        
        pagamento.preparar(0);
        pagamento2.preparar(1500);
    }
}

abstract class PagamentoTemplate{
    
    public final void preparar(double valor){
        if(valor > 0){
            validar();
            processar();
            notificar();
        }else{
            System.out.println("Valor Recusado");
        }
    }
    
    public void validar(){
        System.out.println("Valor Aceito");
    }
    
    abstract void processar();
    
    public void notificar(){
        System.out.println("Pago!");
    }
}

class Pix extends PagamentoTemplate{
    
    @Override
    public void processar(){
        System.out.println("Processando PIX");
    }
}

class QrCode extends PagamentoTemplate{
    
    @Override
    public void processar(){
        System.out.println("Processando QRCode");
    }
}