package metasite.services.impl;

import metasite.dao.WordDao;
import metasite.entities.Word;
import metasite.utils.WordUtils;
import metasite.utils.details.WordDetails;
import metasite.utils.details.WordDetailsList;
import metasite.utils.enums.FirstLetterIntervalEnum;
import metasite.threads.FileWritingThread;
import metasite.utils.FirstLetterInterval;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import metasite.services.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulius on 10/5/2015.
 */
@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService {

	@Autowired
	private WordDao wordDao;

	@Autowired
	private FileWritingThread fileWritingThread;

	@Override
	@Transactional(readOnly = false)
	public void fileUpload(MultipartFile file) {
		String fileString = null;
		try {
			fileString = IOUtils.toString(file.getInputStream(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] wordList = fileString.split("\\s+");
		for (String wordValue : wordList) {
			Word word = wordDao.findByValue(wordValue);
			if (word != null)
				word.setCount(word.getCount() + 1);
			else
				word = new Word(wordValue, 1);
			wordDao.save(word);
		}

		fileWritingThread.run();
	}

	@Override
	@Transactional(readOnly = true)
	public WordDetailsList list(FirstLetterIntervalEnum firstLetterIntervalEnum) {
		List<Word> wordList = new ArrayList<>();
		switch (firstLetterIntervalEnum) {
			case AG:
				wordList = wordDao.findByFirstLetter(FirstLetterInterval.aGInterval, null, null);
				break;
			case HN:
				wordList = wordDao.findByFirstLetter(FirstLetterInterval.hNInterval, null, null);
				break;
			case OU:
				wordList = wordDao.findByFirstLetter(FirstLetterInterval.oUInterval, null, null);
				break;
			case VZ:
				wordList = wordDao.findByFirstLetter(FirstLetterInterval.vZInterval, null, null);
				break;
		}

		List<WordDetails> wordDetailsList = new ArrayList<>();
		for (Word word : wordList) {
			wordDetailsList.add(WordUtils.getWordDetails(word));
		}

		return new WordDetailsList(wordDetailsList);
	}
}
