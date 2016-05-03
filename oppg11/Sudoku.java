import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//TODO det er mye static fordi Application instance er vanskelig
public class Sudoku extends Application {
	private static SudokuBeholder sb;
	private static GridPane brett = new GridPane();
	private static Text[][] ruter;

	public static void main(String[] args) {
			launch();
	}

	@Override
	public void start(Stage stage) {
		BorderPane hovedPanel = new BorderPane();
		hovedPanel.setTop(lagLastFilKnapp());
		hovedPanel.setBottom(lagNesteknapp());
		hovedPanel.setCenter(brett);
		//initBrett();
		//oppdaterBrett(); //TODO plasser i en loop?

		Scene scene = new Scene(hovedPanel);
		stage.setScene(scene);
		stage.setTitle("Sudoku");
		stage.show();
	}

	public static void losSudoku() {
		try {
			Filbehandler fb = new Filbehandler();
			File f = new FileChooser().showOpenDialog(null);
			Brett b = fb.lesFil(f);
			//b.printBrett();

			sb = new SudokuBeholder(b);
			b.losBrett(sb);
			fb.skrivFil(sb, "losninger.txt");

			initBrett();
			oppdaterBrett();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initBrett() {
		int lengde = sb.hentLengde();
		ruter = new Text[lengde][lengde];
		for (int i = 0; i < lengde; i++) {
			for (int j = 0; j < lengde; j++) {
				ruter[i][j] = new Text();
				brett.add(ruter[i][j], i, j);
			}
		}
	}

	public static void oppdaterBrett() { //TODO public for only one class?
		int[][] tall;
		if (sb !=null)
			tall = sb.taUtInt();
		else
			return;

		if (tall == null)
			return;

		int lengde = tall[0].length;
		for (int i = 0; i < lengde; i++) {
			for (int j = 0; j < lengde; j++) {
				String v = Integer.toString(tall[i][j]);
				ruter[i][j].setText(v);
			}
		}
	}

	private Button lagLastFilKnapp() {
		Button lastfil = new Button("Last fil");
		EventHandler<ActionEvent> handler =
			new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent evt) {
					Sudoku.losSudoku();
				}
			};
		lastfil.setOnAction(handler);
		return lastfil;
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
