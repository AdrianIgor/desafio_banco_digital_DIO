package cartao;

import java.util.concurrent.ThreadLocalRandom;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
public class Credito {
	
	private final double tarifaAnuidade = 300.00;
	private double tarifaSaque;
	private double tarifaPagarContas;
	private String numero;
	private int cod;
	private String validade;

	public Credito(String numero, int cod, String validade) {
		this.numero = numero;
		this.cod = cod;
		this.validade = validade;
		this.tarifaSaque = 0;
		this.tarifaPagarContas= 0;
	}
	
	public static String gerarNumero() {

		return metodoGerar();

	}

	private static String metodoGerar() {
		long numero;

		numero = ThreadLocalRandom.current().nextLong(1000000000000000L, 9999999999999999L);
		
		return String.valueOf(numero);
	}

	public static int gerarCodigo() {
		return metodoGerar2();
	}

	private static int metodoGerar2() {

		int numero = ThreadLocalRandom.current().nextInt(100, 999);
		
		return numero;

	}
	
}
