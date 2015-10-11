package metasite.utils.details;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paulius on 10/11/2015.
 */
public class WordDetailsList implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<WordDetails> wordList;

	private WordDetailsList(){};

	public WordDetailsList(List<WordDetails> wordList){
		this.wordList = wordList;
	};

	public List<WordDetails> getWordList() {
		return wordList;
	}


	public void setWordList(List<WordDetails> wordList) {
		this.wordList = wordList;
	}
}
