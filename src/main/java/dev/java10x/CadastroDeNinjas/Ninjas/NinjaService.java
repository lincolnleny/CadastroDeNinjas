package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public List<NinjaDTO> listarNinjas() {
		List<NinjaModel> ninjas = ninjaRepository.findAll();
		return ninjas.stream()
				.map(ninjaMapper::map)
				.collect(Collectors.toList());
	}

	//Mostrar ninjas por ID (READ)
	public NinjaDTO  listarNinjasPorId(Long id) {
		Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
		return ninjaPorId.map(ninjaMapper::map).orElse(null);
	}

	//Deletar Ninja por ID (DELETE)
	public void deletarNinjaPorId(Long id) {
		ninjaRepository.deleteById(id);
	}

	//Atualizar Ninja por ID (UPDATE)
	public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
		Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
		if (ninjaExistente.isPresent()) {
			NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
			ninjaAtualizado.setId(id);
			NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
			return ninjaMapper.map(ninjaSalvo);
		}
		return null; // Ou lançar uma exceção se preferir
	}
}
