package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	//Mostrar ninjas por ID (READ)
	public NinjaModel  listarNinjasPorId(Long id) {
		Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
		return ninjaPorId.orElse(null);

	}
}
