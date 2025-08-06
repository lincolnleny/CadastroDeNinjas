package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
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
	public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO) {
		return ninjaService.criarNinja(ninjaDTO);
	}

	//Mostrar todos Ninjas(READ)
	@GetMapping("/listar")
	public List<NinjaModel> listarNinjas() {
		return ninjaService.listarNinjas();
	}

	//Mostrar Ninjas por ID (READ)
	@GetMapping("/listar/{id}")
	public NinjaModel listarNinjasPorId(@PathVariable Long id) {
		return ninjaService.listarNinjasPorId(id);
	}

	//Alterar Ninja (UPDATE)
	@PutMapping("/alterarID")
	public String alterarNinjaPorId() {
		return "Alterar Ninja";
	}

	//Deletar Ninja (DELETE)
	@DeleteMapping("/deletar/{id}")
	public void deletarNinjaPorId(@PathVariable Long id) {
		ninjaService.deletarNinjaPorId(id);
	}



}
