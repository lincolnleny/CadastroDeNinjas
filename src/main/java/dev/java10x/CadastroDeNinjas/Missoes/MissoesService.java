package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

	private  MissoesRepository missoesRepository;
	private MissoesMapper missoesMapper;

	public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
		this.missoesRepository = missoesRepository;
		this.missoesMapper = missoesMapper;
	}

	// Implementar métodos de serviço para manipular missões

	//Criar Missão (CREATE)
	public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
		MissoesModel missoes = missoesMapper.map(missoesDTO);
		MissoesModel missoesSalvo = missoesRepository.save(missoes);
		return missoesMapper.map(missoesSalvo);
	}

	//Mostrar todas as missões (READ)
	public List<MissoesDTO> listarMissoes() {
		List<MissoesModel> missoes = missoesRepository.findAll();
		return missoes.stream()
				.map(missoesMapper::map)
				.collect(Collectors.toList());
	}
	//Mostrar missão por ID (READ)
	public MissoesDTO listarMissoesPorId(Long id) {
		Optional<MissoesModel> ninjaPorId = missoesRepository.findById(id);
		return ninjaPorId.map(missoesMapper::map).orElse(null);
	}

	//Deletar Missão por ID (DELETE)
	public void deletarMissaoPorId(Long id) {
		missoesRepository.deleteById(id);
	}

	//Atualizar Missão por ID (UPDATE)
	public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
		Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
		if (missaoExistente.isPresent()) {
			MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
			missaoAtualizada.setId(id);
			MissoesModel missaoSalvo = missoesRepository.save(missaoAtualizada);
			return missoesMapper.map(missaoSalvo);
		}
		return null; // Ou lançar uma exceção se preferir
	}
}


