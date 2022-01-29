package bancodigital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bancodigital.print.MetodosPrint;

public class Transferir {

	public static Scanner scan = new Scanner(System.in);
	private static long numeroConta;
	private static String resposta;
	private static Conta contaAux = null;
	private static List<Conta> consulta = new ArrayList<Conta>(new Listas().getContas());
	private static double valor;
	private static ContaCorrente contaAux2;
	
	public static void transferencia(Conta conta) throws InterruptedException {
		metodoTransferencia(conta);
	}
	
	private static void metodoTransferencia(Conta conta) throws InterruptedException {
		if (conta.getClass().getName().equals("bancodigital.ContaCorrente")) {

			MetodosPrint.printTrasferir();
			System.out.print("Digite o valor desejado para transferência: ");
			valor = scan.nextDouble();
			System.out.print("Digite o número da conta do recebedor: ");
			numeroConta = scan.nextLong();

			for (Conta c : consulta) {

				if (numeroConta == c.getNumeroConta()) {
					contaAux = c;
				}

			}

			if (contaAux != null) {

				System.out.println("Conta encontrada!");

				while (true) {

					System.out.println("Nome do recebedor: " + contaAux.getCliente().getNome());
					System.out.println("CPF: " + contaAux.getCliente().getCpf());
					System.out.println("Agência: " + contaAux.getAgencia());
					System.out.println("Tipo: " + contaAux.getClass());
					System.out.println("Nome do devedor: " + conta.getCliente().getNome());
					System.out.println("Valor a receber: " + valor);
					System.out.print("Continuar? S/N ");
					resposta = scan.next();

					if (resposta.equalsIgnoreCase("S")) {

						contaAux2 = new ContaCorrente(conta.getCliente(), conta.getEndereco(),
								conta.getNumeroConta(), conta.getSaldo(), conta.getCartao(),
								conta.getHistorico());
						
						contaAux2.transferir(valor, contaAux);
						
						conta = contaAux2;
						
						new MinhaConta().minhaConta(conta);
						
						break;

					} else if (resposta.equalsIgnoreCase("N")) {

						System.out.println("Redirecionando....");

					} else {

						System.err.println("Sinto muito, você deve digitar S ou N para continuarmos com o serviço.");

					}
				}

			} else {

				System.err.println("Conta não encontrada.");

			}

		} else {
			
			System.err.println("Opção não permitida para conta poupança.");
			
		}
	}
	
}
