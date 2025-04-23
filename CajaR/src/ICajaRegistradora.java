public interface ICajaRegistradora {
    public String getNombre();
    public int getNumTipoMonedas();
    public int getUnidadesTipoMoneda(double tipo);
    public boolean meterMonedas(double tipo, int unidades);
    public boolean monedaValida(double tipo);
    public boolean sacarMonedas(float tipo, int unidades);
    public void vaciarCajaRegistradora();
    public double[] getTiposDeMonedas();
    public double getSaldo();
}
