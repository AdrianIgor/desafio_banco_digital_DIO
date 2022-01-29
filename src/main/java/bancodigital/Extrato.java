 package bancodigital;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Extrato {
	
	private double saldo;
	private String conta;
	private Condicao condicao;
	
}
