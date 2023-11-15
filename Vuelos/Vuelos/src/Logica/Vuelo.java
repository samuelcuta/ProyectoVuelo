package Logica;
public class Vuelo {
    private String numVuelo;
    private String origin;
    private String destini;
    private String hrPartida;
    private String hrLlegada;

    public Vuelo(String numVuelo, String origin, String destini, String hrPartida, String hrLlegada) {
        this.numVuelo = numVuelo;
        this.origin = origin;
        this.destini = destini;
        this.hrPartida = hrPartida;
        this.hrLlegada = hrLlegada;
    }
    
    @Override
    public String toString() {
        return "Vuelo: " + numVuelo + " || " + origin + " to " + destini +
                " || Hora de partida: " + hrPartida + " - Hora de llegada: " + hrLlegada;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestini() {
        return destini;
    }

    public void setDestini(String destini) {
        this.destini = destini;
    }

    public String getHrPartida() {
        return hrPartida;
    }

    public void setHrPartida(String hrPartida) {
        this.hrPartida = hrPartida;
    }

    public String getHrLlegada() {
        return hrLlegada;
    }

    public void setHrLlegada(String hrLlegada) {
        this.hrLlegada = hrLlegada;
    }
    
}
