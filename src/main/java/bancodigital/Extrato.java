package bancodigital;

import lombok.Data;

@Data
public class Extrato {
	
	private double saldo;
	private String diaExtrato;
	private String conta;
	private Condicao condicao;
	
}
