package bancodigital;

import java.util.List;

import cartao.Cartao;
import cliente.Cliente;
import cliente.Endereco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
abstract class Conta {
	
	private Cliente cliente;
	private Endereco endereco;
	private long numeroConta;
	private final String agencia = "0012";
	private double saldo;
	private Cartao cartao;
	private List<Extrato> historico;
	
	public abstract void depositar(double valor);
	
	public abstract void sacar(double valor);
	
	protected abstract void metodoDepositar(double valor);
	
	public abstract void extrato(Conta conta, double valor);
	
}
