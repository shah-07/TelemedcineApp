package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ReplyFAQSViewController {

    @FXML
    private TextArea selectedQuestionTA;
    @FXML
    private TextArea answerTA;
    @FXML
    private Label answerSubmittedLabel;
    @FXML
    private TableColumn<ReplyFAQSView, String> questionCol;
    @FXML
    private TableColumn<ReplyFAQSView, LocalDate> dateCol;
    @FXML
    private TableColumn<ReplyFAQSView, String> statusCol;
    @FXML
    private DatePicker toDateDP;
    @FXML
    private DatePicker fromDateDP;
    @FXML
    private TableView<ReplyFAQSView> FAQTableView;

    private ObservableList<ReplyFAQSView> faqList;

    @FXML
    public void initialize() {
        questionCol.setCellValueFactory(new PropertyValueFactory<>("question"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));


        faqList = FXCollections.observableArrayList(
                new ReplyFAQSView("What are your clinic hours?", LocalDate.of(2025, 8, 10), "Pending", null),
                new ReplyFAQSView("Do you offer home visits?", LocalDate.of(2025, 8, 12), "Answered", "Yes, with prior appointment."),
                new ReplyFAQSView("What payment methods are accepted?", LocalDate.of(2025, 8, 14), "Pending", null)
        );

        FAQTableView.setItems(faqList);


        FAQTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                selectedQuestionTA.setText(newSel.getQuestion());
                answerTA.clear();
                answerSubmittedLabel.setText("");
            }
        });
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        LocalDate fromDate = fromDateDP.getValue();
        LocalDate toDate = toDateDP.getValue();

        if (fromDate == null || toDate == null) {
            answerSubmittedLabel.setText("Please select both From and To dates.");
            return;
        }

        ObservableList<ReplyFAQSView> filtered = FXCollections.observableArrayList(
                faqList.stream()
                        .filter(faq -> !faq.getDate().isBefore(fromDate) && !faq.getDate().isAfter(toDate))
                        .collect(Collectors.toList())
        );

        FAQTableView.setItems(filtered);
    }

    @FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {
        ReplyFAQSView selected = FAQTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            answerSubmittedLabel.setText("Please select a question to reply.");
            return;
        }

        String reply = answerTA.getText().trim();
        if (reply.isEmpty()) {
            answerSubmittedLabel.setText("Reply cannot be empty.");
            return;
        }

        selected.setAnswer(reply);
        selected.setStatus("Answered");
        FAQTableView.refresh();
        answerSubmittedLabel.setText("Reply submitted successfully.");
    }
}
