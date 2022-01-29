package cartao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Cartao {
	
	Credito cartaoDeCredito;
	Debito cartaoDebito;
	
}
