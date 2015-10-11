package metasite.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by paulius on 10/11/2015.
 */
@Component
public class Configuration {
	@Value("${output.folder.name}")
	public String outputFilesFolderName;

	@Value("${output.ag.file.name}")
	public String outputAGFileName;

	@Value("${output.hn.file.name}")
	public String outputHNFileName;

	@Value("${output.ou.file.name}")
	public String outputOUFileName;

	@Value("${output.vz.file.name}")
	public String outputVZFileName;
}
