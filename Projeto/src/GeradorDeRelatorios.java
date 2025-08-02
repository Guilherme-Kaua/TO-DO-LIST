import com.itextpdf.text.Document;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

public class GeradorDeRelatorios {


    public static <LocalDate> void obterTarefasDeUmDia(LocalDate data, CentralDeInformacoes central) throws Exception {

        int contador = 0;
        for (Tarefa tarefa: central.todasAsTarefas){
            if (tarefa.getDeadline().equals(data)){
                contador++;
            }
        }
        if (contador == 0){
            throw new Exception("Não é possível mandar um pdf sem tarefas");
        }

        Document doc = new Document(PageSize.A4);
        try {
            OutputStream os = new FileOutputStream("Relatorio.pdf");

            PdfWriter.getInstance(doc, os);

            doc.open();
            for(Tarefa t: central.todasAsTarefas) {
                if(t.getDeadline().equals(data)) {
                    Paragraph pg = new Paragraph(t.toString());
                    doc.add(pg);
                }
            }
            doc.close();

        } catch (Exception e){
            System.out.println("Um erro inesperado aconteceu");
            e.printStackTrace();
        }
    }
}
