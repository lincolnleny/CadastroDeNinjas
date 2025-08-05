package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

	private NinjaService ninjaService;

	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}

	@GetMapping("/boasvindas")
	public String boasVindas() {
		return "Primeira rota Hello World do Java 10x!";
	}

	//Adicionar Ninja(CREAT)
	@PostMapping("/criar")
	public String adicionarNinja() {
		return "Criando Ninja";
	}
	//Mostrar todos Ninjas(READ)
	@GetMapping("/listar")
	public List<NinjaModel> listarNinjas() {
		return ninjaService.listarNinjas();
	}

	//Mostrar Ninjas por ID (READ)
	@GetMapping("/listarPorId")
	public List<NinjaModel> listarNinjasPorId() {
		return ninjaService.listarNinjasPorId();
	}

	//Alterar Ninja (UPDATE)
	@PutMapping("/alterarID")
	public String alterarNinjaPorId() {
		return "Alterar Ninja";
	}

	//Deletar Ninja (DELETE)
	@DeleteMapping("/deletarID")
	public String deletarNinjaPorId() {
		return "Ninja deletado por ID";
	}



}
