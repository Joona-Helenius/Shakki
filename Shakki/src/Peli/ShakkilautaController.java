package Peli;

import java.util.ArrayList;

import Shakki.PeliLauta;
import Shakki.Sijainti;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

	private ImageView pieceToMove;

	private Rectangle pieceSelecter;

	public void initialize() {
		pelilauta= new PeliLauta();
		pelilauta.setupGame();
	}
	
	/**
     * Alustava tallennusmetodi
     */
    public void saveGame() {
    database d = new database();
    ArrayList<ImageView> n = new ArrayList<ImageView>();
    for (int i=0;i<96;i++) {
        Node node = gridPane.getChildren().get(i);
        if(node instanceof ImageView) {
            n.add((ImageView) node);
        }
    }
    for (int i = 0; i<n.size();i++) {
        boolean b=gridPane.getChildren().contains(n.get(i));
        d.insert(n.get(i).getId(), GridPane.getColumnIndex(n.get(i)), GridPane.getRowIndex(n.get(i)), b);
    }
    //database d = new database();
    //String s = "wp1";
    //int x = GridPane.getRowIndex(wp1);
    //int y = GridPane.getColumnIndex(wp1);
    //d.insert(s, x, y, false);
    }
	
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

	@FXML
    public void prepareMove(MouseEvent event) {
        int column = GridPane.getColumnIndex((Node) event.getSource());
        int row = GridPane.getRowIndex((Node) event.getSource());
        if(pieceToMove!=null) {
            int column1 = GridPane.getColumnIndex(pieceToMove);
            int row1 = GridPane.getRowIndex(pieceToMove);
            if(pelilauta.movePieceTo(new Sijainti(column1, row1) , new Sijainti(column, row))) {
                gridPane.getChildren().remove((Node)event.getSource());
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
