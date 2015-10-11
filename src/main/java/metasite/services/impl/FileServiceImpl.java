package metasite.services.impl;

import metasite.dao.WordDao;
import metasite.entities.Word;
import metasite.threads.FileWritingThread;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import metasite.services.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by paulius on 10/5/2015.
 */
@Service("fileService")
@Transactional(readOnly = false)
public class FileServiceImpl implements FileService {

	@Autowired
	private WordDao wordDao;

	@Autowired
	private FileWritingThread fileWritingThread;

	@Override
	public void fileUpload(MultipartFile file) {
		String fileString = null;
		try {
			fileString = IOUtils.toString(file.getInputStream(), "UTF-8");
		} catch (Exception e) {
			//throw new GeneralException(MessageCodes.RSRCH_FailedToReadMetadataXmlDocument, "ResearchService.getMetadataFromXml: failed to validate XML document");
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
}
