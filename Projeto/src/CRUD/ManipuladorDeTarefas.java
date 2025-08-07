package CRUD;
import Principais.*;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeTarefas {

        private List<Tarefa> todasAsTarefas = new ArrayList<>();


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


        //public void excluirTarefa(Tarefa e){
           // for (Tarefa tarefa: todasAsTarefas){

        //}

    public List<Tarefa> getTarefas() {
        return todasAsTarefas;
    }

    public void setTarefas(List<Tarefa> todasAsTarefas) {
        this.todasAsTarefas = todasAsTarefas;
    }
}
