import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarTasaCambio {
    public ConversorAPI codigoBase(String moneda){
        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/20d8fea5dc096d4a71d48971/latest/" +
                moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorAPI.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Conversión no disponible\nError: " + e);
        }

    }

}
