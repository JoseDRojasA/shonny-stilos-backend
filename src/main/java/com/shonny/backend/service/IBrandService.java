package com.shonny.backend.service;

import java.util.List;

import com.shonny.backend.model.BrandDTO;

public interface IBrandService {
	List<BrandDTO> findBrands(final String sort, final String order, final Integer pageSize, final Integer page, final String search);

	void deleteBrand(Integer id);

	BrandDTO saveBrand(BrandDTO brand);

	BrandDTO findBrandById(Integer id);
}
