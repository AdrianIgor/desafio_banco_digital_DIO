package cartao;


public class Debito extends Cartao implements MetodosConta{
	
	public final double limite = 10000.00d;
	public final Condicao condicao = Condicao.VISTA;
	
	public Debito(String numero, int cod, String validade) {
		super(numero, cod, validade);
	}
	
	public void parcelar(String conta, double valor, int vezes) {
		
	}

	public void pagarConta(String conta, double valor) {
		// TODO Auto-generated method stub
		
	}
	
}
