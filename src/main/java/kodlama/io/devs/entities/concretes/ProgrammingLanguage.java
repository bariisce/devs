package kodlama.io.devs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ProgrammingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name="languageName")
	private String languageName;
	@OneToMany(mappedBy = "programmingLanguage", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Framework> frameworks;
	
}
