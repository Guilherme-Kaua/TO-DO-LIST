package CRUD;

import Importantes.Persistencia;
import Principais.Evento;
import Principais.Tarefa;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeEventos  {

    private List<Evento> todosOsEventos = new ArrayList<>();



    public ManipuladorDeEventos() throws FileNotFoundException {
        Persistencia persistencia = new Persistencia();
        if (persistencia.recuperarEventos().getEventos().isEmpty()){
            persistencia.recuperarEventos().setEventos(null);
        }
        this.todosOsEventos = persistencia.recuperarEventos().getEventos();
    }



    public void adicionarEvento(Evento obj) throws Exception {
        for(Evento valor: todosOsEventos){
            if (valor.equals(obj)){
                throw new Exception("Não pode mesma tarefa repetida");
            }
        }
        todosOsEventos.add(obj);
    }

    public Evento recuperarEventoPorId(long id) {
        for(Evento e: todosOsEventos) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void listarEventos() {
        todosOsEventos.forEach(System.out::println);
    }

    public void editarEvento(Evento evento, String t, String d, LocalDate data){
        evento.setTitulo(t);
        evento.setDescricao(d);
        evento.setDataEvento(data);
    }


    public void excluirEvento(Evento evento){
        todosOsEventos.remove(evento);
    }

    public List<Evento> getEventos() {
        return todosOsEventos;
    }

    public void setEventos(List<Tarefa> todasAsTarefas) {
        this.todosOsEventos = todosOsEventos;
    }
}
