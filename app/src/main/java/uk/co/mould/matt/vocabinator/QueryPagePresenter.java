package uk.co.mould.matt.vocabinator;

import java.util.List;

public class QueryPagePresenter {
    public QueryPagePresenter(final QueryView queryView, final VocabProvider vocabProvider) {
        queryView.addQueryButtonListener(new QueryView.QueryButtonListener() {
            @Override
            public void pressed() {
                vocabProvider.getVocabItem(queryView.getTextBoxString(), new VocabProvider.VocabCallback() {
                    @Override
                    public void success(List<VocabItem> vocabItems) {
                        queryView.showResults(vocabItems);
                    }
                });
            }
        });
    }
}
