package metasite.controllers;

import metasite.services.FileService;
import metasite.utils.RestUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by paulius on 10/5/2015.
 */
@Controller
public class FileController {

	@Autowired
	private FileService fileService;

    @RequestMapping(value = RestUrl.fileUpload, method = RequestMethod.POST)
    @ResponseBody
    public void fileUpload(@RequestParam("file") MultipartFile file) {
	    try {
		    fileService.fileUpload(file);
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
    }
}
