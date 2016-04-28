import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TODO det er mye static fordi Application instance er vanskelig
public class Losningsviser extends Application {
	private static SudokuBeholder sb;
	private static GridPane brett = new GridPane();

	public static void settBeholder(SudokuBeholder sb) {
		Losningsviser.sb = sb;
	}

	@Override
	public void start(Stage stage) {
		BorderPane hovedPanel = new BorderPane();
		hovedPanel.setCenter(lagSudokupanel());
		hovedPanel.setBottom(lagNesteknapp());

		Scene scene = new Scene(hovedPanel);
		stage.setScene(scene);
		stage.setTitle("Sudoku");
		stage.show();
	}

	private GridPane lagSudokupanel() { //TODO oppdaterBrett()
		GridPane gp = new GridPane();

		//TODO
		int[][] ruter = sb.taUtInt();
		gp.add(new Text("0"), 0, 0);
		gp.add(new Text("9"), 9, 9);

		return gp;
	}

	private HBox lagNesteknapp() {
		HBox hbox = new HBox();

		Button nesteKnapp = new Button("Neste losning");
		//TODO set event handler

		hbox.getChildren().addAll(nesteKnapp);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
}
