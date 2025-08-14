package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;

public class ViewHealthArticleController {

    @FXML
    private TableView<HealthArticle> listOfArticleTableView;

    @FXML
    private TableColumn<HealthArticle, String> listOfArticleTableCol;

    @FXML
    private TextArea shortDescriptionTextArea;

    @FXML
    private TextField searchTextField;

    private ObservableList<HealthArticle> articles;

    @FXML
    public void initialize() {
        // TableColumn setup
        listOfArticleTableCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Sample articles
        articles = FXCollections.observableArrayList(
                new HealthArticle("Healthy Eating", "Tips for balanced diet", "Full article content on healthy eating..."),
                new HealthArticle("Exercise Benefits", "Why exercise is important", "Full article content on exercise..."),
                new HealthArticle("Mental Health", "How to reduce stress", "Full article content on mental health...")
        );

        listOfArticleTableView.setItems(articles);

        // Show short description on row selection
        listOfArticleTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                shortDescriptionTextArea.setText(newSelection.getShortDescription());
            }
        });
    }

    @FXML
    public void readMoreButtonOnAction(ActionEvent actionEvent) {
        HealthArticle selected = listOfArticleTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(selected.getTitle());
            alert.setHeaderText("Full Article Content");
            alert.setContentText(selected.getFullContent());
            alert.showAndWait();
        }
    }

    @FXML
    public void shareButtonOnAction(ActionEvent actionEvent) {
        HealthArticle selected = listOfArticleTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            // Simple share simulation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Share Article");
            alert.setHeaderText(null);
            alert.setContentText("Article \"" + selected.getTitle() + "\" shared successfully!");
            alert.showAndWait();
        }
    }
}
