

import java.util.concurrent.Callable;

public class CallableEjemplo {
    public static void main(String[] args) throws Exception {
        // Crear una tarea Callable que retorna un valor Integer
        Callable<Integer> task = () -> {
            // Simular una tarea que toma 2 segundos y retorna 42
            Thread.sleep(2000);
            return 42;
        };

        // Ejecutar la tarea y obtener el resultado
        Integer result = task.call();
        System.out.println("Resultado de la tarea: " + result);
    }
}

