package com.shonny.backend.service;

import java.util.List;

import com.shonny.backend.model.BrandDTO;

public interface IBrandService {
	List<BrandDTO> findBrands();

	void deleteBrand(Integer id);

	BrandDTO saveBrand(BrandDTO brand);

	BrandDTO findBrandById(Integer id);
}
