package bancodigital;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ContaCorrente extends Conta{
	
	private final String OPERADOR = "001";
	
	public void depositar(double valor) {
		
	}
	
	public void sacar(double valor) {
		
	}
	
	public void transferir(double valor, Conta conta) {
		
	}
	
	public void extrato(Conta conta) {
		
	}
}
