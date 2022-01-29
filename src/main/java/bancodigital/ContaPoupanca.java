package bancodigital;

import java.util.ArrayList;
import java.util.List;

import cartao.Cartao;
import cliente.Cliente;
import cliente.Endereco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ContaPoupanca extends Conta {

	private static List<Extrato> extratoAux;
	
	public ContaPoupanca(Cliente cliente, Endereco endereco, Long numeroConta, double saldo, Cartao cartao,
			List<Extrato> historico) {

		super(cliente, endereco, numeroConta, saldo, cartao, historico);

	}

	public void depositar(double valor) {

		metodoDepositar(valor);

	}

	protected void metodoDepositar(double valor) {

		this.setSaldo(getSaldo() + valor);
		extrato(null, valor);

	}
	
	public void sacar(double valor) {
		System.err.println("Opção não permitida na conta poupança");
	}
	
	public void extrato(Conta conta, double valor) {

		try {
			extratoAux = this.getHistorico();
			extratoAux.add(new Extrato(valor, "", Condicao.RECEBE));
			this.setHistorico(extratoAux);
		} catch (NullPointerException ex) {
			extratoAux = new ArrayList<Extrato>();
			extratoAux.add(new Extrato(valor, "", Condicao.RECEBE));
			this.setHistorico(extratoAux);
		}
	}

	
}
