package metasite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by paulius on 10/10/2015.
 */
@Entity
@Table
public class Word implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String value;
	private long count;

	private Word(){};

	public Word(String value, long count) {
		this.value = value;
		this.count = count;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Column
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
}
