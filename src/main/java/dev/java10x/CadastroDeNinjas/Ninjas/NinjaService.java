package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	// Implementar métodos de serviço para manipular ninjas
	//Mostrar todos os ninjas (READ)
	public List<NinjaModel> listarNinjas() {
		return ninjaRepository.findAll();
	}

}
