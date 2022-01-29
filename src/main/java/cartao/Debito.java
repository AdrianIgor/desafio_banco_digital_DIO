package cartao;

import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Debito {

	public final Condicao condicao = Condicao.VISTA;

	private String numero;
	private int cod;
	private String validade;

	public Debito(String numero, int cod, String validade) {
		this.numero = numero;
		this.cod = cod;
		this.validade = validade;
	}

	public static String gerarNumero() {

		return metodoGerar();

	}

	private static String metodoGerar() {
		long numero;
		
		numero = ThreadLocalRandom.current().nextLong(100000000000000L, 999999999999999L);
		
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
