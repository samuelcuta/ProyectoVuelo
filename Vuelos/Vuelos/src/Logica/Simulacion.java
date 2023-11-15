package Logica;

import IGU.Principal;

public class Simulacion {
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Principal princi = new Principal(sistema);
        princi.setVisible(true);
    }   
}


