package modelos;
import java.util.ArrayList;
import java.util.List;

import servicios.Notificador;

public class Pedido {

    private String id;
    private String cliente;
    private EstadoPedido estado;
    private List<Notificador> observadores;

    public Pedido(String id, String cliente) {
        this.id = id;
        this.cliente = cliente;
        this.estado = EstadoPedido.PENDIENTE;
        this.observadores = new ArrayList<>(); //Lista de observadores para este pedido
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public void registrarObservador(Notificador observador) {
        observadores.add(observador);
    }

    private void notificarObservadores() {
        for (Notificador observador : observadores) {
            observador.actualizar(this);
        }
    }

    public String getId(){
        return this.id;
    }

    public String getCliente(){
        return this.cliente;
    }

    public EstadoPedido getEstado(){
        return this.estado;
    }



}
