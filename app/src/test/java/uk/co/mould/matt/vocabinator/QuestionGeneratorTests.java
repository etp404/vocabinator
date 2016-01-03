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
        VocabStorage vocabStorage = new ListVocabStorage(Collections.singletonList(vocabItem));

        RandomQuestionGenerator randomQuestionGenerator =
                new RandomQuestionGenerator(
                        new FakeRandomNumberGenerator(0),
                        vocabStorage);

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
        private final VocabStorage vocabStorage;

        public RandomQuestionGenerator(RandomNumberGenerator randomNumberGenerator, VocabStorage vocabStorage) {
            this.randomNumberGenerator = randomNumberGenerator;
            this.vocabStorage = vocabStorage;
        }

        @Override
        public void getQuestion(Callback callback) {
            VocabItem vocabItem = vocabStorage.getVocabItems().get(randomNumberGenerator.randomNumber(0, 0));
            callback.questionProvided(new Question(vocabItem.englishWord, vocabItem.frenchWord));
        }
    }

    private class ListVocabStorage implements VocabStorage {
        private List<VocabItem> vocabItems;

        public ListVocabStorage(List<VocabItem> vocabItems) {
            this.vocabItems = vocabItems;
        }

        @Override
        public void store(VocabItem vocabItem) {

        }

        @Override
        public List<VocabItem> getVocabItems() {
            return vocabItems;
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
