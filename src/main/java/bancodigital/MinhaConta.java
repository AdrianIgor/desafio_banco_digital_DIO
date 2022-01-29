package bancodigital;

import java.util.Scanner;
import bancodigital.print.MetodosPrint;

public class MinhaConta {

	private static String resposta = "";
	private static double valor;
	
	public static void minhaConta(Conta conta) throws InterruptedException {
		conta(conta);
	}

	private static void conta(Conta conta) throws InterruptedException {

		while (true) {

			Scanner scan = new Scanner(System.in);
			Main.pularLinhas();
			System.out.println("==============================================");
			System.out.println("    Bem-Vindo, " + conta.getCliente().getNome());
			System.out.println("==============================================");
			MetodosPrint.printMinhaConta();
			resposta = scan.next();

			if (resposta.equalsIgnoreCase("Depositar")) {

				MetodosPrint.printDepositar();
				System.out.print("Digite o valor: ");
				valor = scan.nextDouble();
				conta.depositar(valor);

			} else if (resposta.equalsIgnoreCase("Sacar")) {

				Sacar.saque(conta);

			} else if (resposta.equalsIgnoreCase("Transferir")) {

				Transferir.transferencia(conta);
				
			} else if (resposta.equalsIgnoreCase("Contas")) {

				if(conta.getClass().getName().equals("bancodigital.ContaCorrente")) {
					if(conta.getCartao() != null) {
						PagarContas.pagarContas(conta);
					} else {
						System.err.println("Não é possível pagar conta sem cartão.");
						Thread.sleep(1000);
						Main.pularLinhas();
					}
				} else {
					System.err.println("Opção não permitida para conta poupança.");
					Thread.sleep(1000);
					Main.pularLinhas();
				}
				

			} else if ((resposta.equalsIgnoreCase("Extrato"))) {

				if (conta.getHistorico() == null) {

					System.out.println("Nenhum extrato encontrado.");

				} else {

					MetodosPrint.printExtrato();
					for (Extrato ex : conta.getHistorico()) {
						System.out.println("==========================================");
						System.out.println("Nome da conta: " + ex.getConta());
						System.out.println("Situação: " + ex.getCondicao());
						System.out.println("Valor: " + ex.getSaldo());
						System.out.println("==========================================");
					}

				}

			} else if (resposta.equalsIgnoreCase("Dados")) {

				MetodosPrint.printDados();
				System.out.println("Nome: " + conta.getCliente().getNome());
				System.out.println("CPF: " + conta.getCliente().getCpf());
				System.out.println("Número da conta: " + conta.getNumeroConta());
				System.out.println("Tipo: " + conta.getClass().getName());
				System.out.println("Agência: " + conta.getAgencia());
				System.out.println("Saldo: " + conta.getSaldo());
				System.out.println("Rua: " + conta.getEndereco().getRua());
				System.out.println("Bairro: " + conta.getEndereco().getBairro());
				System.out.println("Complemento: " + conta.getEndereco().getComplemento());
				System.out.println("Cidade:" + conta.getEndereco().getCidade());
				System.out.println("Estado: " + conta.getEndereco().getEstado());
				System.out.println("CEP: " + conta.getEndereco().getCep());

				try {
					System.out.println("Cartão Débito: " + conta.getCartao().getCartaoDebito());
				} catch (NullPointerException ex) {
					System.out.println("Cartão Débito: Não Possui");
				}

				try {
					System.out.println("Cartão Crédito: " + conta.getCartao().getCartaoDeCredito());
				} catch (NullPointerException ex) {
					System.out.println("Cartão Crédito: Não Possui");
				}

			} else if (resposta.equalsIgnoreCase("Cartão")) {

				GerarCartao.gerarCartao(conta);

			} else if (resposta.equalsIgnoreCase("Sair")) {
				
				break;

			} else {
				
				System.err.println("Sinto muito, você deve digitar uma das opções que se encontram dentro das chaves.");
				Thread.sleep(1000);
				Main.pularLinhas();
				
			}
		}
	}
}
