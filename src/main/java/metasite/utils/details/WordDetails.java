package metasite.utils.details;

import java.io.Serializable;

/**
 * Created by paulius on 10/11/2015.
 */
public class WordDetails implements Serializable {
	private Integer id;
	private String value;
	private long count;

	private WordDetails(){}

	public WordDetails(Integer id, String value, long count){
		this.id = id;
		this.value = value;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
