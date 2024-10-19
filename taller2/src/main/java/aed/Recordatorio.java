package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha fecha2 = new Fecha(this.fecha);
        return fecha2;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha.toString() + " " + this.horario.toString();
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
        Recordatorio otro_recordatorio = (Recordatorio) otro;
        return this.mensaje.equals(otro_recordatorio.mensaje) && this.fecha.equals(otro_recordatorio.fecha)
                && this.horario.equals(otro_recordatorio.horario);
    }

}
