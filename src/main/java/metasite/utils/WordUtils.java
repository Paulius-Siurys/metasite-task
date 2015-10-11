package metasite.utils;

import metasite.entities.Word;
import metasite.utils.details.WordDetails;

/**
 * Created by paulius on 10/11/2015.
 */
public class WordUtils {

	public static WordDetails getWordDetails(Word word) {
		return new WordDetails(word.getId(), word.getValue(), word.getCount());
	}
}
