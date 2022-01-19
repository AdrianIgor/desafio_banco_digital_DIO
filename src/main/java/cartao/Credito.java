package cartao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Credito extends Cartao implements MetodosConta{
	
	public final double limite = 100000.00d;
	private double tarifaAnuidade;
	private double segundaVia;
	
	public Credito(String numero, int cod, String validade) {
		super(numero, cod, validade);
	}

	public void pagarConta(String conta, double valor) {
		// TODO Auto-generated method stub
		
	}
	
}
