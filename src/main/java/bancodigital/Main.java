package bancodigital;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cliente.Cliente;
import cliente.Endereco;
import cliente.Sexo;
import bancodigital.print.MetodosPrint;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		inicio();
		System.exit(0);
	}

	public static void inicio() throws InterruptedException {

		String nome;
		String cpf;
		String sexo;
		String dataNascimento;
		String rua;
		String complemento;
		String bairro;
		String cidade;
		String estado;
		String pais;
		String cep;
		Sexo s = null;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		Scanner scan6 = new Scanner(System.in);

		while (true) {
			String resposta = "";
			MetodosPrint.printInicio();
			resposta = scan.next();

			if (resposta.equalsIgnoreCase("Abrir")) {
				MetodosPrint.printAbrirConta();

				System.out.println("Caso digite duas ou mais palavras, preencha os espaços com '_'.");
				
				System.out.print("Digite seu nome: ");
				nome = scan.next();

				System.out.print("Digite seu CPF: ");
				cpf = scan2.next();

				System.out.print("Digite seu sexo: [Masculino/Feminino] ");
				sexo = scan2.next();

				if (sexo.equalsIgnoreCase("Masculino")) {

					s = Sexo.MASCULINO;

				} else if (sexo.equalsIgnoreCase("Feminino")) {

					s = Sexo.FEMININO;

				}

				System.out.print("Digite sua data de nascimento [dd/mm/aaaa]: ");
				dataNascimento = scan2.next();
				System.out.print("Digite a rua de sua residência: ");
				rua = scan2.next();
				System.out.print("Digite o complemento de sua residência: ");
				complemento = scan3.next();
				System.out.print("Digite seu bairro: ");
				bairro = scan3.next();
				System.out.print("Digite sua cidade: ");
				cidade = scan4.next();
				System.out.print("Digite seu estado: ");
				estado = scan5.next();
				System.out.print("Digite o CEP de sua residência: ");
				cep = scan6.next();
				System.out.print("Digite o tipo da sua conta: [Corrente/Poupanca] ");
				resposta = scan6.next();

				
				if (resposta.equalsIgnoreCase("Corrente")) {
					List<Conta> listaAux = Listas.getContas();
					listaAux.add(new ContaCorrente(new Cliente(nome, cpf, s, dataNascimento),
							new Endereco(rua, complemento, cep, bairro, cidade, estado),
							MetodosBanco.numeroConta(), 0, null, null));
					Listas.setContas(listaAux);
				} else if (resposta.equalsIgnoreCase("Poupanca")) {

					List<Conta> listaAux = Listas.getContas();
					listaAux.add(new ContaPoupanca(new Cliente(nome, cpf, s, dataNascimento),
							new Endereco(rua, complemento, cep, bairro, cidade, estado),
							MetodosBanco.numeroConta(), 0, null, null));
					Listas.setContas(listaAux);

				} else {

					System.err.println("Sinto muito, você deve digitar o tipo de conta válido.");
					Thread.sleep(1000);
					pularLinhas();

				}
				

			} else if (resposta.equalsIgnoreCase("Acessar")) {
				Login.login();
			} else if (resposta.equalsIgnoreCase("Sair")) {
				break;
			} else if (resposta.equalsIgnoreCase("Lista")) {

				pularLinhas();
				List<Conta> contas = new Listas().getContas();
				
				for (Conta c : contas) {

					System.out.println("============================");
					System.out.println(c.getCliente().getNome());
					System.out.println(c.getCliente().getCpf());
					System.out.println(c.getNumeroConta());
					System.out.println(c.getSaldo());
					System.out.println(c.getClass().getName());
					System.out.println("============================");

				}

			} else {
				System.err.println("Sinto muito, você deve digitar uma das opções que se encontram dentro das chaves.");
				Thread.sleep(1000);
				pularLinhas();
			}
		}
		
		MetodosPrint.printFim();
		
		scan.close();
		scan2.close();
		scan3.close();
		scan4.close();
		scan5.close();
		scan6.close();
	}

	public static void pularLinhas() {
		for (int i = 0; i < 3; i++) {
			System.out.println("");
		}
	}
}
