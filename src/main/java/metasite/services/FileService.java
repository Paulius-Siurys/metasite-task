package metasite.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by paulius on 10/5/2015.
 */
public interface FileService {
	void fileUpload(MultipartFile file);
}
