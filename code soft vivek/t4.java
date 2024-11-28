import java.util.*;

public class  t4{

    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        public Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();
        int score = 0;

        // Adding quiz questions
        quiz.add(new Question("What is the capital of France?",
                new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        quiz.add(new Question("Which programming language is platform-independent?",
                new String[]{"1. Python", "2. C", "3. Java", "4. JavaScript"}, 3));
        quiz.add(new Question("What is the largest planet in our Solar System?",
                new String[]{"1. Earth", "2. Jupiter", "3. Mars", "4. Venus"}, 2));
        quiz.add(new Question("Who wrote 'Hamlet'?",
                new String[]{"1. Charles Dickens", "2. Leo Tolstoy", "3. William Shakespeare", "4. Mark Twain"}, 3));

        Map<Question, Boolean> results = new HashMap<>();

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 10 seconds to answer each question.\n");

        for (Question q : quiz) {
            System.out.println(q.question);
            for (String option : q.options) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.\n");
                    timer.cancel();
                }
            };

            timer.schedule(task, 10000); // 10 seconds timer

            int userAnswer = -1;
            try {
                System.out.print("Your answer (1-4): ");
                userAnswer = scanner.nextInt();
                timer.cancel(); // Cancel timer once user answers
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Moving to the next question.");
                scanner.next(); // Clear invalid input
            }

            boolean isCorrect = userAnswer == q.correctAnswer;
            results.put(q, isCorrect);
            if (isCorrect) {
                System.out.println("Correct!\n");
                score++;
            } else if (userAnswer != -1) {
                System.out.println("Wrong! The correct answer was " + q.correctAnswer + ".\n");
            }
        }

        System.out.println("Quiz Complete!");
        System.out.println("Your Score: " + score + "/" + quiz.size());
        System.out.println("\nSummary:");

        for (Map.Entry<Question, Boolean> entry : results.entrySet()) {
            String result = entry.getValue() ? "Correct" : "Incorrect";
            System.out.println(entry.getKey().question + " - " + result);
        }

        scanner.close();
    }
}
