package metasite.controllers;

import metasite.utils.RestUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by paulius on 10/5/2015.
 */
@Controller
public class FileController {

	@RequestMapping(value = RestUrl.fileUpload, method = RequestMethod.POST)
	@ResponseBody
	public void fileInit() {
	}
}
