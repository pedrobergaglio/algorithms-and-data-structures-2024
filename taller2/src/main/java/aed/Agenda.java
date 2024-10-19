package aed;

public class Agenda {

    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String res = this.fechaActual + "\n"+"=====\n";

        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            if (this.recordatorios.obtener(i).fecha().equals(this.fechaActual)) {
                res += this.recordatorios.obtener(i) + "\n";
            }
        }
        return res;
    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return this.fechaActual;
    }

}
