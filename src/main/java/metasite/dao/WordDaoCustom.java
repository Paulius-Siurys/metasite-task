package metasite.dao;

import metasite.entities.Word;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by paulius on 10/10/2015.
 */
public interface WordDaoCustom {
	Page<Word> findByFirstLetter(char[] firstLetterArray, Integer firstResult, Integer maxResults);
}
