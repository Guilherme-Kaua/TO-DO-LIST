import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        try {
            // cria um arquivo meubanco.mv.db na pasta do projeto
            Connection conn = DriverManager.getConnection("jdbc:h2:./meubanco", "sa", "");
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS pessoas (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255))");
            stmt.execute("INSERT INTO pessoas (nome) VALUES ('Guilherme'), ('Kauã')");

            conn.close();
            System.out.println("Banco salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}