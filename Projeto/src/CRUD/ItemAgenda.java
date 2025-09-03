package CRUD;

import Principais.Evento;
import Principais.Tarefa;

import java.util.ArrayList;

public abstract class ItemAgenda {
    private Evento evento;
    private Tarefa tarefa;
    private ArrayList<Object> objects ;

    public abstract void adicionar();


    public abstract Object recuperarPorId (long id);


    public void listarEventos(ArrayList<?> lista) {
        lista.forEach(System.out::println);
    }

    public abstract void editar();

    public  void excluirEvento(long Id){

        objects.remove(evento);
    }


    public boolean equals(Object obj){

        if(this== obj){
            return  true;
        }
        if (obj== null || obj.getClass() != obj.getClass()){return  false;}

        ItemAgenda outra = (ItemAgenda) obj;

        if(this.evento!= null && outra.evento!= null){
            return this.evento.equals(outra.evento);
        }
        if (this.tarefa !=null && outra.tarefa!=null){
            return this.tarefa.equals(outra.tarefa);
        }

        return false;
    }

}
