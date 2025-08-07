package Importantes;

import CRUD.ManipuladorDeEventos;
import CRUD.ManipuladorDeTarefas;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;


public class Persistencia {

    //cria o objeto xstream para converter outros objetos
    private final XStream xstream = new XStream(new DomDriver());

    //cria o arquivo
    private final File arquivoTarefas = new File("tarefas.xml");
    private final File arquivoEventos = new File("eventos.xml");


    public void salvarCentral(ManipuladorDeTarefas tarefas) throws IOException {

        //convertendo objeto em uma String em formato xml
        String xml = xstream.toXML(tarefas);

        //se arquivo não existe, ele cria um
        if(!arquivoTarefas.exists()) arquivoTarefas.createNewFile();

        //gravar as informaçoes no arquivo
        PrintWriter gravar = new PrintWriter(arquivoTarefas);
        gravar.print(xml);
        gravar.close();

    }

    public ManipuladorDeEventos recuperarEventos() throws FileNotFoundException {
        xstream.addPermission(AnyTypePermission.ANY);
        if(arquivoTarefas.exists()){

            FileInputStream fis = new FileInputStream(arquivoTarefas);

            return (ManipuladorDeEventos) xstream.fromXML(fis);
        }
        //se o arquivo nao existir retorna uma nova instancia de estoque
        return new ManipuladorDeEventos();
    }

    public void salvarEventos(ManipuladorDeEventos eventos) throws IOException {

        //convertendo objeto em uma String em formato xml
        String xml = xstream.toXML(eventos);

        //se arquivo não existe, ele cria um
        if(!arquivoEventos.exists()) arquivoTarefas.createNewFile();

        //gravar as informaçoes no arquivo
        PrintWriter gravar = new PrintWriter(arquivoEventos);
        gravar.print(xml);
        gravar.close();

    }

    public ManipuladorDeTarefas recuperarTarefas() throws FileNotFoundException {
        xstream.addPermission(AnyTypePermission.ANY);
        if(arquivoTarefas.exists()){

            FileInputStream fis = new FileInputStream(arquivoTarefas);

            return (ManipuladorDeTarefas) xstream.fromXML(fis);
        }
        //se o arquivo nao existir retorna uma nova instancia de estoque
        return new ManipuladorDeTarefas();
    }



}
