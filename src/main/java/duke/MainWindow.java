package duke;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Parser parser;
    private Ui ui;
    private TaskList taskList;
    private Storage storage;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
    private String filePath = "../duke/data/duke.txt";

    @FXML
    public void initialize() throws FileNotFoundException {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load(), ui);
        } catch (DukeException e) {
            String err = DukeStub.getResponse(ui.showInvalidFile());
            dialogContainer.getChildren().addAll(
                    DialogBox.getDukeDialog(err, duke)
            );
            taskList = new TaskList(ui);
        }

        //Greets the user
        String greet = DukeStub.getResponse("Hello! I'm Duke\nWhat can I do for you?");
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(greet, duke)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() throws IOException {
        String input = userInput.getText();
        parser = new Parser(ui, taskList, input);
        String response = DukeStub.getResponse(parser.run());
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, user),
                DialogBox.getDukeDialog(response, duke)
        );
        userInput.clear();
        storage.writeStorage(taskList);

        if (input.equals("bye")) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                Platform.exit();
            });
            pause.play();
        }
    }
}
