import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class ExecutorServiceCallable {
    public static void main(String[] args) {
        // Crear un ExecutorService con un pool fijo de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear una tarea Callable que retorna un valor
        Callable<Integer> task1 = () -> {
            System.out.println("Task 1: Ejecutada por " + Thread.currentThread().getName());
            Thread.sleep(2000); // Simulamos una tarea que toma 2 segundos
            return 10; // Retornamos un valor de tipo Integer
        };

        Callable<Integer> task2 = () -> {
            System.out.println("Task 2: Ejecutada por " + Thread.currentThread().getName());
            Thread.sleep(1000); // Simulamos una tarea que toma 1 segundo
            return 20; // Retornamos un valor de tipo Integer
        };

        Callable<Integer> task3 = () -> {
            System.out.println("Task 3: Ejecutada por " + Thread.currentThread().getName());
            Thread.sleep(3000); // Simulamos una tarea que toma 3 segundos
            return 30; // Retornamos un valor de tipo Integer
        };

        try {
            // Enviar las tareas al executor y obtener futuros
            Future<Integer> future1 = executor.submit(task1);
            Future<Integer> future2 = executor.submit(task2);
            Future<Integer> future3 = executor.submit(task3);

            // Obtener los resultados de los futuros cuando las tareas completen
            Integer result1 = future1.get();
            Integer result2 = future2.get();
            Integer result3 = future3.get();

            // Imprimir los resultados
            System.out.println("Resultado de Task 1: " + result1);
            System.out.println("Resultado de Task 2: " + result2);
            System.out.println("Resultado de Task 3: " + result3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el ExecutorService
            executor.shutdown();
        }
    }
}
/*
 * import java.util.concurrent.Callable;
 * import java.util.concurrent.ExecutorService;
 * import java.util.concurrent.Executors;
 * import java.util.concurrent.Future;
 * 
 * public class CallableExample implements Callable<Integer> {
 * 
 * @Override
 * public Integer call() throws Exception {
 * // Simulando un trabajo que toma tiempo
 * Thread.sleep(2000);
 * return 42; // Retorna algún valor
 * }
 * 
 * public static void main(String[] args) {
 * // Crear un ExecutorService
 * ExecutorService executor = Executors.newSingleThreadExecutor();
 * 
 * // Crear una instancia de Callable
 * Callable<Integer> callableTask = new CallableExample();
 * 
 * // Enviar la tarea al executor y obtener un Future
 * Future<Integer> future = executor.submit(callableTask);
 * 
 * try {
 * // Obtener el resultado de la tarea
 * Integer result = future.get();
 * System.out.println("Resultado de la tarea: " + result);
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * 
 * // Cerrar el executor
 * executor.shutdown();
 * }
 * }
 * 
 * 
 */