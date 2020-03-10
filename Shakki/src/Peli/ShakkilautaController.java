package Peli;

import java.util.ArrayList;

import Shakki.PeliLauta;
import Shakki.Sijainti;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ShakkilautaController {

	private PeliLauta pelilauta;

	@FXML
	private Rectangle D7;

	@FXML
	private Rectangle B8;

	@FXML
	private Rectangle B7;

	@FXML
	private Rectangle G8;

	@FXML
	private Rectangle E8;

	@FXML
	private Rectangle C8;

	@FXML
	private Rectangle B5;

	@FXML
	private Rectangle G6;

	@FXML
	private Rectangle E6;

	@FXML
	private Rectangle C6;

	@FXML
	private Rectangle A6;

	@FXML
	private Rectangle H7;

	@FXML
	private Rectangle F7;

	@FXML
	private Rectangle D5;

	@FXML
	private Rectangle F5;

	@FXML
	private Rectangle H5;

	@FXML
	private Rectangle B3;

	@FXML
	private Rectangle G4;

	@FXML
	private Rectangle E4;

	@FXML
	private Rectangle C4;

	@FXML
	private Rectangle A4;

	@FXML
	private Rectangle C2;

	@FXML
	private Rectangle A2;

	@FXML
	private Rectangle H3;

	@FXML
	private Rectangle F3;

	@FXML
	private Rectangle D3;

	@FXML
	private Rectangle H1;

	@FXML
	private Rectangle F1;

	@FXML
	private Rectangle D1;

	@FXML
	private Rectangle B1;

	@FXML
	private Rectangle G2;

	@FXML
	private Rectangle E2;

	@FXML
	private Rectangle A8;

	@FXML
	private Rectangle B6;

	@FXML
	private Rectangle H8;

	@FXML
	private Rectangle G7;

	@FXML
	private Rectangle F8;

	@FXML
	private Rectangle E7;

	@FXML
	private Rectangle D8;

	@FXML
	private Rectangle C7;

	@FXML
	private Rectangle A7;

	@FXML
	private Rectangle D2;

	@FXML
	private Rectangle B2;

	@FXML
	private Rectangle G3;

	@FXML
	private Rectangle E3;

	@FXML
	private Rectangle C3;

	@FXML
	private Rectangle A3;

	@FXML
	private Rectangle H4;

	@FXML
	private Rectangle F4;

	@FXML
	private Rectangle D4;

	@FXML
	private Rectangle B4;

	@FXML
	private Rectangle G5;

	@FXML
	private Rectangle E5;

	@FXML
	private Rectangle C5;

	@FXML
	private Rectangle A5;

	@FXML
	private Rectangle H6;

	@FXML
	private Rectangle D6;

	@FXML
	private Rectangle F6;

	@FXML
	private Rectangle A1;

	@FXML
	private Rectangle H2;

	@FXML
	private Rectangle F2;

	@FXML
	private Rectangle G1;

	@FXML
	private Rectangle E1;

	@FXML
	private Rectangle C1;

	@FXML
	private ImageView wr1;

	@FXML
	private ImageView wk;

	@FXML
	private ImageView wq;

	@FXML
	private ImageView wb1;

	@FXML
	private ImageView wk1;

	@FXML
	private ImageView wp1;

	@FXML
	private ImageView wp2;

	@FXML
	private ImageView wp3;

	@FXML
	private ImageView wp4;

	@FXML
	private ImageView wp5;

	@FXML
	private ImageView wp6;

	@FXML
	private ImageView wp7;

	@FXML
	private ImageView wp8;

	@FXML
	private ImageView wr2;

	@FXML
	private ImageView wk2;

	@FXML
	private ImageView wb2;

	@FXML
	private ImageView br1;

	@FXML
	private ImageView bk;

	@FXML
	private ImageView bq;

	@FXML
	private ImageView bb1;

	@FXML
	private ImageView bk1;

	@FXML
	private ImageView bp1;

	@FXML
	private ImageView bp2;

	@FXML
	private ImageView bp7;

	@FXML
	private ImageView bp6;

	@FXML
	private ImageView bp5;

	@FXML
	private ImageView bp4;

	@FXML
	private ImageView bp3;

	@FXML
	private ImageView bp8;

	@FXML
	private ImageView br2;

	@FXML
	private ImageView bk2;

	@FXML
	private ImageView bb2;

	@FXML
	private GridPane gridPane;

	@FXML
	private Button saveButton;

	@FXML
	private Button loadButton;

	private database d;

	private ImageView pieceToMove;

	private Rectangle pieceSelecter;

	private ArrayList<ImageView> nodes;

	/**
	 * GUI:sta huolehtivan controllerin initialize-metodi. Huolehtii, että kaikki pelin pyörittämiseen tarvittavat
	 * asiat tapahtuvat.
	 */
	public void initialize() {
		pelilauta= new PeliLauta();
		d= new database();
		pelilauta.setupGame();
		nodes = new ArrayList<ImageView>();
		for (int i=0;i<gridPane.getChildren().size();i++) {
			Node node = gridPane.getChildren().get(i);
			if(node instanceof ImageView) {
				nodes.add((ImageView) node);
			}
		}
	}

	@FXML
	void handleLoad(ActionEvent event) {
		ArrayList<Data> loadData = d.loadAll();
		ArrayList<String> names= new ArrayList<String>();
		for(int i=0; i<loadData.size(); i++) {
			String s= loadData.get(i).getTyyppi();
			names.add(s);
			for(int b=0; b<nodes.size();b++) {
				String nodeName= nodes.get(b).getId();
				if(s.equals(nodeName)) {
					int column = loadData.get(i).getX();
					int row = loadData.get(i).getY();
					int columnOrig = GridPane.getColumnIndex(nodes.get(b));
					int rowOrig = GridPane.getRowIndex(nodes.get(b));
					gridPane.getChildren().remove(nodes.get(b));
					gridPane.add(nodes.get(b), column, row);
					pelilauta.setPieceTo(new Sijainti(columnOrig, rowOrig), new Sijainti(column, row));
				}
			}
		}
		for(int i=0; i<nodes.size();i++) {
			if(!(names.contains(nodes.get(i).getId()))){
				int column = GridPane.getColumnIndex(nodes.get(i));
				int row = GridPane.getRowIndex(nodes.get(i));
				gridPane.getChildren().remove(nodes.get(i));
				pelilauta.removePieceAt(new Sijainti(column, row));
				nodes.remove(nodes.get(i));
			}
		}
	}

	@FXML
	void handleSave(ActionEvent event) {
		for (int i = 0; i<d.lastRow()+1; i++) {
			d.delete(i);
		}
		for (int i = 0; i<nodes.size();i++) {
			boolean b=gridPane.getChildren().contains(nodes.get(i));
			d.insert(i, nodes.get(i).getId(), GridPane.getColumnIndex(nodes.get(i)), GridPane.getRowIndex(nodes.get(i)), b);
		}
		Platform.exit();
	}

	/**
	 * Move-metodi huolehtii nappulan liikuttamisesta GUI elementissä jos nappula liikutetaan tyhjään ruutuun.
	 * Kutsuu allaolevan PeliLauta-luokan metodeja varmistaakseen liikkeiden laillisuuden.
	 * @param event
	 */
	@FXML
	public void move(MouseEvent event) {
		if(pieceToMove!=null) {
			int column = GridPane.getColumnIndex((Node) event.getSource());
			int row = GridPane.getRowIndex((Node) event.getSource());
			int column1 = GridPane.getColumnIndex(pieceToMove);
			int row1 = GridPane.getRowIndex(pieceToMove);
			if(pelilauta.movePieceTo(new Sijainti(column1, row1) , new Sijainti(column, row))) {
				gridPane.getChildren().remove(pieceToMove);
				gridPane.add(pieceToMove, column, row);
				pieceToMove=null;
				gridPane.getChildren().remove(pieceSelecter);
			}
			else {
				return;
			}

		}
		else {
			System.out.println("No piece chosen!");
		}
	}

	/**
	 * PrepareMove-metodi valitsee GUI elementin liikutettavaksi, jos liikutettavaa elementtiä ei ole valittu.
	 * Muussa tapauksessa se huolehtii nappuloita syövistä liikkeistä samalla tavalla kuin move-metodi.
	 * @param event
	 */
	@FXML
	public void prepareMove(MouseEvent event) {
		int column = GridPane.getColumnIndex((Node) event.getSource());
		int row = GridPane.getRowIndex((Node) event.getSource());
		if(pieceToMove!=null) {
			int column1 = GridPane.getColumnIndex(pieceToMove);
			int row1 = GridPane.getRowIndex(pieceToMove);
			if(pelilauta.movePieceTo(new Sijainti(column1, row1) , new Sijainti(column, row))) {
				gridPane.getChildren().remove((Node)event.getSource());
				nodes.remove((Node)event.getSource());
				System.out.println("Piece eaten");
				gridPane.getChildren().remove(pieceToMove);
				gridPane.add(pieceToMove, column, row);
				pieceToMove=null;
				gridPane.getChildren().remove(pieceSelecter);
			}
		}
		else if(pieceToMove==null) {
			System.out.println("Piece selected");
			pieceToMove=(ImageView) event.getSource();
			createSquare(column, row);
			event.consume();
		}
	}
	/**
	 * Luo nappulanvalitsimen gridPane koordinaatteihin (column,row).
	 * @param column
	 * @param row
	 */
	public void createSquare(int column, int row) {
		pieceSelecter=new Rectangle();
		pieceSelecter.setWidth(63);
		pieceSelecter.setHeight(63);
		pieceSelecter.setFill(Color.YELLOW);
		pieceSelecter.setOpacity(0.5);
		pieceSelecter.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				pieceToMove=null;
				gridPane.getChildren().remove(pieceSelecter);
				System.out.println("Piece deselected");
				arg0.consume();

			}

		});
		gridPane.add(pieceSelecter, column, row);
	}
}
