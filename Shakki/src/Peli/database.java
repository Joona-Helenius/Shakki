package Peli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class database {

	static ArrayList<Data> a = new ArrayList<Data>();

	public Connection connect() {
		String url = "jdbc:sqlite:shakki.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection established");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void insert(int id, String nappulan_tyyppi, int KoordinaattiX, int KoordinaattiY, boolean syöty ) {
        String sql = "INSERT INTO Nappula(id, nappulan_tyyppi,KoordinaattiX,KoordinaattiY, syöty) VALUES(?,?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nappulan_tyyppi);
            ps.setInt(3, KoordinaattiX);
            ps.setInt(4,  KoordinaattiY);
            ps.setBoolean(5, syöty);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public ArrayList<Data> loadAll() {
        String sql = "SELECT nappulan_tyyppi, KoordinaattiX, KoordinaattiY, syöty FROM Nappula";
        try (Connection conn = this.connect();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)){
            while (rs.next()) {
                Data d = new Data(rs.getString("nappulan_tyyppi"), rs.getInt("KoordinaattiX"), rs.getInt("KoordinaattiY"), rs.getBoolean("syöty"));
                a.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;

    }

	public int lastRow() {
		int r = 0;
		String sql = "SELECT id FROM Nappula ORDER BY id DESC LIMIT 1";
		try (Connection conn = this.connect();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			//while(rs.first()) {
			r = rs.getInt("id");
			//}

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	public void delete(int id) {
		String sql = "DELETE FROM Nappula WHERE id = ?";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
