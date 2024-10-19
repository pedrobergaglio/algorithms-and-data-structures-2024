package aed;

public class Fecha {

    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
        return;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    public String toString() {
        return String.valueOf(this.dia) + "/" + String.valueOf(this.mes);
    }

    @Override
    public boolean equals(Object otra) {
        
        if (otra == null) {
            return false;
        }
        if (otra.getClass() != this.getClass()) {
            return false;
        }
        // casting -> cambiar el tipo
        Fecha otra_fecha = (Fecha) otra;

        return this.dia == otra_fecha.dia && this.mes == otra_fecha.mes;
    }

    public void incrementarDia() {
        
        if (this.dia == diasEnMes(this.mes)) {
            this.dia = 1;
            if (this.mes == 12) {
                this.mes = 1;
            } else {
                this.mes++;
            }
        } else {
            this.dia++;
        }
        
        return;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
