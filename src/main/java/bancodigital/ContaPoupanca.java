package bancodigital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ContaPoupanca extends Conta{
	
	private final String OPERADOR = "013";
	
	public void depositar(double valor) {
		
	}
	
	public void extrato(Conta conta) {
		
	}
}
