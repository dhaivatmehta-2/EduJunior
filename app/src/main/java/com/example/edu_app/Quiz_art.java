package com.example.edu_app;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class Quiz_art extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    ProgressBar progressBar;
    TextView timerTextView;
    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);
        progressBar = findViewById(R.id.progress_bar);
        timerTextView = findViewById(R.id.timerTextView);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        totalQuestionsTextView.setText("Total questions : " + totalQuestion);
        loadNewQuestion();
        startTimer();
    }
    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionAnswer_Art.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            updateProgressBar();
            loadNewQuestion();
            restartTimer();
        } else {
// Choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
    void updateProgressBar() {
        int progress = (int) (((float) (currentQuestionIndex) / totalQuestion) * 100);
        progressBar.setProgress(progress);
    }
    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer_Art.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer_Art.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer_Art.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer_Art.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer_Art.choices[currentQuestionIndex][3]);
    }
    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }
    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        progressBar.setProgress(0);
        loadNewQuestion();
        startTimer();
    }
    void startTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                timerTextView.setText(String.valueOf(secondsLeft));
            }
            @Override
            public void onFinish() {
                timerTextView.setText("0");
                currentQuestionIndex++;
                updateProgressBar();
                loadNewQuestion();
                restartTimer();
            }
        }.start();
    }
    void restartTimer() {
        countDownTimer.cancel();
        startTimer();
    }
}
