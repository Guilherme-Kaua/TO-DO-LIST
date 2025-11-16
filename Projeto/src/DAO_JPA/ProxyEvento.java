package DAO_JPA;

import Principais.Evento;
import java.util.List;

public class ProxyEvento implements DAOEvento {

    // Interface sendo a mesma da classe concreta
    private final DAOEvento daoReal;

    public ProxyEvento(DAOEvento daoEvento) {
        this.daoReal = daoEvento;
    }

    private void validarEvento(Evento evento) {
        if (evento == null)
            throw new IllegalArgumentException("Evento não pode ser nulo");

        if (evento.getTitulo() == null || evento.getTitulo().trim().isEmpty())
            throw new IllegalArgumentException("Título inválido");
    }

    private void validarId(Long id) {
        if (id == null || id <= 0)
            throw new IllegalArgumentException("ID inválido");
    }

    @Override
    public void salvar(Evento evento) {
        validarEvento(evento);
        daoReal.salvar(evento);
    }

    @Override
    public List<Evento> listar() {
        return daoReal.listar();
    }

    @Override
    public Evento buscar(Long id) {
        validarId(id);
        return daoReal.buscar(id);
    }

    @Override
    public void atualizar(Evento evento) {
        validarEvento(evento);
        daoReal.atualizar(evento);
    }

    @Override
    public void deletar(Long id) {
        validarId(id);
        daoReal.deletar(id);
    }
}
