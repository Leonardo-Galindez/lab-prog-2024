# Introducción:
Los semáforos en Java son un mecanismo de sincronización que se utiliza para controlar el acceso a un recurso compartido por múltiples hilos. Funcionan como contadores que permiten que un número limitado de hilos accedan a una sección crítica simultáneamente. Un semáforo se inicializa con un número de permisos, y cada hilo que quiera acceder al recurso debe adquirir un permiso (acquire()). Si no hay permisos disponibles, el hilo se bloquea hasta que uno se libere. Una vez que el hilo termina de usar el recurso, debe liberar el permiso (release()), permitiendo que otro hilo lo adquiera. Los semáforos son útiles para limitar la concurrencia y evitar condiciones de carrera y bloqueos mutuos.
formas 1
formas 2

# Guia de Uso:
//cambio
1. Importar la clase Semaphores
La clase Semaphore se encuentra en el paquete java.util.concurrent, por lo que primero debes importarla:

import java.util.concurrent.Semaphores;

2. Crear una instancia del semáforo
Para crear un semáforo, debes inicializarlo con un número de permisos, que representa la cantidad máxima de hilos que pueden acceder al recurso al mismo tiempo.

Semaphore sem = new Semaphore(3); // Permite hasta 3 hilos
En este ejemplo, el semáforo se inicializa con 3 permisos, lo que significa que hasta tres hilos pueden entrar en la sección crítica simultáneamente.

3. Métodos principales de la clase Semaphore
acquire(): Este método se utiliza para adquirir un permiso. Si hay permisos disponibles, el hilo lo adquiere y continúa. Si no hay permisos disponibles, el hilo se bloquea hasta que uno esté disponible.

sem.acquire(); // Adquiere un permiso
También existe la variante acquire(int permits), que permite adquirir más de un permiso a la vez.

release(): Este método se utiliza para liberar un permiso después de que el hilo ha terminado de usar el recurso. Al liberar un permiso, se incrementa el contador del semáforo, permitiendo que otro hilo pueda adquirirlo.

sem.release(); // Libera un permiso
Similarmente, existe la variante release(int permits) para liberar múltiples permisos a la vez.
