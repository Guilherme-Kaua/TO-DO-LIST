import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;


public class Persistencia {

    public void XStream(XStream obj){
        obj.addPermission(AnyTypePermission.ANY);
        System.out.println("Deu certo");
    }
    //cria o objeto xstream para converter outros objetos
    private final XStream xstream = new XStream(new DomDriver());

    //cria o arquivo
    private File arquivo = new File("central.xml");

    public void salvarCentral(CentralDeInformacoes central) throws IOException {

        //convertendo objeto em uma String em formato xml
        String xml = xstream.toXML(central);

        //se arquivo não existe, ele cria um
        if(!arquivo.exists()) arquivo.createNewFile();

        //gravar as informaçoes no arquivo
        PrintWriter gravar = new PrintWriter(arquivo);
        gravar.print(xml);
        gravar.close();

    }

    public CentralDeInformacoes recuperarCentral() throws FileNotFoundException {
        xstream.addPermission(AnyTypePermission.ANY);
        if(arquivo.exists()){

            FileInputStream fis = new FileInputStream(arquivo);

            return (CentralDeInformacoes) xstream.fromXML(fis);
        }
        //se o arquivo nao existir retorna uma nova instancia de estoque
        return new CentralDeInformacoes();
    }



}
