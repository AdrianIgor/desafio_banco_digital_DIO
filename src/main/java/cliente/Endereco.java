package cliente;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Endereco {
	private String rua;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
}
