package modelos;
import modelos.Pedido;
import servicios.TiendaOnline;
import servicios.Notificador;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        TiendaOnline tienda = new TiendaOnline();

        Pedido pedido = new Pedido("1", "Juan Perez");

        pedido.registrarObservador(new Notificador() {
            @Override
            public void actualizar(Pedido pedido) {
                System.out.println("Pedido " + pedido.getId() + " está " + pedido.getEstado());
            }
        });

        Future<Pedido> future = tienda.procesarPedido(pedido);

        try {
            future.get(); // Espera a que el pedido sea procesado
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            tienda.shutdown();
        }
    }
}

