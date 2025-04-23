public class CajaRegistradora implements ICajaRegistradora {
    private String nombre;

    // Tipos de monedas aceptadas
    private final double[] tiposValidos = {0.01, 0.05, 0.10, 0.25, 0.50, 1.00, 2.00};

    // Cantidades de cada tipo de moneda (en la misma posición que tiposValidos)
    private int[] cantidades;

    public CajaRegistradora(String nombre) {
        this.nombre = nombre;
        cantidades = new int[tiposValidos.length];
        // Todo empieza en 0
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumTipoMonedas() {
        return tiposValidos.length;
    }

    public int getUnidadesTipoMoneda(double tipo) {
        int indice = buscarIndiceTipo(tipo);
        if (indice != -1) {
            return cantidades[indice];
        }
        return -1;
    }

    public boolean meterMonedas(double tipo, int unidades) {
        int indice = buscarIndiceTipo(tipo);
        if (indice != -1 && unidades > 0) {
            cantidades[indice] = cantidades[indice] + unidades;
            return true;
        }
        return false;
    }

    public boolean monedaValida(double tipo) {
        return buscarIndiceTipo(tipo) != -1;
    }

    public boolean sacarMonedas(float tipo, int unidades) {
        int indice = buscarIndiceTipo(tipo);
        if (indice != -1 && unidades > 0 && cantidades[indice] >= unidades) {
            cantidades[indice] = cantidades[indice] - unidades;
            return true;
        }
        return false;
    }

    public void vaciarCajaRegistradora() {
        for (int i = 0; i < cantidades.length; i++) {
            cantidades[i] = 0;
        }
    }

    public double[] getTiposDeMonedas() {
        return tiposValidos;
    }

    public double getSaldo() {
        double total = 0;
        for (int i = 0; i < tiposValidos.length; i++) {
            total = total + (tiposValidos[i] * cantidades[i]);
        }
        return total;
    }

    private int buscarIndiceTipo(double tipo) {
        for (int i = 0; i < tiposValidos.length; i++) {
            if (tiposValidos[i] == tipo) {
                return i;
            }
        }
        return -1;
    }
}

