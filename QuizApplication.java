import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class QuizApplication {
    private List<QuizQuestion> questions;
    private int score;
    private Scanner scanner;

    public QuizApplication() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        score = 0;
    }

    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    public void startQuiz() {
        score = 0;
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ") " + options.get(j));
            }
            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int userAnswerIndex = scanner.nextInt();
            int correctAnswerIndex = currentQuestion.getCorrectOptionIndex();

            if (userAnswerIndex == correctAnswerIndex + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer is: " + options.get(correctAnswerIndex));
            }

            System.out.println();
        }

        showResult();
    }

    private void showResult() {
        System.out.println("Quiz ended! Here is your result:");
        System.out.println("Score: " + score + "/" + questions.size());

        System.out.println("\nSummary of Correct/Incorrect Answers:");
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);
            List<String> options = currentQuestion.getOptions();
            int correctAnswerIndex = currentQuestion.getCorrectOptionIndex();

            System.out.print("Question " + (i + 1) + ": " + currentQuestion.getQuestion() + " - ");
            if (score <= i) {
                System.out.println("Incorrect. Correct answer is: " + options.get(correctAnswerIndex));
            } else {
                System.out.println("Correct!");
            }
        }
    }

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();

        // Sample quiz questions
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                List.of("London", "Paris", "Berlin", "Madrid"), 1);
        QuizQuestion question2 = new QuizQuestion("Which planet is known as the Red Planet?",
                List.of("Jupiter", "Mars", "Saturn", "Neptune"), 2);
        QuizQuestion question3 = new QuizQuestion("What is 2 + 2?", List.of("3", "4", "5", "6"), 1);

        // Adding questions to the quiz
        quizApp.addQuestion(question1);
        quizApp.addQuestion(question2);
        quizApp.addQuestion(question3);

        // Starting the quiz
        quizApp.startQuiz();
    }
}
