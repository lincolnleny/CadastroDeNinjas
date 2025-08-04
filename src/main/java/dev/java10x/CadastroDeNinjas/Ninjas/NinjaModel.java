package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforma a classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(unique = true)
	private String email;

	@Column(name = "img_url")
	private String imgUrl;

	@Column(name = "idade")
	private int idade;

	//ManyToOne - indica que um ninja pode estar associado a uma unica missão
	@ManyToOne
	@JoinColumn(name = "missoes_id") // Foreign key para a tabela de missoes
	private MissoesModel missoes;


}
