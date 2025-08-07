package CRUD;
import Principais.*;
import Importantes.*;
import javax.sound.midi.SoundbankResource;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeTarefas {

        private List<Tarefa> todasAsTarefas = new ArrayList<>();

        public ManipuladorDeTarefas() {
            this.todasAsTarefas = new ArrayList<>();
        }



        public void adicionarTarefa(Tarefa obj) throws Exception {
            for(Tarefa valor: todasAsTarefas){
                if (valor.equals(obj)){
                    throw new Exception("Não pode mesma tarefa repetida");
                }
            }
            todasAsTarefas.add(obj);
        }

        public Tarefa recuperarTarefaPorId(long id) {
            for(Tarefa t: todasAsTarefas) {
                if (t.getId() == id) {
                    return t;
                }
            }
            return null;
        }

        public void listarTarefas() {
            todasAsTarefas.forEach(System.out::println);
        }

        public void editarTarefa(Tarefa tarefa, String t, String d, LocalDate data, int prio){
            tarefa.setTitulo(t);
            tarefa.setDescricao(d);
            tarefa.setDeadline(data);
            tarefa.setNivel(prio);
        }


        public void excluirTarefa(Tarefa tarefa){
            todasAsTarefas.remove(tarefa);
        }

        public List<Tarefa> getTarefas() {
            return todasAsTarefas;
        }

    public void setTarefas(List<Tarefa> todasAsTarefas) {
        this.todasAsTarefas = todasAsTarefas;
    }
}
