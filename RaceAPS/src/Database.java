import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private static String username = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost/race_APS";

    public ArrayList<Corrida> get() {
        String sql = "SELECT * FROM `corrida_APS`;";
        ArrayList<Corrida> dados = new ArrayList<>();

        try {
            Connection conexao = DriverManager.getConnection(url, username, password);
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                dados.add(
                    new Corrida(rs.getDouble(2), rs.getDouble(3))
                );
            }

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        };

        return dados;
    }

    public void insert(Corrida corrida) {
        String sql = "INSERT INTO `corrida_APS` (Primeira_Volta, Segunda_Volta) VALUES (?, ?)";

        try {
            Connection conexao = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, corrida.getPrimeiraVolta());
            stmt.setDouble(2, corrida.getSegundaVolta());
            stmt.executeUpdate();

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        };
    }

    public void deleteAll() {
        String sql = "DELETE FROM `corrida_APS`;";
        try {
            Connection conexao = DriverManager.getConnection(url, username, password);
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(sql);

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}