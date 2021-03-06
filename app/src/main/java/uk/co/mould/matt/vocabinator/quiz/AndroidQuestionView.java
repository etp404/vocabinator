package uk.co.mould.matt.vocabinator.quiz;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.mould.matt.vocabinator.R;

public class AndroidQuestionView extends LinearLayout implements QuestionView {

    private static final String QUESTION_TEMPLATE = "What is the translation of %s?";
    private View nextButton;
    private ImageView greenTick;
    private ImageView redCross;
    private Button submitButton;
    private TextView resultBox;
    private TextView scoreBox;
    private TextView correctionBox;
    private TextView questionBox;
    private TextView answerBox;

    public AndroidQuestionView(Context context) {
        super(context);
    }

    public AndroidQuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AndroidQuestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setQuestion(String questionWord) {
        correctionBox.setVisibility(View.GONE);
        resultBox.setVisibility(View.GONE);
        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);
        answerBox.setVisibility(View.VISIBLE);
        answerBox.setEnabled(true);
        answerBox.setText("");
        redCross.setVisibility(GONE);

        greenTick.setVisibility(GONE);
        questionBox.setText(
                String.format(
                        QUESTION_TEMPLATE,
                        questionWord));
        clearAnimation();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        answerBox = ((TextView) findViewById(R.id.answer_box));
        submitButton = (Button)findViewById(R.id.submit_button);
        nextButton = findViewById(R.id.next_button);
        resultBox = ((TextView) findViewById(R.id.result_box));
        correctionBox = (TextView) findViewById(R.id.correction_box);
        questionBox = (TextView)findViewById(R.id.question);
        greenTick = (ImageView)findViewById(R.id.green_tick);
        redCross = (ImageView) findViewById(R.id.red_cross);
        scoreBox = (TextView) findViewById(R.id.score);
    }

    @Override
    public void setResultToCorrect() {
        resultBox.setText("Correct");
        resultBox.setVisibility(VISIBLE);
        answerBox.setEnabled(false);
        correctionBox.setVisibility(GONE);
        nextButton.setVisibility(VISIBLE);
        nextButton.setEnabled(true);
        submitButton.setVisibility(GONE);
        showGreenTick();
    }

    @Override
    public void setResultToIncorrect(String correctAnswer) {
        answerBox.setEnabled(false);
        resultBox.setText("Incorrect");
        resultBox.setVisibility(VISIBLE);
        correctionBox.setText(correctAnswer);
        correctionBox.setVisibility(VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        nextButton.setEnabled(true);
        submitButton.setVisibility(View.GONE);
        greenTick.setVisibility(View.GONE);
        showRedCross();
    }

    @Override
    public void showScore(Score score) {
        scoreBox.setVisibility(VISIBLE);
        scoreBox.setText(score.toString());
    }

    @Override
    public void addSubmitListener(final SubmitListener submitListener) {
        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                submitListener.submitAnswer(answerBox.getText().toString());
            }
        });
    }

    @Override
    public void addNextQuestionListener(final NextQuestionListener nextQuestionListener) {
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestionListener.requestNextQuestion();
            }
        });
    }

    private void showGreenTick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable drawableGreenTick = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.drawable_green_tick);
            greenTick.setImageDrawable(drawableGreenTick);
            greenTick.setVisibility(VISIBLE);
            drawableGreenTick.start();
        }
        else {
            showTickOrCross(greenTick);
        }
    }

    private void showRedCross() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimatedVectorDrawable drawableRedCross = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.drawable_red_cross);
            redCross.setImageDrawable(drawableRedCross);
            redCross.setVisibility(VISIBLE);
            drawableRedCross.start();
        }
        else {
            showTickOrCross(redCross);
        }
    }

    private void showTickOrCross(final View tickOrCross) {
        Animation fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.abc_popup_enter);
        fadeIn.setDuration(500);
        Animation fadeOut = AnimationUtils.loadAnimation(getContext(), R.anim.abc_popup_exit);
        fadeOut.setDuration(500);
        fadeOut.setStartOffset(700);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                tickOrCross.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tickOrCross.setVisibility(GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        AnimationSet s = new AnimationSet(false);
        s.addAnimation(fadeIn);
        s.addAnimation(fadeOut);
        s.setFillAfter(true);
        tickOrCross.startAnimation(s);
    }
}
