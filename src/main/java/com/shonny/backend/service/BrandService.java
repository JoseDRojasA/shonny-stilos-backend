package com.shonny.backend.service;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

import com.shonny.backend.entity.Brand;
import com.shonny.backend.model.BrandDTO;
import com.shonny.backend.repository.IBrandRepository;

@Service
public class BrandService implements IBrandService {
	@Autowired
	private IBrandRepository repository;
	
	@Override
	public List<BrandDTO> findBrands(String sort, String order, Integer pageSize, Integer page, String search) {
		List<Brand> brands = null;

		if (sort == null) {
			Sort sortBy = Sort.by("name").ascending();
			brands = StreamSupport.stream(repository.findAll(sortBy).spliterator(), false)
				    .collect(Collectors.toList());
		} else {
			Sort sortBy = Sort.by(sort);
			if ("1".equals(order)) {
				sortBy.descending();
			}
			Pageable pageable = PageRequest.of(page, pageSize, sortBy);

			if (StringUtils.isEmpty(search)) {
				brands= repository.findAll(pageable).toList();
			} else {
				brands = repository.findAllByNameIgnoreCase(search, pageable);
			}
		}

		return brands.parallelStream().map(Brand::toDTO).collect(Collectors.toList());
	}
	
	

	@Override
	@Transactional
	public void deleteBrand(Integer id) {
		Brand brand = new Brand();
		brand.setId(id);
		repository.delete(brand);
	}

	@Override
	@Transactional
	public BrandDTO saveBrand(BrandDTO brandDTO) {
		Brand brand = Brand.fromDTO(brandDTO);
		repository.save(brand);
		return brand.toDTO();
	}



	@Override
	public BrandDTO findBrandById(Integer id) {
		Brand brand = repository.findById(id).orElse(null);
		if (brand != null) {
			return brand.toDTO();
		}
		return null;
	}

}
