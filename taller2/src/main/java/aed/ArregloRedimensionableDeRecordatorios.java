package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] arreglo;

    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[0];
    }

    public int longitud() {
        return this.arreglo.length;
    }

    public void agregarAtras(Recordatorio i) {
        
        Recordatorio[] nuevo_arreglo = new Recordatorio[this.arreglo.length + 1];

        for (int j = 0; j < this.arreglo.length; j++) {
            nuevo_arreglo[j] = this.arreglo[j];
        }

        nuevo_arreglo[nuevo_arreglo.length-1] = i;

        this.arreglo = nuevo_arreglo;
    }

    public Recordatorio obtener(int i) {
        return this.arreglo[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevo_arreglo = new Recordatorio[this.arreglo.length - 1];

        for (int j = 0; j < this.arreglo.length-1; j++) {
            nuevo_arreglo[j] = this.arreglo[j];
        }

        this.arreglo = nuevo_arreglo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        ArregloRedimensionableDeRecordatorios nuevo_arreglo = new ArregloRedimensionableDeRecordatorios();
        nuevo_arreglo.arreglo = vector.arreglo.clone();
        this.arreglo = nuevo_arreglo.arreglo;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        
        ArregloRedimensionableDeRecordatorios nuevo_arreglo = new ArregloRedimensionableDeRecordatorios();
        nuevo_arreglo.arreglo = this.arreglo.clone();
        
        return nuevo_arreglo;
    }
}
