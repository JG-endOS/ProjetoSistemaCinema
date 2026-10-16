package com.ticketsale;

import com.google.gson.Gson;/*leva os objetos da lista pro json e vice-versa*/
import com.google.gson.GsonBuilder;/*auxilia na formatação */
import java.io.FileWriter;/*nativo, gerenciar arquvos */
import java.io.IOException;/*evita erros, como armazenamento cheio*/

import java.time.LocalDateTime;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonPrimitive;

public class ArmazenamentoJson {/*responsavel por exportar as vendas */
    public static void exportar(Dados dados, String nomeArquivo){
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        /*organizar o json
        setPrettyPrinting deixa tudo em varias linhas*/
        Gson gson = new GsonBuilder().setPrettyPrinting()
        .registerTypeAdapter(LocalDateTime.class,(JsonSerializer<LocalDateTime>) (data, tipo, contexto)-> new JsonPrimitive(data.toString())
        ).create();
        //new FileWriter("cinema.json") salva o arquivo no diretório

        //try pra não da besteira na hora de abrir arquivo
        try (FileWriter writer = new FileWriter(nomeArquivo)){
            //FileWriter abre arquivo pra escrita

            gson.toJson(dados, writer);//transforma em dados
            System.out.println("Dados exportados, para: "+nomeArquivo);
        }catch(IOException e){
            //caso tudo de errado
            System.out.println("Erro ao exportar o arquivo JSON: " + e.getMessage());
        }
    }
    public static void importar(){
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson("c1.json", Cliente.class);
        System.out.println(cliente.toString());
    }
}