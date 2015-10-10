package metasite.dao;

import metasite.entities.Word;

import java.util.List;

/**
 * Created by paulius on 10/10/2015.
 */
public interface WordDaoCustom {
	List<Word> findByFirstLetter();
}
