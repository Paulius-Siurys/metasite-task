package metasite.controllers;

import metasite.utils.details.WordDetails;
import metasite.utils.details.WordDetailsList;
import metasite.utils.enums.FirstLetterIntervalEnum;
import metasite.services.FileService;
import metasite.utils.RestUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
	    fileService.fileUpload(file);
    }

	@RequestMapping(value = RestUrl.wordList, method = RequestMethod.GET)
	@ResponseBody
	public WordDetailsList list(@PathVariable("firstLetterIntervalEnum") FirstLetterIntervalEnum firstLetterIntervalEnum, @PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
		return fileService.list(firstLetterIntervalEnum, page, pageSize);
	}
}
