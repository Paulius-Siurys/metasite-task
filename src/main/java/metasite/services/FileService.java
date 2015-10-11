package metasite.services;

import metasite.utils.details.WordDetails;
import metasite.utils.enums.FirstLetterIntervalEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by paulius on 10/5/2015.
 */
public interface FileService {
	void fileUpload(MultipartFile file);
	List<WordDetails> list(FirstLetterIntervalEnum firstLetterIntervalEnum);
}
