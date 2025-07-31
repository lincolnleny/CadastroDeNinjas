package dev.java10x.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

	@GetMapping("/boasvindas")
	public String boasVindas() {
		return "Primeira rota Hello World do Java 10x!";
	}

}
