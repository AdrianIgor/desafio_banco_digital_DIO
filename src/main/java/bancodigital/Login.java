package bancodigital;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import bancodigital.print.MetodosPrint;

public class Login {
	
	public static void login() throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		String cpf = "";
		long numeroConta = 0L;
		
		while(true) {
			
			MetodosPrint.printLogin();
			
			try {
				
				System.out.print("CPF: ");
				cpf = scan.next();
				System.out.print("Número da conta: ");
				numeroConta = scan.nextLong();
				verificar(cpf, numeroConta);
				break;
				
			} catch(InputMismatchException ex) {
				
				System.err.println("Campos incorretos, tente novamente.");
				Thread.sleep(1000);
				Main.pularLinhas();
			
			}
		}
		
		
	}
	
	
	private static void verificar(String a, long n) throws InterruptedException {
		List<Conta> conta = new ArrayList<Conta>(new Listas().getContas());
		List<Conta> contaAux = new ArrayList<Conta>();
		for(Conta c : conta) {
			if(c.getCliente().getCpf().equals(a)&&c.getNumeroConta() == n) {
				contaAux.add(c);
			}
		}
		if(contaAux.get(0) != null) {
			MinhaConta.minhaConta(contaAux.get(0));
		} else {
			System.err.println("Conta não encontrada.");
			Thread.sleep(1000);
			Main.pularLinhas();
			login();
		}
	}
}
