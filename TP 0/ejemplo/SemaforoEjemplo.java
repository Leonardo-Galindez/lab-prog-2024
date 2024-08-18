import java.util.concurrent.Semaphore;

public class SemaforoEjemplo {

    // Crear un semáforo con 2 permisos
    private static Semaphore sem = new Semaphore(2);

    public static void main(String[] args) {
        // Crear y arrancar 5 hilos
        for (int i = 1; i <= 5; i++) {
            Thread hilo = new Thread(new Tarea(), "Hilo " + i);
            hilo.start();
        }
    }

    static class Tarea implements Runnable {
        @Override
        public void run() {
            try {

                // Print hello 123

                System.out.println(Thread.currentThread().getName() + " esperando para adquirir un permiso...");
                sem.acquire(); // Adquirir un permiso
                System.out.println(Thread.currentThread().getName() + " ha adquirido un permiso.");

                // Simular trabajo dentro de la sección crítica
                Thread.sleep(2000);

                System.out.println(Thread.currentThread().getName() + " libera un permiso.");
                sem.release(); // Liberar el permiso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
