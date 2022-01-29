package bancodigital;

import java.util.Scanner;

import bancodigital.print.MetodosPrint;

public class PagarContas {
	
	public static Scanner scan = new Scanner(System.in);
	private static String resposta;
	private static ContaCorrente contaAux;
	
	public static void pagarContas(Conta conta) throws InterruptedException {
		metodoPagarContas(conta);
	}
	
	private static void metodoPagarContas(Conta conta) throws InterruptedException {
		if (conta.getClass().getName().equals("bancodigital.ContaCorrente")) {

			MetodosPrint.printPagarContas();
			System.out.println("[Luz] para pagar a conta de luz.");
			System.out.println("[G�s] para pagar a conta de g�s.");
			System.out.println("[�gua] para pagar a conta de �gua.");

			resposta = scan.next();

			if (resposta.equalsIgnoreCase("Luz")) {

				contaAux = new ContaCorrente(conta.getCliente(), conta.getEndereco(), conta.getNumeroConta(),
						conta.getSaldo(), conta.getCartao(), conta.getHistorico());
				
				contaAux.transferir(500.00, null);
				
				conta = contaAux;
				
				new MinhaConta().minhaConta(conta);

			} else if (resposta.equalsIgnoreCase("G�s")) {

				contaAux = new ContaCorrente(conta.getCliente(), conta.getEndereco(), conta.getNumeroConta(),
						conta.getSaldo(), conta.getCartao(), conta.getHistorico());
				
				contaAux.transferir(100.00, null);
				
				conta = contaAux;
				
				new MinhaConta().minhaConta(conta);

			} else if (resposta.equalsIgnoreCase("�gua")) {

				contaAux = new ContaCorrente(conta.getCliente(), conta.getEndereco(), conta.getNumeroConta(),
						conta.getSaldo(), conta.getCartao(), conta.getHistorico());
				
				contaAux.transferir(200.00, null);
				
				conta = contaAux;

				new MinhaConta().minhaConta(conta);
			}

		} else {

			System.err.println("Op��o n�o permitida para conta poupan�a.");
			Thread.sleep(1000);
			Main.pularLinhas();

		}
	}

}
