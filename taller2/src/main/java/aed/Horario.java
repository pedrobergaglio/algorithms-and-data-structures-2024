package aed;

public class Horario {
    
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        // Implementar
        return this.minutos;
    }

    @Override
    public String toString() {
        return String.valueOf(this.hora) + ":" + String.valueOf(this.minutos);
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null) {
            return false;
        }
        if (otro.getClass() != this.getClass()) {
            return false;
        }
        // casting -> cambiar el tipo
        Horario otro_horario = (Horario) otro;

        return this.hora == otro_horario.hora && this.minutos == otro_horario.minutos;
    }

}
