package duke;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.Collections;

public class DialogBox extends HBox {

    @FXML
    private Label dialog;
    @FXML
    private Circle displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        dialog.setPadding(new Insets(10,15,10,15));
        dialog.setMinHeight(Region.USE_PREF_SIZE);
        displayPicture.setFill(new ImagePattern(img));
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);

    }

    public static DialogBox getUserDialog(String text, Image img) {
        var userDialog = new DialogBox(text, img);
        userDialog.dialog.setStyle("-fx-background-image: url(images/UserBubble.png); " +
                "-fx-background-size: stretch, contain; -fx-background-position: center; " +
                "-fx-background-repeat: no-repeat no-repeat;");
        return userDialog;
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        var dukeBubble = new DialogBox(text, img);
        dukeBubble.flip();
        dukeBubble.dialog.setStyle("-fx-background-image: url(images/DukeBubble.png); " +
                "-fx-background-size: stretch, contain; -fx-background-position: center; " +
                "-fx-background-repeat: no-repeat no-repeat;");
        return dukeBubble;
    }
}