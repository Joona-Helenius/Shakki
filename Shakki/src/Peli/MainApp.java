package Peli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI:n pyörittämiseen tarvittava MainApp luokka, joka käyttää ShakkilautaControlleria.
 */
public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root;
		
		try {
			root=FXMLLoader.load(getClass().getResource("Shakkilauta.fxml"));
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		stage.setResizable(false);
		Scene scene= new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Shakkipeli");
		stage.show();
	}

}
