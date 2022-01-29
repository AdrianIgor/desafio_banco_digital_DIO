package bancodigital;

import java.util.Scanner;

import bancodigital.print.MetodosPrint;
import cartao.Cartao;
import cartao.Credito;
import cartao.Debito;

public class GerarCartao {

	public static Scanner scan = new Scanner(System.in);
	private static String resposta;
	
	public static void gerarCartao(Conta conta) throws InterruptedException {
		metodoGerarCartao(conta);
	}
	
	private static void metodoGerarCartao(Conta conta) throws InterruptedException {
		if (conta.getCartao() == null) {

			MetodosPrint.printCartao();
			MetodosPrint.escolhaPrint();

			resposta = scan.next();

			if (resposta.equalsIgnoreCase("Débito")) {

				conta.setCartao(
						new Cartao(null, new Debito(Debito.gerarNumero(), Debito.gerarCodigo(), "2026")));

			} else if (resposta.equalsIgnoreCase("Crédito")) {

				conta.setCartao(
						new Cartao(new Credito(Credito.gerarNumero(), Credito.gerarCodigo(), "2026"), null));

			} else {

				System.err.println("Você deve digitar uma das palavras que se encontram dentro das chaves.");

			}

		} else if (conta.getCartao().getCartaoDebito() != null) {

			conta.setCartao(
					new Cartao(new Credito(Credito.gerarNumero(), Credito.gerarCodigo(), "2026"), null));

		} else if (conta.getCartao().getCartaoDeCredito() != null) {

			conta.setCartao(new Cartao(null, new Debito(Debito.gerarNumero(), Debito.gerarCodigo(), "2026")));

		} else {

			System.err.println("Você possui os dois cartões.");
			Thread.sleep(1000);
			Main.pularLinhas();

		}
	}
	
}
