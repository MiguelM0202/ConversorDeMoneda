package com.mm.convex.modelos.manejo;

import com.google.gson.Gson;
import com.mm.convex.modelos.api.ConversorAPI;
import com.mm.convex.modelos.api.RespuestaTRM;
import com.mm.convex.modelos.api.TRM;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConsultarTasaCambio {

    public ConsultarTasaCambio() throws IOException, InterruptedException {
    }

    public ConversorAPI consultarBasePorCodigo(String codigoBase){
        URI direccion = URI.create(
                "https://v6.exchangerate-api.com/v6/20d8fea5dc096d4a71d48971/latest/" +
                codigoBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorAPI.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Conversión no disponible, falta de respuesta del servidor");
            throw new RuntimeException();
        }

    }
    public TRM tasaRepresentativa() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/20d8fea5dc096d4a71d48971/latest/usd"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        RespuestaTRM respuestaTRM = gson.fromJson(json, RespuestaTRM.class);
        return new TRM(respuestaTRM.getTime_last_update_utc());
    }
    String fechaCompleta = tasaRepresentativa().time_last_update_utc();
    String fechaCorta = fechaCompleta.substring(5,16);

    public String fechaCorta() {
        return fechaCorta;
    }
}
