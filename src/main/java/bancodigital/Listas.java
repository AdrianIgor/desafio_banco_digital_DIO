package bancodigital;

import java.util.ArrayList;
import java.util.List;
import cliente.Cliente;
import cliente.Endereco;
import cliente.Sexo;

public class Listas {
	
	private static List<Conta> contas = new ArrayList<Conta>();
	
	public Listas() {
	contas.add(new ContaCorrente(new Cliente("Rafael_dos_Santos", "56732809812", Sexo.MASCULINO, "12/12/1999"),
			new Endereco("Rua_Gêmeos", "", "06515115", "Parque_Santana", "Santana_de_Parnaíba", "São_Paulo"),
			432325453L, 150.00, null, null));
	
	contas.add(new ContaPoupanca(new Cliente("Caio_Fereira", "97592584565", Sexo.MASCULINO, "31/01/1985"),
				new Endereco("Rua_Capricórnio", "", "06515110", "Parque_Santana", "Santana_d_ Parnaíba", "São_Paulo"),
				906748954L, 72.00, null, null));
	}

	public static List<Conta> getContas() {
		return contas;
	}

	public static void setContas(List<Conta> contas) {
		Listas.contas = contas;
	}
	
}
