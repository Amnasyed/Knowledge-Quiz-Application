package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView lblQuestion;
    RadioButton optionA;
    RadioButton optionB;
    RadioButton optionC;
    RadioButton optionD;
    Button confirm;
    String rightAnswer;
    String Answer;
    List<Question> questions;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        confirm = findViewById(R.id.confirm);
        lblQuestion = findViewById(R.id.lblPergunta);
        optionA = findViewById(R.id.opcaoA);
        optionB = findViewById(R.id.opcaoB);
        optionC = findViewById(R.id.opcaoC);
        optionD = findViewById(R.id.opcaoD);
        score = 0;
        radioGroup = findViewById(R.id.radioGroup);

        questions = new ArrayList<Question>(){
            {
                add(new Question("Fathometer is used to measure?", "C", "Earthquakes", "Rainfall ","Ocean depth ", "Sound intensity"));
                add(new Question("Epsom(England) is the place associated with?", "D", "Snooker", "Shooting","Polo", "Horse racing"));
                add(new Question("“One People, One State, One leader” was the policy of?", "B", "Stalin", "Hitler"," Lenin", " Mussolin"));
                add(new Question(" An astronaut in outer space will observe sky as", "B", "White", " Black", " Blue", "Red"));
                add(new Question("G-15 is an economic grouping of?", "C", "First World Nations", "Second World Nations", "Third World Nations", "Fourth World Nations"));
//                add(new Question("Em tecnologia, o que é I.A?", "D", "Software", "Sistema Operacional", "Compilador", "Interligência Artificial"));
//                add(new Question("Quanto vale 8 bits?", "C", "1 Bit", "16 Bytes", "1 Byte", "1 Mega Byte"));
//                add(new Question("O que é Bitcoin?", "B", "Moeda governamental", "Crypto Moeda", "Uma rede decentralizada", "Software de Datamining"));
//                add(new Question("Quem foi que criou o Bitcoin?", "B", "Margaret Hamilton", "Satoshi Nakamoto", "Alan Turing", "Gustavo Guanabara"));
//                add(new Question("Quem foi o primeiro programador?", "D", "Steve Jobs", "Linus Torvalds", "Alan Turing", "Ada Lovelace"));
            }
        };

        loadQuestion();
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        loadQuestion();
    }


    private void loadQuestion(){
        if(questions.size() > 0) {
            Question q = questions.remove(0);
            lblQuestion.setText(q.getQuestion());
            List<String> answers = q.getAnswers();

            optionA.setText(answers.get(0));
            optionB.setText(answers.get(1));
            optionC.setText(answers.get(2));
            optionD.setText(answers.get(3));

            rightAnswer = q.getRightAnswer();
        } else {
            Intent intent = new Intent(this, ShowScoreActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

    public void loadAnswer(View view) {
        int op = radioGroup.getCheckedRadioButtonId();

        switch (op){
            case R.id.opcaoA:
                Answer="A";
                break;

            case R.id.opcaoB:
                Answer="B";
                break;

            case R.id.opcaoC:
                Answer="C";
                break;

            case R.id.opcaoD:
                Answer="D";
                break;

            default:
                return;

        }

        radioGroup.clearCheck();

        this.startActivity(isRightOrWrong(Answer));

    }

    private Intent isRightOrWrong(String Answer){
        Intent screen;
        if(Answer.equals(rightAnswer)) {
            this.score += 1;
            screen = new Intent(this, RightActivity.class);

        }else {
            screen = new Intent(this, WrongActivity.class);
        }

        return screen;
    }
}
