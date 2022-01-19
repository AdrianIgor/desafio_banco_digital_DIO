package cartao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Cartao {
	
	private String numero;
	private int cod;
	private String validade;
	
}
