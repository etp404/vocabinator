package uk.co.mould.matt.vocabinator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import uk.co.mould.matt.vocabinator.quiz.QuestionGenerator;
import uk.co.mould.matt.vocabinator.quiz.RandomQuestionGenerator;

import static org.junit.Assert.assertEquals;

public class QuestionGeneratorTests {

    private List<VocabItem> vocabItems = new ArrayList<VocabItem>() {{
        add(new VocabItem("a", "b"));
        add(new VocabItem("c", "d"));
    }};

    private VocabStorage vocabStorage = new ListVocabStorage(vocabItems);
    private CapturingCallback callback;

    @Before
    public void setUp() throws Exception {
        callback = new CapturingCallback();

    }

    @Test
    public void generatesNewQuestionFromAvailableQuestionsWhenMinRandomValueSelected() {
        RandomQuestionGenerator randomQuestionGenerator = new RandomQuestionGenerator(
                vocabStorage, new RandomNumberGeneratorReturnMin()
        );
        randomQuestionGenerator.getQuestion(callback);
        VocabItem vocabItem = vocabItems.get(0);
        Question expectedQuestion = new Question(vocabItem.englishWord, vocabItem.frenchWord);
        assertEquals(expectedQuestion, callback.question);
    }

    @Test
    public void generatesNewQuestionFromAvailableQuestionsWhenMaxRandomValueSelected() {
        RandomQuestionGenerator randomQuestionGenerator = new RandomQuestionGenerator(
                vocabStorage, new RandomNumberGeneratorReturnMax()
        );
        randomQuestionGenerator.getQuestion(callback);
        VocabItem vocabItem = vocabItems.get(vocabItems.size() - 1);
        Question expectedQuestion = new Question(vocabItem.englishWord, vocabItem.frenchWord);
        assertEquals(expectedQuestion, callback.question);
    }

    private class RandomNumberGeneratorReturnMin implements RandomNumberGenerator {
        @Override
        public int randomNumber(int fromInclusive, int toExclusive) {
            return fromInclusive;
        }
    }

    private class RandomNumberGeneratorReturnMax implements RandomNumberGenerator {
        @Override
        public int randomNumber(int fromInclusive, int toExclusive) {
            return toExclusive-1;
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
