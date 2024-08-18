import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEjemplo {
    public static void main(String[] args) {
        // Crear un ExecutorService con un pool fijo de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear tres tareas Runnable

        //Espresion Lambda
        Runnable task1 = () -> {
            System.out.println("Task 1: Ejecutada por " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);  // Simulamos una tarea que toma 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            System.out.println("Task 2: Ejecutada por " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);  // Simulamos una tarea que toma 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task3 = () -> {
            System.out.println("Task 3: Ejecutada por " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);  // Simulamos una tarea que toma 3 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Enviar las tareas al executor
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        // Cerrar el ExecutorService después de que se completen las tareas
        executor.shutdown();
    }
}
