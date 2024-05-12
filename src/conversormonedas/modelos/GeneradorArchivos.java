package conversormonedas.modelos;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivos {

    public void guardarJson(String valorFinal, Moneda monedaTiempo) throws IOException {
        String resultado = "Conversion: " + valorFinal +
                " ,Tiempo de Consulta: " + monedaTiempo.getCalendario().getTime();
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("Historial.txt", true);
        escritura.write(gson.toJson(resultado));
        escritura.write("\n");
        escritura.close();
    }
}
