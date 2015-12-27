package uk.co.mould.matt.vocabinator;

import java.util.List;

public class QueryPagePresenter {
    public QueryPagePresenter(final QueryView queryView, final uk.co.mould.matt.vocabinator.dictionaryapi.VocabProvider vocabProvider) {
        queryView.addQueryButtonListener(new QueryView.QueryButtonListener() {
            @Override
            public void pressed() {
                vocabProvider.getVocabItem(queryView.getTextBoxString(), new uk.co.mould.matt.vocabinator.dictionaryapi.VocabProvider.VocabCallback() {
                    @Override
                    public void success(List<VocabItem> vocabItems) {
                        queryView.showResults(vocabItems);
                    }
                });
            }
        });
    }
}
