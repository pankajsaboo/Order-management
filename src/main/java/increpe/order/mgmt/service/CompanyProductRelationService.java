package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.CompanyProduct;
import increpe.order.mgmt.repository.CompanyProductRepository;
import increpe.order.mgmt.security.dto.CompanyProductDto;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.mapper.CompanyMapper;

@Service
public class CompanyProductRelationService {

	@Autowired
	CompanyProductRepository companyProductRepository;
	
	public RegistrationResponse createRelation(CompanyProductDto companyProductDto) {
		
		CompanyProduct cProduct = CompanyMapper.INSTANCE.convertToCompanyProduct(companyProductDto);
		
		companyProductRepository.save(cProduct);
		
		return new RegistrationResponse("Product added successfully!");
	}
	
	public RegistrationResponse createRelation(List<CompanyProductDto> companyProductDtoList) {
		
		List<CompanyProduct> cProductList = CompanyMapper.INSTANCE.convertToCompanyProductList(companyProductDtoList);
		
		companyProductRepository.saveAll(cProductList);
		
		return new RegistrationResponse("Products added successfully!");
	}
	
	public List<CompanyProductDto> getByCustomerId(Long id) {
		
		return CompanyMapper.INSTANCE
								.convertToCompanyProductDtoList(companyProductRepository.findByBuyerCompanyId_id(id));
	}
	
	public List<CompanyProductDto> getByCompanyId(Long id) {
		
		return CompanyMapper.INSTANCE
								.convertToCompanyProductDtoList(
										companyProductRepository.findByProductId_CompanyId_Id(id));
	}
	
	public List<CompanyProductDto> getByBuyerCompanyId(Long id) {
		
		return CompanyMapper.INSTANCE
								.convertToCompanyProductDtoList(
										companyProductRepository.findByBuyerCompanyId_id(id));
	}
	
	public RegistrationResponse updateCompanyProductRelation (CompanyProductDto relationDto) {
		
		companyProductRepository.save(CompanyMapper.INSTANCE.convertToCompanyProduct(relationDto));
		
		return new RegistrationResponse("Product updated successfully!");
	}
	
	public boolean deleteCompanyProductRelation(Long relationId) {
		
		companyProductRepository.deleteById(relationId);
		
		return companyProductRepository.existsById(relationId);
	}
}
