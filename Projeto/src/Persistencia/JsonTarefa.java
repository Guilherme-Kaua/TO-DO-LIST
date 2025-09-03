package Persistencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import CRUD.ManipuladorDeTarefas;

public class JsonTarefa {

    private static final String NOME_ARQUIVO = "tarefas.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Salva o objeto ManipuladorDeTarefas inteiro no arquivo JSON.
     * @param manipulador O objeto a ser salvo.
     */
    public void salvarTarefas(ManipuladorDeTarefas manipulador) {
        try (FileWriter writer = new FileWriter(NOME_ARQUIVO)) {
            gson.toJson(manipulador, writer);
            System.out.println("Estado do manipulador de tarefas salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    /**
     * Carrega o estado completo do ManipuladorDeTarefas a partir de um arquivo JSON.
     * Segue a mesma lógica do seu exemplo com XStream.
     * @return um objeto ManipuladorDeTarefas.
     */
    public ManipuladorDeTarefas carregarTarefas() {
        File arquivo = new File(NOME_ARQUIVO);

        if (arquivo.exists()) {
            try (FileReader reader = new FileReader(arquivo)) {
                // AGORA SIM! Fica muito mais simples.
                // Não precisamos de TypeToken, pois o tipo principal (ManipuladorDeTarefas) não é genérico.
                // O Gson é inteligente o suficiente para ver o campo "tarefas" e preenchê-lo.
                ManipuladorDeTarefas manipulador = gson.fromJson(reader, ManipuladorDeTarefas.class);
                System.out.println("Estado do manipulador de tarefas carregado com sucesso!");
                return manipulador;
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        // Se o arquivo não existir ou ocorrer um erro, retorna uma nova instância.
        System.out.println("Arquivo não encontrado. Criando um novo manipulador de tarefas.");
        return new ManipuladorDeTarefas();
    }
}