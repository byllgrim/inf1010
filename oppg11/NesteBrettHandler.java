import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NesteBrettHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent evt) {
		Losningsviser.oppdaterBrett();
	}
}
