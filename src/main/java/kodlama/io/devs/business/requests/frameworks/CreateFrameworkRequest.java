package kodlama.io.devs.business.requests.frameworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateFrameworkRequest {
	private String name;
	private int languageId;
}
