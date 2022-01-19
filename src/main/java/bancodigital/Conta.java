package bancodigital;

import java.util.List;

import cartao.Cartao;
import cliente.Cliente;
import cliente.Endereco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
abstract class Conta {
	
	protected Cliente cliente;
	protected Endereco endereco;
	protected Long numeroConta;
	protected String agencia;
	protected double saldo;
	protected Cartao cartao;
	protected List<Extrato> historico;
	
	public void depositar(double valor) {
		
	}
	
	public void extrato(Conta conta) {
		
	}
	
}
