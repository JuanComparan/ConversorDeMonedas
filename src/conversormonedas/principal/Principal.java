package conversormonedas.principal;

import conversormonedas.calculos.ConversionMoneda;
import conversormonedas.modelos.ConsultaMoneda;
import conversormonedas.modelos.GeneradorArchivos;
import conversormonedas.modelos.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    private static Scanner lectura = new Scanner(System.in);
    private static ConsultaMoneda consulta = new ConsultaMoneda();
    private static ConversionMoneda conversion = new ConversionMoneda();
    private static GeneradorArchivos generar = new GeneradorArchivos();

    public static String busquedaOpcion(int opcion){
        return switch (opcion) {
            case 1 -> "MXN";
            case 2 -> "ARS";
            case 3 -> "USD";
            case 4 -> "CAD";
            case 5 -> "BRL";
            case 6 -> "EUR";
            case 7 -> "CNY";
            case 8 -> "RUB";
            case 9 -> "VES";
            case 10 -> "PEN";
            default -> throw new IllegalStateException("Error, opción incorrecta: " + opcion);
        };
    }

    public static void main(String[] args) {
        int opcion = -1;
        String opciones = """
                1.- Peso mexicano (MXN)
                2.- Peso argentino (ARS)
                3.- Dólar americano (USD)
                4.- Dólar canadiense (CAD)
                5.- Real brasileño (BRL)
                6.- Euro (EUR)
                7.- Yuan chino (CNY)
                8.- Rublo ruso (RUB)
                9.- Bolívar venezolano (VES)
                10.- Peniques (PEN)
                
                0.- Salir
                """;
        String menu = ("""
                ----- CONVERSOR DE MONEDAS -----
                
                Porfavor seleccione cual moneda desea convertir.
                
                Tecle una opción:
                
                """+opciones);
        while(opcion != 0){
            System.out.println(menu);
            opcion = lectura.nextInt();
            
            if (opcion == 0){
                break;
            }

            Moneda moneda = consulta.consultaMoneda(busquedaOpcion(opcion));

            System.out.println("\nAhora, seleccione la moneda a convertir: " +
                    "\n\n" + opciones);
            opcion = lectura.nextInt();

            String monedaAConvertir = busquedaOpcion(opcion);

            System.out.println("\nMonto a convertir: ");
            double monto = lectura.nextDouble();

            for (int i = 0; i < 50; i++) System.out.println();

            String valorFinal = String.format("%." + 2 + "f",
                    conversion.ConversionDeMoneda(moneda.getListaMonedas().get(monedaAConvertir), monto));

            String resultado = "\n" + monto + " " + moneda.getMoneda() + " --> " +
                    valorFinal + " " + monedaAConvertir;

            System.out.println("-------------------------\n"
                    + resultado +
                    "\n\n-------------------------");

            try {
                generar.guardarJson(resultado, moneda);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println();
        }
        System.out.println("\nFinalizando programa...");
    }
}
