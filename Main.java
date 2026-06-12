import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    String correctAnswer;

    
    // 1. Constructor used to initialize question details

    Question(String q, String[] opt, String ans) {
        questionText = q;
        options = opt;
        correctAnswer = ans;
    }
}

class QuizManager {
    Question[] questions;
    int score = 0;
// 2. Constructor creates and stores quiz questions
    QuizManager() {
        questions = new Question[2];

        questions[0] = new Question(
            "What is Java?",
            new String[]{"a) Programming Language", "b) OS", "c) DB", "d) Browser"},
            "a"
        );

        questions[1] = new Question(
            "What is OOP?",
            new String[]{"a) Object-Oriented Programming", "b) OS", "c) Process", "d) None"},
            "a"
        );
    }

    void startQuiz() {
        Scanner sc = new Scanner(System.in);
 // 3. Loop through all questions one by one
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQ" + (i + 1) + ": " + questions[i].questionText);
 // 4. Display all options for the current question
            for (int j = 0; j < questions[i].options.length; j++) {
                System.out.println(questions[i].options[j]);
            }

            System.out.print("Enter your answer: ");
            String userAnswer = sc.next();

            if (userAnswer.equals(questions[i].correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\nFinal Score: " + score + "/" + questions.length);
        sc.close();
    }
}
// Main class
public class Main {
    public static void main(String[] args) {
        QuizManager quiz = new QuizManager();
        quiz.startQuiz();
    }
}
