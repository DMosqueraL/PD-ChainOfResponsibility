package Patrones_Diseño.ChainOfResponsibility;

public interface HandlerBilletes {
    void manejarSolicitud(int cantidad);
    void establecerSiguiente(HandlerBilletes siguiente);
}
