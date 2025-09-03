import CRUD.ManipuladorDeTarefas;
import Persistencia.JsonTarefa;
import Principais.Tarefa;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        JsonTarefa persistencia = new JsonTarefa();
        ManipuladorDeTarefas central = new ManipuladorDeTarefas();

        loop:
        while (true) {
            System.out.println(
                    "1 - nova tarefa\n" +
                            "2 - listar todas as tarefas\n" +
                            "3 - exibir informações de uma tarefa específica\n" +
                            "4 - gerar relatório de tarefas de um dia específico\n" +
                            "5 - enviar email com PDF\n" +
                            "s - sair"
            );

            String escolha = input.nextLine();

            switch (escolha) {
                case "1":
                    System.out.println("Digite o título:");
                    String t = input.nextLine();

                    System.out.println("Digite a descrição:");
                    String d = input.nextLine();
                    Tarefa tarefa = new Tarefa(t, d);
                    central.adicionarTarefa(tarefa);
                    break;

                case "2":
                    persistencia.carregarTarefas().listarTarefas();

                    break;
                case "s":
                    input.close();
                    persistencia.salvarTarefas(central);
                    System.out.println("Obrigado por usar. Saindo...");
                    break loop;

                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }
    }
}