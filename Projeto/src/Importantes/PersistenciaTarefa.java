package Importantes;

import CRUD.ManipuladorDeTarefas;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;


public class PersistenciaTarefa {

    //cria o objeto xstream para converter outros objetos
    private final XStream xstream;
    //cria o arquivo
    private final File arquivoTarefas = new File("tarefa.xml");

    public PersistenciaTarefa() {
        this.xstream = new XStream(new DomDriver());
        this.xstream.addPermission(AnyTypePermission.ANY);
    }

    public void salvarTarefas(ManipuladorDeTarefas tarefas) throws IOException {

        //convertendo objeto em uma String em formato xml
        String xml = xstream.toXML(tarefas);

        //se arquivo não existe, ele cria um


        //gravar as informaçoes no arquivo
        PrintWriter gravar = new PrintWriter(arquivoTarefas);
        gravar.print(xml);
        gravar.close();

    }

    public ManipuladorDeTarefas recuperarTarefas() throws FileNotFoundException {

        if(arquivoTarefas.exists()){

            FileInputStream fis = new FileInputStream(arquivoTarefas);

            return (ManipuladorDeTarefas) xstream.fromXML(fis);
        }
        //se o arquivo nao existir retorna uma nova instancia de estoque
        return new ManipuladorDeTarefas();
    }







}
