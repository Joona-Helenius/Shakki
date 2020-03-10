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

	public void insert(String nappulan_tyyppi, int KoordinaattiX, int KoordinaattiY, boolean syty ) {
		String sql = "INSERT INTO Nappula(nappulan_tyyppi,KoordinaattiX,KoordinaattiY, syty) VALUES(?,?,?,?)";
		try (Connection conn = this.connect();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, nappulan_tyyppi);
			ps.setInt(2, KoordinaattiX);
			ps.setInt(3,  KoordinaattiY);
			ps.setBoolean(4, syty);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Data> selectAll() {
		String sql = "SELECT nappulan_tyyppi, KoordinaattiX, KoordinaattiY, syty FROM Nappula";
		try (Connection conn = this.connect();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				Data d = new Data(rs.getString("nappulan_tyyppi"), rs.getInt("KoordinaattiX"), rs.getInt("KoordinaattiY"), rs.getBoolean("syty"));
				a.add(d);
				//rs.deleteRow();
				//String l = rs.getString("nappulan_tyyppi");
				//int x = rs.getInt("KoordinaattiX");
				//int y = rs.getInt("KoordinaattiY");
				//boolean b = rs.getBoolean("syty");
				//System.out.println(l);
				//System.out.println(x);
				//System.out.println(y);
				//System.out.println(rs.getString("nappulan_tyyppi")+ "\t" + rs.getInt("KoordinaattiX") + "\t" + rs.getInt("KoordinaattiY"));
			}
			return a;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return a;

	}

	/*
	public static void main(String[] args) {
		database db = new database();
		//db.insert("Torni", 2, 3, true); 
		//db.insert("Sotilas",4,5);
		//db.insert("Lhetti",6,2);
		//db.insert
		db.selectAll();
		for (int i = 0; i<32; i++) {
		System.out.println(a.get(i).getTyyppi());
		System.out.println(a.get(i).getX());
		System.out.println(a.get(i).getY());
		System.out.println(a.get(i).getB());
		}
	 */
}
