import java.util.ArrayList;
import java.util.List;


public class ManipuladorDeTarefas {

    private List<Tarefa> todasAsTarefas = new ArrayList<Tarefa>();

    public void adicionarTarefa(Tarefa obj){
        for(Tarefa valor: todasAsTarefas){
            if (valor.equals(obj)){
                return;
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


    public void getTarefas() {
        for (Tarefa valor: todasAsTarefas){
            System.out.println(valor);
        }
    }

    public void excluirTarefa(Tarefa e){

    }

    public List<Tarefa> getTodasAsTarefas() {
        return todasAsTarefas;
    }

    public void setTodasAsTarefas(ArrayList<Tarefa> todasAsTarefas) {
        this.todasAsTarefas = todasAsTarefas;
    }

}
