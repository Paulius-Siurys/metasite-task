package metasite.dao;

import metasite.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulius on 10/10/2015.
 */
public interface WordDao extends JpaRepository<Word, Integer>, WordDaoCustom {
	Word findByValue(String value);
}
