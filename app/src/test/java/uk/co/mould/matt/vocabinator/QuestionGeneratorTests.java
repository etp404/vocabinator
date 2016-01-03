package uk.co.mould.matt.vocabinator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import uk.co.mould.matt.vocabinator.quiz.QuestionGenerator;
import uk.co.mould.matt.vocabinator.quiz.RandomQuestionGenerator;

import static org.junit.Assert.assertEquals;

public class QuestionGeneratorTests {

    private final VocabItem vocabItem1 = new VocabItem("a", "b");
    private final VocabItem vocabItem2 = new VocabItem("c", "d");
    private VocabStorage vocabStorage = new ListVocabStorage(
            new ArrayList<VocabItem>(){{
                add(vocabItem1);
                add(vocabItem2);
            }}
    );
    private final RandomQuestionGenerator randomQuestionGenerator = new RandomQuestionGenerator(
           new RandomNumberGeneratorReturnMin(),
           vocabStorage);
    private CapturingCallback callback;

    @Before
    public void setUp() throws Exception {
        callback = new CapturingCallback();
    }

    @Test
    public void generatesNewQuestionFromAvailableQuestions() {
        randomQuestionGenerator.getQuestion(callback);
        Question expectedQuestion = new Question(vocabItem1.englishWord, vocabItem1.frenchWord);
        assertEquals(expectedQuestion, callback.question);
    }

    private class RandomNumberGeneratorReturnMin implements RandomNumberGenerator {
        @Override
        public int randomNumber(int fromInclusive, int toExclusive) {
            return fromInclusive;
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
