/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author marqu
 */
public class Observer1 {
    
}


public class CanalYoutube {
    public void postarVideo(String titulo) {
        CanalYoutube canal = new CanalYoutube();
        Usuario us1 = new Usuario("andre@gail");
        Usuario us1 = new Usuario("joao@gail");
        Usuario us1 = new Usuario("lary@gail");
        
        canal.inscrever(us1);
        canal.inscrever(us2);
        canal.inscrever(us3);
        
        canal.postarVideo("Padrão Observer");
    }
}

public class CanalYoutube{
    
    private List<Iobservador> observador;
    
    public CanalYoutube(){
        observador = new ArrayList<>();
    }
    
    public void inscrever(Iobservador observador){
        this.observador.add(observador);
    }
    
    public void remover(Iobservador observador){
        this.observador.remove(observador);
    }
    
    public void postarVideo(Sting titulo){
        System.out.println("Postando vídeo: "+ titulo);
        notificarInscritos(dados);
    }
    
    private void notificarInscritos(String titulo){
        for(Iobservador observador: observadores){
            observador.atualizar(titulo);
        }
    }
}

interface Iobservador{
    void atualizar(String tituloVideo);
}

public class Usuario implements Iobservador{
    public String email;
    
    public Usuario(String email){
        this.email = email;
    }
    
    @Override
    public void atualizar(String tituloVideo){
        System.out.println("Email enviado para "+ this. email + "Novo video postado: " + tituloVideo);
    }
}
