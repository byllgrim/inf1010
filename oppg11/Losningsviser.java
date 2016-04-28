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
		hovedPanel.setBottom(lagNesteknapp());
		hovedPanel.setCenter(brett);
		oppdaterBrett(); //TODO plasser i en loop?

		Scene scene = new Scene(hovedPanel);
		stage.setScene(scene);
		stage.setTitle("Sudoku");
		stage.show();
	}

	public static void oppdaterBrett() { //TODO public for only one class?
		int[][] ruter = sb.taUtInt();
		int lengde = ruter[0].length;
		for (int i = 0; i < lengde; i++) {
			for (int j = 0; j < lengde; j++) {
				String v = Integer.toString(ruter[i][j]);
				brett.add(new Text(v), i, j);
				//TODO ikke overskriv tallene. initBrett()?
			}
		}
	}

	private HBox lagNesteknapp() {
		HBox hbox = new HBox();

		Button nesteKnapp = new Button("Neste losning");
		nesteKnapp.setOnAction(new NesteBrettHandler());

		hbox.getChildren().addAll(nesteKnapp);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}
}
