/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author marqu
 */
public class TemplateMethod3 {
    public static void main(String[] args){
        InstalarTemplate camera = new CameraSeguranca();
        InstalarTemplate lampada = new LampadaSmart();
        
        camera.preparar();
        lampada.preparar();
    }
}

abstract class InstalarTemplate{
    public final void preparar(){
        verificarEnergia();
        configurarHardware();
        conectarWifi();       
    }
    
    public void verificarEnergia(){
        System.out.println("Voltagem ok");
    }
    
    abstract void configurarHardware();
    
    public void conectarWifi(){
        System.out.println("Conectando ao Wifi");
    }
}

class CameraSeguranca extends InstalarTemplate{
    @Override
    public void configurarHardware(){
        System.out.println("Ajustando Camera");
    }
}

class LampadaSmart extends InstalarTemplate{
    @Override
    public void configurarHardware(){
        System.out.println("Ajustando Lampada");
    }
}