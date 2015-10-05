package metasite.services.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import metasite.services.FileService;

/**
 * Created by paulius on 10/5/2015.
 */
@Service("fileService")
@Transactional(readOnly = false)
public class FileServiceImpl implements FileService {
	Logger logger = Logger.getLogger(FileServiceImpl.class);
}
