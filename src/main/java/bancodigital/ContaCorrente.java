package bancodigital;

import java.util.ArrayList;
import java.util.List;
import cartao.Cartao;
import cliente.Cliente;
import cliente.Endereco;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ContaCorrente extends Conta {

	private static List<Conta> contaAux;
	private static List<Extrato> extratoAux;
	
	public ContaCorrente(Cliente cliente, Endereco endereco, long numeroConta, double saldo, Cartao cartao,
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
		
		metodoSacar(valor);
	
	}

	private void metodoSacar(double valor) {

		if(this.getSaldo() - valor < 0) {
			System.err.println("Saque não permitido por saldo insuficiente.");
			return;
		}
		
		this.setSaldo(getSaldo() - valor);

		if (this.getCartao().getCartaoDebito() == null) {

			this.getCartao().getCartaoDeCredito()
					.setTarifaSaque(this.getCartao().getCartaoDeCredito().getTarifaSaque() + 2.00);

		}
	}

	public void transferir(double valor, Conta conta) {

		metodoTransferir(valor, conta);
	
	}

	private void metodoTransferir(double valor, Conta conta) {

		if(this.getSaldo() - valor < 0) {
			System.err.println("Transferência não permitida por saldo insuficiente.");
			return;
		}
		
		if (conta == null) {

			if (this.getCartao() == null || this.getCartao().getCartaoDeCredito() == null) {
				System.err.println("Sinto muito, só é possível pagar contas com o cartão de crédito.");
			} else {
				this.setSaldo(getSaldo() - valor);
				this.getCartao().getCartaoDeCredito()
						.setTarifaPagarContas(getCartao().getCartaoDeCredito().getTarifaPagarContas() + 10.00);
				extrato(null, valor);
			}

		} else {

			this.setSaldo(getSaldo() - valor);
			contaAux = new Listas().getContas();
			for (Conta c : contaAux) {
				if (c == conta) {
					c.setSaldo(getSaldo() + valor);
					Listas.setContas(contaAux);
				}
				
			}
			extrato(conta, valor);

		}
	}

	public void extrato(Conta conta, double valor) {

		if (conta == null) {
			try {
				extratoAux = this.getHistorico();
				extratoAux.add(new Extrato(valor, "", Condicao.RECEBE));
				this.setHistorico(extratoAux);
			} catch (NullPointerException ex) {
				extratoAux = new ArrayList<Extrato>();
				extratoAux.add(new Extrato(valor, "", Condicao.RECEBE));
				this.setHistorico(extratoAux);
			}

		} else {

			try {
				extratoAux = new ArrayList<Extrato>(this.getHistorico());
				extratoAux.add(new Extrato(valor, conta.getCliente().getNome(), Condicao.DEVE));
				this.setHistorico(extratoAux);
			} catch (NullPointerException ex) {
				extratoAux = new ArrayList<Extrato>();
				extratoAux.add(new Extrato(valor, conta.getCliente().getNome(), Condicao.DEVE));
				this.setHistorico(extratoAux);
			}
		}

	}
}
