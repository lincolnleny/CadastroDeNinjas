package dev.java10x.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
		NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
	}

	//Mostrar todos Ninjas(READ)
	@GetMapping("/listar")
	public ResponseEntity <List<NinjaDTO>> listarNinjas() {
		List<NinjaDTO> ninjas = ninjaService.listarNinjas();
		return ResponseEntity.ok(ninjas);
	}

	//Mostrar Ninjas por ID (READ)
	@GetMapping("/listar/{id}")
	public ResponseEntity <?> listarNinjaPorId(@PathVariable Long id) {
		NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
		if (ninja != null) {
			return ResponseEntity.ok(ninja);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Ninja com ID " + id + " não existe nos registros.");
		}

	}

	//Alterar Ninja (UPDATE)
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
		NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, ninja);
		if (ninjaAtualizado != null) {
			return ResponseEntity.ok("Ninja atualizado com sucesso: " + ninjaAtualizado.getNome() + " (ID): " + ninjaAtualizado.getId());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Ninja com ID " + id + " não encontrado.");
		}
	}


	//Deletar Ninja (DELETE)
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

		if (ninjaService.listarNinjasPorId(id) != null) {
			ninjaService.deletarNinjaPorId(id);
			return ResponseEntity.ok("Ninja deletado ID " + id + " deletado com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Ninja com ID " + id + " não encontrado.");
		}
	}
}
