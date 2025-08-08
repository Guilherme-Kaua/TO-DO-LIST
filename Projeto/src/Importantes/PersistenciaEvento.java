package Importantes;

import CRUD.ManipuladorDeEventos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;

public class PersistenciaEvento {

    //cria o objeto xstream para converter outros objetos
    private final XStream xstream;
    //cria o arquivo
    private final File arquivoEventos = new File("evento.xml");

    public PersistenciaEvento() {
        this.xstream = new XStream(new DomDriver());
        this.xstream.addPermission(AnyTypePermission.ANY);
    }


    public ManipuladorDeEventos recuperarEventos() throws FileNotFoundException {

        if(arquivoEventos.exists()){

            FileInputStream fis = new FileInputStream(arquivoEventos);

            return (ManipuladorDeEventos) xstream.fromXML(fis);
        }
        //se o arquivo nao existir retorna uma nova instancia de estoque
        return new ManipuladorDeEventos();
    }

    public void salvarEventos(ManipuladorDeEventos eventos) throws IOException {

        //convertendo objeto em uma String em formato xml
        String xml = xstream.toXML(eventos);


        //gravar as informaçoes no arquivo
        PrintWriter gravar = new PrintWriter(arquivoEventos);
        gravar.print(xml);
        gravar.close();

    }
}
