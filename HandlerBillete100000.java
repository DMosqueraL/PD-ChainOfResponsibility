package Patrones_Diseño.ChainOfResponsibility;

public class HandlerBillete100000 implements HandlerBilletes{
    private HandlerBilletes siguiente;
    private Integer denominacion = 100000;
    @Override
    public void manejarSolicitud(int cantidad) {
        Integer billetes = cantidad / denominacion;
        Integer sobrante = cantidad % denominacion;

        if (billetes > 0) {
            System.out.println("Despachando " + billetes + " billete(s) de $" + denominacion);
        }

        if (sobrante > 0 && siguiente != null) {
            siguiente.manejarSolicitud(sobrante);
        }
    }
    @Override
    public void establecerSiguiente(HandlerBilletes siguiente) {
        this.siguiente = siguiente;
    }
}
