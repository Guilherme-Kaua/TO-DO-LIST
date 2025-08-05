import com.itextpdf.text.Document;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class GeradorDeRelatorios {


    public static <LocalDate> void obterTarefasDeUmDia(LocalDate data, ManipuladorDeTarefas tarefas) throws Exception {

        int contador = 0;
        for (Tarefa tarefa: tarefas.getTodasAsTarefas()){
            if (tarefa.getDeadline().equals(data)){
                contador++;
            }
        }
        if (contador == 0){
            throw new Exception("Não é possível mandar um pdf sem tarefas");
        }

        Document doc = new Document(PageSize.A4);

            OutputStream os = new FileOutputStream("Relatorio.pdf");

            PdfWriter.getInstance(doc, os);

            doc.open();
            for(Tarefa t: tarefas.getTodasAsTarefas()) {
                if(t.getDeadline().equals(data)) {
                    Paragraph pg = new Paragraph(t.toString());
                    doc.add(pg);
                }
            }
            doc.close();

    }
}
