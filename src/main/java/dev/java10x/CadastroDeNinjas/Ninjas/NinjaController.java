package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

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
	@GetMapping("/todos")
	public String mostrarTodosNinjas() {
		return "Mostrando todos os Ninjas";
	}

	//Mostrar Ninjas por ID (READ)
	@GetMapping("/mostrarPorId")
	public String mostrarNinjaPorId() {
		return "Mostrando Ninja por ID";
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
