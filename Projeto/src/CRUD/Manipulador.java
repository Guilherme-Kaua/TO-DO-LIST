package CRUD;

import Principais.Tarefa;

public abstract  class Manipulador {

    public void adicionarTarefa(Object obj) throws Exception {
        for(Tarefa valor: todasAsTarefas){
            if (valor.equals(obj)){
                throw new Exception("Não pode mesma tarefa repetida");
            }
        }
        todasAsTarefas.add(obj);
    }

}
