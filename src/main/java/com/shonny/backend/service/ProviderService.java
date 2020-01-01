package com.shonny.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shonny.backend.entity.Provider;
import com.shonny.backend.model.ProviderDTO;
import com.shonny.backend.repository.IProviderRepository;

@Service
public class ProviderService implements IProviderService {
	
	@Autowired
	private IProviderRepository repository;
	
	@Override
	public List<ProviderDTO> findProviders() {
		Sort sortBy = Sort.by("name").ascending();
		List<Provider> providers = StreamSupport.stream(repository.findAll(sortBy).spliterator(), false)
			    .collect(Collectors.toList());
		return providers.parallelStream().map(Provider::toDTO).collect(Collectors.toList());	
	}

	@Override
	public ProviderDTO findProviderById(Long id) {
		Provider provider = repository.findById(id).orElse(null);
		if (provider == null) {
			return null;
		}
		return provider.toDTO();
	}

	@Override
	public void deleteProvider(Long id) {
		Provider provider = new Provider();
		provider.setId(id);
		repository.delete(provider);
	}

	@Override
	public ProviderDTO saveProvider(ProviderDTO providerDTO) {
		Provider provider = Provider.fromDTO(providerDTO);
		repository.save(provider);
		return provider.toDTO();
	}

}
