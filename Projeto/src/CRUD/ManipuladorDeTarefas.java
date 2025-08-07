package CRUD;
import Principais.*;
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

        public List<Tarefa> listarTarefas() {
            return todasAsTarefas;
        }


        //public void excluirTarefa(Tarefa e){
           // for (Tarefa tarefa: todasAsTarefas){

        //}

    }
}
