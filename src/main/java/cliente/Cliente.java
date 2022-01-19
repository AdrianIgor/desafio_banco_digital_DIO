package cliente;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Cliente {
	private String nome;
	private String cpf;
	private Sexo sexo;
	private String dataNascimento;
}
