import java.util.Random;

public class Meses {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        double[][] temperaturas = new double[12][];

        // Llenar el arreglo con temperaturas aleatorias entre 30 y 41 grados
        for (int mes = 0; mes < 12; mes++) {
            temperaturas[mes] = new double[diasPorMes[mes]];
            for (int dia = 0; dia < diasPorMes[mes]; dia++) {
                temperaturas[mes][dia] = 30 + rand.nextDouble() * 11; // Temperaturas entre 30 y 41 grados
            }
        }

        // Variables para hacer el cálculo anual
        double sumaAnual = 0, tempMaxAnual = 30, tempMinAnual = 41;
        int totalDias = 0;

        System.out.println("------ TEMPERATURAS DIARIAS -------");
        for (int mes = 0; mes < 12; mes++) {
            System.out.println("\nMes " + (mes + 1));
            System.out.println("+------+------------+");
            System.out.println("| Día  | Temperatura |");
            System.out.println("+------+------------+");

            for (int dia = 0; dia < temperaturas[mes].length; dia++) {
                System.out.printf("| %4d | %10.2f°C |\n", dia + 1, temperaturas[mes][dia]);
            }
            System.out.println("+------+------------+");
        }

        System.out.println("\n------ TEMPERATURAS MENSUALES ------");
        System.out.println("+-----+------------+------------+------------+");
        System.out.println("| Mes | Promedio   | Máxima      | Mínima      |");
        System.out.println("+-----+------------+------------+------------+");

        for (int mes = 0; mes < 12; mes++) {
            double sumaMensual = 0, tempMaxMensual = 30, tempMinMensual = 41;

            for (double temp : temperaturas[mes]) {
                sumaMensual += temp;
                tempMaxMensual = Math.max(tempMaxMensual, temp);
                tempMinMensual = Math.min(tempMinMensual, temp);
            }

            double promedioMensual = sumaMensual / temperaturas[mes].length;
            System.out.printf("| %3d | %10.2f°C | %10.2f°C | %10.2f°C |\n", mes + 1, promedioMensual, tempMaxMensual, tempMinMensual);

            // Acumular datos para el cálculo anual
            sumaAnual += sumaMensual;
            tempMaxAnual = Math.max(tempMaxAnual, tempMaxMensual);
            tempMinAnual = Math.min(tempMinAnual, tempMinMensual);
            totalDias += temperaturas[mes].length;
        }
        System.out.println("+-----+------------+------------+------------+");

        // Cálculo y muestra de datos anuales
        double promedioAnual = sumaAnual / totalDias;
        System.out.println("\n------ RESUMEN ANUAL -----");
        System.out.println("+-------------+------------+");
        System.out.println("| Categoría   | Temperatura |");
        System.out.println("+-------------+------------+");
        System.out.printf("| Promedio    | %10.2f°C |\n", promedioAnual);
        System.out.printf("| Máxima      | %10.2f°C |\n", tempMaxAnual);
        System.out.printf("| Mínima      | %10.2f°C |\n", tempMinAnual);
        System.out.println("+-------------+------------+");
    }
}

