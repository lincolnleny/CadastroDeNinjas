package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;
	private NinjaMapper ninjaMapper;

	public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
		this.ninjaRepository = ninjaRepository;
		this.ninjaMapper = ninjaMapper;
	}

// Implementar métodos de serviço para manipular ninjas

	//Criar Ninja (CREATE)
	public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
		NinjaModel ninja = ninjaMapper.map(ninjaDTO);
		ninjaRepository.save(ninja);
		return ninjaMapper.map(ninja);
	}


	//Mostrar todos os ninjas (READ)
	public List<NinjaModel> listarNinjas() {
		return ninjaRepository.findAll();
	}

	//Mostrar ninjas por ID (READ)
	public NinjaModel  listarNinjasPorId(Long id) {
		Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
		return ninjaPorId.orElse(null);

	}

	//Deletar Ninja por ID (DELETE)
	public void deletarNinjaPorId(Long id) {
		ninjaRepository.deleteById(id);
	}
}
