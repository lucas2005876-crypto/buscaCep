import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Digite cep dos endereços a serem adicionados à lista, para finalizar e imprimir a lista digite sair:");
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        ArrayList<Endereco> enderecos = new ArrayList<>();

        while(running){
            String proximo = sc.nextLine();
            if (proximo.equals("sair")){
                running = false;
                continue;
            }
            try{
                String url = "https://viacep.com.br/ws/" + proximo + "/json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                Gson gson = new GsonBuilder().create();

                EnderecoViacep enderecoViacep = gson.fromJson(response.body(), EnderecoViacep.class);
                System.out.println(enderecoViacep);
                Endereco enderecoFinal = new Endereco(enderecoViacep);

                enderecos.add(enderecoFinal);

            }
            catch (Exception e){
                System.out.println("Erro: " + e);
            }


        }


        enderecos.forEach(System.out::println);

        System.out.println("Programa finalizado com sucesso.");

    }
}