/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import java.time.LocalDate;

/**
 *
 * @author marqu
 */
public class Builder4 {
    public static void main(String[] args){
        NotaFiscal nf1 = new NotaFiscalBuild("Tech Ltda", "12.345.678/0001-99")
                            .build();

        System.out.println("Nota 1: " + nf1);

        NotaFiscal nf2 = new NotaFiscalBuild("Supermercado X", "98.765.432/0001-11")
                            .temImpostos(150.50)
                            .temObservacao("Entrega nos fundos")
                            .temData(LocalDate.of(2023, 12, 25))
                            .build();

        System.out.println("Nota 2: " + nf2);
    }
}

class NotaFiscal{
    String razao,cnpj, observacao;
    double impostos;
    LocalDate data;
    
    public NotaFiscal(String razao, String cnpj, String observacao, double impostos, LocalDate data){
        this.razao = razao;
        this.cnpj = cnpj;
        this.observacao = observacao;
        this.impostos = impostos;
        this.data = data;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" + "razao=" + razao + ", cnpj=" + cnpj + ", observacao=" + observacao + ", impostos=" + impostos + ", data=" + data + '}';
    }
    
    
}

class NotaFiscalBuild{
    String razao,cnpj;
    String observacao = "";
    double impostos = 0.0;
    LocalDate data;
    
    public NotaFiscalBuild(String razao, String cnpj){
        this.razao = razao;
        this.cnpj = cnpj;
    }
    
    public NotaFiscalBuild temImpostos(double impostos){
        this.impostos = impostos;
        return this;
    }
    
    public NotaFiscalBuild temObservacao(String observacao){
        this.observacao = observacao;
        return this;
    }
    
    public NotaFiscalBuild temData(LocalDate data){
        this.data = data;
        return this;
    }
    
    public NotaFiscal build(){
        
        LocalDate dataFinal = (this.data != null) ? this.data : LocalDate.now();
        
        return new NotaFiscal(razao, cnpj, observacao, impostos, data);
    }
}