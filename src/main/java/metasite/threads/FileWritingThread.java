package metasite.threads;

import metasite.configuration.Configuration;
import metasite.dao.WordDao;
import metasite.entities.Word;
import metasite.utils.FirstLetterInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by paulius on 10/11/2015.
 */
@Component
public class FileWritingThread extends Thread {

	@Autowired
	private WordDao wordDao;

	@Autowired
	private Configuration configuration;

	@Override
	public void run() {
		String userDir = System.getProperty("user.dir");
		String fileDirectory = userDir + configuration.outputFilesFolderName;
		new File(fileDirectory).mkdirs();
		try {
			writeToFile(FirstLetterInterval.aGInterval, fileDirectory + configuration.outputAGFileName);
			writeToFile(FirstLetterInterval.hNInterval, fileDirectory + configuration.outputHNFileName);
			writeToFile(FirstLetterInterval.oUInterval, fileDirectory + configuration.outputOUFileName);
			writeToFile(FirstLetterInterval.vZInterval, fileDirectory + configuration.outputVZFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void writeToFile(char[] firstLetterArray, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.println("word|count");
		writer.println();
		List<Word> wordList = wordDao.findByFirstLetter(firstLetterArray, null, null);
		for (Word word : wordList) {
			writer.println(word.getValue() + "|" + word.getCount());
		}
		writer.close();
	}
}
