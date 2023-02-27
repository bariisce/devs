package kodlama.io.devs.business.requests.frameworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DeleteFrameworkRequest {
	private int id;
	private String name;
}
