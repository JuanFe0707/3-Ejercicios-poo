import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CajaRegistradora caja = new CajaRegistradora("Caja Principal");

        int opcion = 0;

        while (opcion != 5) {
            // Mostramos el menú
            System.out.println("");
            System.out.println("---- MENÚ ----");
            System.out.println("1. Ingresar monedas");
            System.out.println("2. Ver contenido");
            System.out.println("3. Ver saldo");
            System.out.println("4. Sacar monedas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 1) {
                // Ingresar monedas
                System.out.print("Tipo de moneda (ej: 0.25): ");
                double tipo = scanner.nextDouble();
                System.out.print("Cantidad de monedas: ");
                int cantidad = scanner.nextInt();

                boolean resultado = caja.meterMonedas(tipo, cantidad);
                if (resultado) {
                    System.out.println("Monedas agregadas.");
                } else {
                    System.out.println("Error: tipo o cantidad inválida.");
                }

            } else if (opcion == 2) {
                // Mostrar todas las monedas
                System.out.println("Contenido de la caja:");
                double[] tipos = caja.getTiposDeMonedas();
                for (int i = 0; i < tipos.length; i++) {
                    int unidades = caja.getUnidadesTipoMoneda(tipos[i]);
                    System.out.println("Moneda " + tipos[i] + ": " + unidades + " unidades");
                }

            } else if (opcion == 3) {
                // Mostrar saldo
                double saldo = caja.getSaldo();
                System.out.println("Saldo actual: " + saldo);

            } else if (opcion == 4) {
                // Sacar monedas
                System.out.print("Tipo de moneda (ej: 0.10): ");
                float tipo = scanner.nextFloat();
                System.out.print("Cantidad de monedas a sacar: ");
                int cantidad = scanner.nextInt();

                boolean resultado = caja.sacarMonedas(tipo, cantidad);
                if (resultado) {
                    System.out.println("Monedas retiradas.");
                } else {
                    System.out.println("Error: no se pudo sacar.");
                }

            } else if (opcion == 5) {
                System.out.println("¡Hasta luego!");
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
