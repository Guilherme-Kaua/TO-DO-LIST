import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;


public class Persistencia {

    //cria o objeto xstream para converter outros objetos
    private final XStream xstream = new XStream(new DomDriver());


    //cria o arquivo
    private File arquivo = new File("tarefa.xml");

    public void salvarTarefas(ManipuladorDeTarefas tarefas) throws IOException {

        //convertendo objeto em uma String em formato xml
        String xml = xstream.toXML(tarefas);

        //se arquivo não existe, ele cria um
        if(!arquivo.exists()) arquivo.createNewFile();

        //gravar as informaçoes no arquivo
        PrintWriter gravar = new PrintWriter(arquivo);
        gravar.print(xml);
        gravar.close();

    }

    public ManipuladorDeTarefas recuperarTarefas() throws FileNotFoundException {

        if(arquivo.exists()){
            //pega os bytes do arquivo e converte para um objeto do tipo estoque
            FileInputStream fis = new FileInputStream(arquivo);
            //cast para , converte o arquivo em formato xml para o tipo CentraDeInformaçoes
            return (ManipuladorDeTarefas) xstream.fromXML(fis);
        }
        //se o arquivo nao existir retorna uma nova instancia de estoque
        return new ManipuladorDeTarefas();
    }


}
