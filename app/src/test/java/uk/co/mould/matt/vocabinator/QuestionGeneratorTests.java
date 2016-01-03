package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import uk.co.mould.matt.vocabinator.quiz.QuestionGenerator;

import static org.junit.Assert.assertEquals;

public class QuestionGeneratorTests {

    @Test
    public void generatesNewQuestionFromAvailableQuestions() {
        VocabItem vocabItem = new VocabItem("a", "b");
        RandomQuestionGenerator randomQuestionGenerator = new RandomQuestionGenerator(new FakeRandomNumberGenerator(0),
                Collections.singletonList(vocabItem));

        CapturingCallback callback = new CapturingCallback();
        randomQuestionGenerator.getQuestion(callback);

        Question expectedQuestion = new Question(vocabItem.englishWord, vocabItem.frenchWord);

        assertEquals(expectedQuestion, callback.question);
    }

    private class FakeRandomNumberGenerator implements RandomNumberGenerator {

        private int randomNumber;

        public FakeRandomNumberGenerator(int randomNumber) {
            this.randomNumber = randomNumber;
        }

        @Override
        public int randomNumber(int from, int to) {
            return randomNumber;
        }
    }

    private class RandomQuestionGenerator implements QuestionGenerator {
        private final RandomNumberGenerator randomNumberGenerator;
        private final List<VocabItem> vocabItems;

        public RandomQuestionGenerator(RandomNumberGenerator randomNumberGenerator, List<VocabItem> vocabItems) {
            this.randomNumberGenerator = randomNumberGenerator;
            this.vocabItems = vocabItems;
        }

        @Override
        public void getQuestion(Callback callback) {
            VocabItem vocabItem = vocabItems.get(randomNumberGenerator.randomNumber(0, 0));
            callback.questionProvided(new Question(vocabItem.englishWord, vocabItem.frenchWord));
        }
    }

    private class CapturingCallback implements QuestionGenerator.Callback {
        private Question question;

        @Override
        public void questionProvided(Question question) {
            this.question = question;
        }
    }
}
