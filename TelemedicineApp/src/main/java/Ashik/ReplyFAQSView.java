package Ashik;

import java.io.Serializable;
import java.time.LocalDate;

public class ReplyFAQSView implements Serializable {
    private String question;
    private LocalDate date;
    private String status; // e.g., "Pending", "Answered"
    private String answer;

    public ReplyFAQSView(String question, LocalDate date, String status, String answer) {
        this.question = question;
        this.date = date;
        this.status = status;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
