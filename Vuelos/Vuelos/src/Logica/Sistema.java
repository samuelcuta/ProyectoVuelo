package Logica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sistema {
    private static Sistema instance;
    private static LinkedList<Vuelo> lista = new LinkedList<>();
    private static Queue<Vuelo> espera;
    private static Stack<Vuelo> hist;
    
    public Sistema(){
        espera = new LinkedList<>();
        lista = new LinkedList<>();
        hist = new Stack<>();
        Vuelo vuelo1 = new Vuelo("123456", "Colombia", "Estados Unidos", "12:00", "14:00");
        Vuelo vuelo2 = new Vuelo("654321", "Estados Unidos", "España", "15:00", "19:00");
        Vuelo vuelo3 = new Vuelo("147852", "España", "Colombia", "10:00", "18:00");
        lista.add(vuelo1);
        lista.add(vuelo2);
        lista.add(vuelo3);
    }
    
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    
    public static void addVuelo(Vuelo vuelo){
        if(lista.size() >= 3){
            espera.offer(vuelo);
            System.out.println("Se ha añadido el vuelo a la cola de espera");
        }
        else{
            lista.add(vuelo);
            System.out.println("Se ha añadido el vuelo a la lista");
        }
    }
    
    
    public void removeFlight(Vuelo vuelo) {
        if(lista.contains(vuelo)) {
            lista.remove(vuelo);
        }
        else if(espera.contains(vuelo)) {
            espera.remove(vuelo);
        }
    }
    
    public Vuelo buscarVuelo(String numFl){
        Vuelo vueloEncontrado = null;

        for (Vuelo vuelo : lista) {
            if (vuelo.getNumVuelo().equalsIgnoreCase(numFl)) {
                vueloEncontrado = vuelo;
                break;
            }  
        }
        return vueloEncontrado;
    }
    
    public void removerEspera(){
        Vuelo antiguo = espera.poll();
        if(antiguo != null){
            espera.add(antiguo);
        }
    }
    
    public void autorizarVuelo(Vuelo vuelo){
        if(lista.contains(vuelo)){
            lista.remove(vuelo);
            hist.push(vuelo);
            while (!espera.isEmpty() && lista.size() < 3) {
                Vuelo vueloEnEspera = espera.poll();
                lista.add(vueloEnEspera);
            }
            removerEspera();
        }
    }
    
    public LinkedList<Vuelo> getListaVuelos(){
        return lista;
    }
    
    public Queue<Vuelo> getColaEspera(){
        return espera;
    }
    
    public Stack<Vuelo> getHistorial(){
        return hist;
    }
    
}
