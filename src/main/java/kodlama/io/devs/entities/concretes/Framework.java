package kodlama.io.devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="frameworks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Framework {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="frameworkName")
	private String frameworkName;
	
	@ManyToOne
	@JoinColumn(name="languageId")
	public ProgrammingLanguage programmingLanguage;
}
