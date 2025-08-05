import java.util.ArrayList;
import java.util.List;


public class ManipuladorDeTarefas {

    private List<Tarefa> todasAsTarefas = new ArrayList<>();


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

    public


    public void listarTarefas() {
        todasAsTarefas.forEach(System.out::println);
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
