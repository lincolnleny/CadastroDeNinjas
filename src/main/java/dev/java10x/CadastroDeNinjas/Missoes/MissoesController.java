package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

	//GET - Manda um requisição para mostrar as missões (READ)
	@GetMapping("/listar")
	public String listarMissoes() {
		return "Listando todas as Missões";
	}

	//POST - Manda uma requisição para criar uma nova missão (CREATE)
	@PostMapping("/criar")
	public String criarMissao() {
		return "Criando Missão";
	}

	//PUT - Manda uma requisição para alterar uma missão (UPDATE)
	@PutMapping("/alterar")
	public String alterarMissao() {
		return "Missão alterada ";
	}

	//DELETE - Manda uma requisição para deletar uma missão (DELETE)
	@DeleteMapping("/deletar")
	public String deletarMissao() {
		return "Missão deletada com sucesso";
	}
}
