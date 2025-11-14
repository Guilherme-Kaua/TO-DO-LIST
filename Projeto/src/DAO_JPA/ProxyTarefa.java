package DAO_JPA;

import Principais.Tarefa;
import java.util.List;

public class ProxyTarefa implements DAOTarefa {

    // Interface sendo a mesma da classe concreta
    private final DAOTarefa daoReal;


    public ProxyTarefa(DAOTarefa daoReal) {
        this.daoReal = daoReal;
    }

    // ------------------------
    // Validações internas
    // ------------------------
    private void validarTarefa(Tarefa tarefa) {
        if (tarefa == null)
            throw new IllegalArgumentException("Tarefa não pode ser nula");

        if (tarefa.getTitulo() == null || tarefa.getTitulo().trim().isEmpty())
            throw new IllegalArgumentException("Título da tarefa é obrigatório");
    }

    private void validarId(Long id) {
        if (id == null || id <= 0)
            throw new IllegalArgumentException("ID inválido");
    }

    // ------------------------
    // Métodos do DAO
    // ------------------------

    @Override
    public void salvar(Tarefa tarefa) {
        validarTarefa(tarefa);
        daoReal.salvar(tarefa);
    }

    @Override
    public List<Tarefa> listar() {
        return daoReal.listar();
    }

    @Override
    public Tarefa buscar(Long id) {
        validarId(id);
        return daoReal.buscar(id);
    }

    @Override
    public void atualizar(Tarefa tarefa) {
        validarTarefa(tarefa);
        daoReal.atualizar(tarefa);
    }

    @Override
    public void deletar(Long id) {
        validarId(id);
        daoReal.deletar(id);
    }
}
