import ucu.edu.aed.tda.ColaCircular;

public class Main {

    public static void main(String[] args) {

        // ── 1. Crear una cola circular ─────────────────────────────────────────
        ColaCircular<String> cola = new ColaCircular<>(5);

        // ── 2. Agregar elementos a la cola ────────────────────────────────────
        System.out.println("=== Agregando elementos a la cola ===");
        cola.poneEnCola("Elemento 1");
        System.out.println("Agregado: Elemento 1");
        cola.poneEnCola("Elemento 2");
        System.out.println("Agregado: Elemento 2");
        cola.poneEnCola("Elemento 3");
        System.out.println("Agregado: Elemento 3");

        // ── 3. Ver el frente ──────────────────────────────────────────────────
        System.out.println("\nFrente de la cola: " + cola.frente());

        // ── 4. Quitar elementos de la cola ────────────────────────────────────
        System.out.println("\n=== Quitando elementos de la cola ===");
        String quitado = cola.quitaDeCola();
        System.out.println("Quitado: " + quitado);
        quitado = cola.quitaDeCola();
        System.out.println("Quitado: " + quitado);

        // ── 5. Agregar más elementos ──────────────────────────────────────────
        cola.poneEnCola("Elemento 4");
        System.out.println("Agregado: Elemento 4");
        cola.poneEnCola("Elemento 5");
        System.out.println("Agregado: Elemento 5");

        // ── 6. Mostrar el estado de la cola ───────────────────────────────────
        System.out.println("\nEstado de la cola:");
        System.out.println("Tamaño: " + cola.tamaño());
        System.out.println("Frente: " + cola.frente());
        System.out.println("Elementos:");
        for (int i = 0; i < cola.tamaño(); i++) {
            System.out.println("  " + cola.obtener(i));
        }

        // ── 7. Quitar todos los elementos ─────────────────────────────────────
        System.out.println("\n=== Vaciar la cola ===");
        while (!cola.esVacio()) {
            quitado = cola.quitaDeCola();
            System.out.println("Quitado: " + quitado);
        }
        System.out.println("Cola vacía: " + cola.esVacio());
    }
}
