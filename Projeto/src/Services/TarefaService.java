package Services;

import Principais.Tarefa;
import Principais.SubTarefa;

import java.util.HashSet;
import java.util.Set;

public class TarefaService {

    public Double getPercentual(Tarefa tarefa){
        Set<SubTarefa> subTarefas = tarefa.getSubTarefas();

        if (subTarefas == null || subTarefas.isEmpty()){
            return 0.0;
        }

        double percentualSoma = 0.0;

        for (SubTarefa sub: subTarefas){
            if (sub.getStatus() == true){
                percentualSoma += 1.0;
            }
        }

        return (percentualSoma/subTarefas.size()) * 100;
    }
}
