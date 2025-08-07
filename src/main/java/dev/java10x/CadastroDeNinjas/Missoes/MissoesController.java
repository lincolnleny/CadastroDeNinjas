package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

	private MissoesService missoesService;

	public MissoesController(MissoesService missoesService) {
		this.missoesService = missoesService;
	}

	//POST - Manda uma requisição para criar uma nova missão (CREATE)
	@PostMapping("/criar")
	public MissoesDTO criarMissao(@RequestBody MissoesDTO missoesDTO) {
		return missoesService.criarMissao(missoesDTO);
	}

	//GET - Manda um requisição para mostrar as missões (READ)
	@GetMapping("/listar")
	public List<MissoesDTO> listarMissoes() {
		return missoesService.listarMissoes();
	}

	//PUT - Manda uma requisição para alterar uma missão (UPDATE)
	@PutMapping("/alterar/{id}")
	public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizado) {
		return missoesService.atualizarMissao(id, missoesAtualizado);
	}

	//DELETE - Manda uma requisição para deletar uma missão (DELETE)
	@DeleteMapping("/deletar/{id}")
	public void deletarMissao(@PathVariable Long id) {
		missoesService.deletarMissaoPorId(id);
	}
}
