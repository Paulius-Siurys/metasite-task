package metasite.services.impl;

import metasite.dao.WordDao;
import metasite.entities.Word;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
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
    Logger logger = Logger.getLogger(FileServiceImpl.class);

	@Autowired
	private WordDao wordDao;

	@Override
	public void fileUpload(MultipartFile file) throws IOException {
		String fileString = null;
		try {
			fileString = IOUtils.toString(file.getInputStream(), "UTF-8");
		} catch (Exception e) {
			//throw new GeneralException(MessageCodes.RSRCH_FailedToReadMetadataXmlDocument, "ResearchService.getMetadataFromXml: failed to validate XML document");
		}
		String[] wordList = fileString.split("\\s+");
		for (String wordValue : wordList) {
			Word word = new Word(wordValue, 0);
			wordDao.save(word);
		}
	}
}
