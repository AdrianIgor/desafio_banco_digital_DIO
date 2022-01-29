package bancodigital;

import java.util.Scanner;

import bancodigital.print.MetodosPrint;

public class Sacar {

	public static Scanner scan = new Scanner(System.in);
	private static Conta contaAux;
	
	public static void saque(Conta conta) throws InterruptedException {
		metodoSaque(conta);
	}
	
	private static void metodoSaque(Conta conta) throws InterruptedException {
		if (conta.getClass().getName().equals("bancodigital.ContaCorrente")) {
			
			MetodosPrint.printSacar();

			if (conta.getCartao() == null) {

				System.err.println("Não é possível sacar sem cartão");
				Thread.sleep(1000);
				Main.pularLinhas();

			} else {

				double valorSacar1;

				System.out.print("Valor do saque: ");
				valorSacar1 = scan.nextDouble();

				contaAux = new ContaCorrente(conta.getCliente(), conta.getEndereco(), conta.getNumeroConta(), conta.getSaldo(),
						conta.getCartao(), conta.getHistorico());
				
				contaAux.sacar(valorSacar1);
				
				conta = contaAux;

				new MinhaConta().minhaConta(conta);
			}

		} else {

			conta = new ContaPoupanca(conta.getCliente(), conta.getEndereco(), conta.getNumeroConta(), conta.getSaldo(),
					conta.getCartao(), conta.getHistorico());
			
			conta.sacar(0);
			
		}
	}
	
}
