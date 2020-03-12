package Peli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * Tietokannan perusluokka, jolla tietokanta toteutetaan jdbc driverin ja SQL:n avulla. ArrayList<Data> a auttaa tiedon tallentamisessa GUI:ssa. 
 * Luokasta löytyy erilaisia metodeja, jolla dataa voidaan tallentaa, poistaa ja hakea kannasta.
 */

public class database {

	static ArrayList<Data> a = new ArrayList<Data>();
	
	/**
	 * Perus metodi, jolla luodaan Connection olio, jotta tietokantaan voidaan yhdistää muissa metodeissa. Palauttaa Connection olion.
	 * @return Connection 
	 */

	public Connection connect() {
		String url = "jdbc:sqlite:shakki.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	/**
	 * insert-metodi mahdollistaa pelinappuloiden datan tallentamisen tietokannan Nappula-tauluun.
	 * 
	 * @param id tietokannan rivien järjestysluku
	 * @param nappulan_tyyppi pelinappulan tyypin tallentaminen, jotta GUI osaa luoda pelitilan uudestaan. Tallentamiseen käytetään fx:id:tä
	 * @param KoordinaattiX Pelinappulan sijainti x-koordinaatteina
	 * @param KoordinaattiY Pelinappulan sijainti y-koordinaatteina
 	 */
	public void insert(int id, String nappulan_tyyppi, int KoordinaattiX, int KoordinaattiY) {
		String sql = "INSERT INTO Nappula(id, nappulan_tyyppi,KoordinaattiX,KoordinaattiY) VALUES(?,?,?,?)";
		try (Connection conn = this.connect();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setString(2, nappulan_tyyppi);
			ps.setInt(3, KoordinaattiX);
			ps.setInt(4,  KoordinaattiY);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * insertTurn-metodi päivittää sen hetkisen pelaajan vuoron Vuoro-tauluun. 0 on valkoinen ja 1 on musta.
	 * @param r tämän hetkisen pelaajan vuoro
	 */
	public void insertTurn(int r) {
		String sql = "INSERT INTO Vuoro (pelaaja) VALUES (?)";
		try (Connection conn = this.connect();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, r);
			ps.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * loadAll-metodi ottaa tietokannasta kaiken Nappula-taulussa olevan datan, jotta aikaisempaan pelitilaan voidaan palata. Palauttaa ArrayList<Data> a:n.
	 * @return ArrayList<Data> 
	 */
	public ArrayList<Data> loadAll() {
		String sql = "SELECT nappulan_tyyppi, KoordinaattiX, KoordinaattiY FROM Nappula";
		try (Connection conn = this.connect();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				Data d = new Data(rs.getString("nappulan_tyyppi"), rs.getInt("KoordinaattiX"), rs.getInt("KoordinaattiY"));
				a.add(d);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return a;

	}
	/**
	 * lastRow-metodi on apumetodi, jolla aikaisemman datan poistaminen tietokannasta sujuu helposti. Palauttaa rivien lukumäärän.
	 * @return int r
	 */
	public int lastRow() {
		int r = 0;
		String sql = "SELECT id FROM Nappula ORDER BY id DESC LIMIT 1";
		try (Connection conn = this.connect();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			r = rs.getInt("id");
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	/**
	 * turn-metodi tarvitaan, jotta sen hetkisen pelaajan vuoro aikasemmassa pelitilassa saadaan otettua tietokannasta. Palauttaa sen hetkisen pelaajan vuoron.
	 * @return int r 
	 */
	public int turn() {
		int r = 0;
		String sql = "SELECT Pelaaja FROM Vuoro LIMIT 1";
		try (Connection conn = this.connect();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			r = rs.getInt("Pelaaja");
		} catch (SQLException e) {
			e.getMessage();
		}
		return r;
	}
	/**
	 * deleteOther-metodi vastaa Vuoro-taulun tyhjentämisestä, jotta oikean pelaajan vuoro pysyy tietokannassa.
	 * @param pelaaja tauluun tallennettu pelaaja, jonka vuoro on kyseessä.
	 */
	public void deleteOther(int pelaaja) {
		String sql = "DELETE FROM Vuoro";
		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			//pstmt.setInt(1, pelaaja);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * delete-metodi poistaa syötyjen pelinappuloiden rivit taulusta.
	 * @param id tietokannan rivin arvo, joka poistetaan.
	 */
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

