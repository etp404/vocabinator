package uk.co.mould.matt.vocabinator.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.mould.matt.vocabinator.R;
import uk.co.mould.matt.vocabinator.SharedPreferencesVocabStorage;
import uk.co.mould.matt.vocabinator.SystemRandomNumberGenerator;

public class QuestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        AndroidQuestionView questionView = (AndroidQuestionView) findViewById(R.id.android_question_view);
        RandomQuestionGenerator questionGenerator = new RandomQuestionGenerator(
                new SharedPreferencesVocabStorage(getApplicationContext()),
                new SystemRandomNumberGenerator());
        new QuestionPresenter(
                questionView,
                questionGenerator,
                new AnswerChecker());
    }
}
