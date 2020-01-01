package com.shonny.backend.service;

import java.util.List;

import com.shonny.backend.model.ProviderDTO;


public interface IProviderService {
	public List<ProviderDTO> findProviders();

	public ProviderDTO findProviderById(Long id);

	public void deleteProvider(Long id);

	public ProviderDTO saveProvider(ProviderDTO providerDTO);
}
