package conversormonedas.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda consultaMoneda(String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5bd815710df5f65b2588264e/latest/" + moneda + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            MonedaRecord monedaRecord = new Gson().fromJson(response.body(), MonedaRecord.class);

            return new Moneda(monedaRecord);

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la moneda: " + e.getMessage());
        }
    }
}
