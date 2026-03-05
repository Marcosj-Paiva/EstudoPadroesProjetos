/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author marqu
 */
public class Builder3 {
    public static void main(String[] args){
        Diretor diretor = new Diretor();
        CenasBuild cena = new CenasBuild();
        
        diretor.criarModoBomDia(cena);
        Cenas cena1 = cena.build();
        
        System.out.println(cena1.toString());
        
        Cenas cena2 = new CenasBuild()
                        .ligarLuz()
                        .ligarAr()
                        .fecharCortina()
                        .build();

        System.out.println("\n--- Cena 2 (Manual) ---");
        System.out.println(cena2);
    }
}

class Cenas{
    String cortina, tv, ar, luz;
    
    public Cenas(String cortina, String tv, String ar, String luz){
        this.cortina = cortina;
        this.tv = tv;
        this.ar = ar;
        this.luz = luz;
    }
    
    @Override
    public String toString() {
       return "Cena Configurada:\n" +
               "  Cortina: " + (cortina != null ? cortina : "---") + "\n" +
               "  TV:      " + (tv != null ? tv : "---") + "\n" +
               "  Ar:      " + (ar != null ? ar : "---") + "\n" +
               "  Luz:     " + (luz != null ? luz : "---");
    }
}

class Diretor{
    public void criarModoCinema(CenasBuild build){
        build.fecharCortina();
        build.ligarTv();
        build.ligarAr();
    }
    
    public void criarModoBomDia(CenasBuild build){
        build.abrirCortina();
        build.desligarTv();
    }
}

class CenasBuild{
    String cortina, tv, ar, luz;
    
    public CenasBuild abrirCortina(){
        this.cortina = "Abre cortina";
        return this;
    }
    
    public CenasBuild fecharCortina(){
        this.cortina = "Fechar cortina";
        return this;
    }
    
    public CenasBuild ligarTv(){
        this.tv = "Ligar Tv";
        return this;
    }
    
    public CenasBuild desligarTv(){
        this.tv = "Desigar Tv";
        return this;
    }
    
    public CenasBuild ligarAr(){
        this.ar = "Ar em 20";
        return this;
    }
    
    public CenasBuild ligarLuz(){
        this.luz = "ligar Luz";
        return this;
    }
    
    public Cenas build(){
        return new Cenas(cortina, tv, ar, luz);
    }
}