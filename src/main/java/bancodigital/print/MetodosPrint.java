package bancodigital.print;

import bancodigital.Main;

public class MetodosPrint {
	
	public static void printInicio() {
		Main.pularLinhas();
		System.out.println("======================================");
		System.out.println("             Banco Digital            ");
		System.out.println("======================================");
		System.out.println("[Abrir] para abrir em uma conta no banco.");
		System.out.println("[Acessar] para entrar em uma conta no banco.");
		System.out.println("[Sair] para finalizar o programa.");
	}
	
	public static void printAbrirConta() {
		Main.pularLinhas();
		System.out.println("====================================");
		System.out.println("            Abrir Conta             ");
		System.out.println("====================================");
	}
	
	public static void printFim() {
		Main.pularLinhas();
		System.out.println("======================================");
		System.out.println("  Obrigado por utilizar meu programa  ");
		System.out.println("======================================");
	}
	
	public static void printLogin() {
		Main.pularLinhas();
		System.out.println("===============");
		System.out.println("     Login     ");
		System.out.println("===============");
	}
	
	public static void printMinhaConta() {
		System.out.println("[Depositar] para depositar seu dinheiro.");
		System.out.println("[Sacar] para sacar seu dinheiro.");
		System.out.println("[Transferir] para transferir seu dinheiro para outra conta.");
		System.out.println("[Contas] para pagar contas de forma rápida e fácil.");
		System.out.println("[Extrato] para ver seu historico de transferências.");
		System.out.println("[Dados] para ver seus dados da conta.");
		System.out.println("[Cartão] para criar um cartão em seu nome.");
		System.out.println("[Sair] para sair da conta.");
	}
	
	public static void printDepositar() {
		Main.pularLinhas();
		System.out.println("=============================");
		System.out.println("          Depositar          ");
		System.out.println("=============================");
	}
	
	public static void printSacar() {
		Main.pularLinhas();
		System.out.println("=========================");
		System.out.println("          Sacar          ");
		System.out.println("=========================");
	}
	
	public static void printTrasferir() {
		Main.pularLinhas();
		System.out.println("==============================");
		System.out.println("          Transferir          ");
		System.out.println("==============================");
	}
	
	public static void printPagarContas() {
		Main.pularLinhas();
		System.out.println("===============================");
		System.out.println("          Pagar Conta          ");
		System.out.println("===============================");
	}
	
	public static void printExtrato() {
		Main.pularLinhas();
		System.out.println("======================================");
		System.out.println("          Extratos Bancários          ");
		System.out.println("======================================");
	}
	
	public static void printDados() {
		Main.pularLinhas();
		System.out.println("==============================");
		System.out.println("          Seus Dados          ");
		System.out.println("==============================");
	}
	
	public static void printCartao() {
		Main.pularLinhas();
		System.out.println("================================");
		System.out.println("          Gerar Cartão          ");
		System.out.println("================================");
	}
	
	public static void escolhaPrint() {
		System.out.println("[Débito] para criar um cartão débito.");
		System.out.println("[Crédito] para criar um cartão crédito.");
	}
	
}
