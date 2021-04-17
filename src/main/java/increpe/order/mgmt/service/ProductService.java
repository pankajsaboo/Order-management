package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.ProductMaster;
import increpe.order.mgmt.repository.ProductMasterRepository;
import increpe.order.mgmt.security.dto.ProductMasterDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;

@Service
public class ProductService {
	
	@Autowired
	ProductMasterRepository productRepository;
	
	public ProductMasterDto createProduct(ProductMasterDto productDto) {
		
		ProductMaster product = CompanyMapper.INSTANCE.convertToProductMaster(productDto);
		
		return CompanyMapper.INSTANCE.convertToProductMasterDto(productRepository.save(product));
	}
	
	public List<ProductMasterDto> getAllProducts(Long companyId) {
		
		return CompanyMapper.INSTANCE.convertToProductMasterDtoList(productRepository.findByCompanyId_id(companyId));
	}
	
	public List<ProductMasterDto> createProductList(List<ProductMasterDto> productList){
		
		List<ProductMaster> masterList = CompanyMapper.INSTANCE.convertToProductMasterList(productList);
		
		return CompanyMapper.INSTANCE.convertToProductMasterDtoList((List<ProductMaster>) productRepository.saveAll(masterList));
	}
	
	public ProductMasterDto updateProductDetails(ProductMasterDto updatedProduct) {
		
		return null;
	}
	
	public ProductMasterDto getSingleProduct(Long productId, Long traderId) {
		return CompanyMapper.INSTANCE.convertToProductMasterDto(productRepository.findByIdAndCompanyId_id(productId, traderId));
	}
	
	public boolean deleteProduct(ProductMasterDto productDto) {
		
		return false;
	}
	

}
