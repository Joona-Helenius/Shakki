package Peli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class database {

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

	public void insert(String nappulan_tyyppi, int KoordinaattiX, int KoordinaattiY, boolean syöty ) {
		String sql = "INSERT INTO Nappula(nappulan_tyyppi,KoordinaattiX,KoordinaattiY, syöty, pelaaja) VALUES(?,?,?,?)";
		try (Connection conn = this.connect();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, nappulan_tyyppi);
			ps.setInt(2, KoordinaattiX);
			ps.setInt(3,  KoordinaattiY);
			ps.setBoolean(4, syöty);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectAll() {
		String sql = "SELECT nappulan_tyyppi, KoordinaattiX, KoordinaattiY, syöty FROM Nappula";
		try (Connection conn = this.connect();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				//String l = rs.getString("nappulan_tyyppi");
				//int x = rs.getInt("KoordinaattiX");
				//int y = rs.getInt("KoordinaattiY");
				//boolean b = rs.getBoolean("syöty");
				//System.out.println(l);
				//System.out.println(x);
				//System.out.println(y);
				System.out.println(rs.getString("nappulan_tyyppi")+ "\t" + rs.getInt("KoordinaattiX") + "\t" + rs.getInt("KoordinaattiY"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	
	public static void main(String[] args) {
		database db = new database();
		db.insert("Torni", 2, 3, true); 
		//db.insert("Sotilas",4,5);
		//db.insert("Lähetti",6,2);
		//db.selectAll();
	}

}