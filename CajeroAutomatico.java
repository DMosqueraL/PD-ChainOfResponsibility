package Patrones_Diseño.ChainOfResponsibility;

public class CajeroAutomatico {
    private Integer saldoDisponible;
    private HandlerBilletes manejadorInicio;

    public CajeroAutomatico(Integer saldoInicial) {
        this.saldoDisponible = saldoInicial;
    }

    public int consultarSaldoDisponible() {
        return saldoDisponible;
    }
    public void establecerManejadorInicio(HandlerBilletes manejadorInicio) {
        this.manejadorInicio = manejadorInicio;
    }
    public void retirarDinero(Integer cantidad) {
        if (cantidad > 0) {
            manejadorInicio.manejarSolicitud(cantidad);
        } else {
            System.out.println("Cantidad invalida.");
        }
    }
}
