package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.facturacion.controllers.dto.ClientDTO;
import com.facturacion.controllers.dto.ItemSaleDTO;
import com.facturacion.controllers.dto.ProductDTO;
import com.facturacion.controllers.dto.SaleDTO;
import com.facturacion.models.entity.Client;
import com.facturacion.models.entity.SaleItem;
import com.facturacion.models.entity.Product;
import com.facturacion.models.entity.TimeApi;
import com.facturacion.models.entity.Sale;
import com.facturacion.repositories.ProductRepository;
import com.facturacion.repositories.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private TimeAPIService timeAPIService;


    // Metodo para crear venta
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = new Sale();
        
        // Obtener fecha Venta a traves de la Api
        TimeApi timeApi = timeAPIService.getCurrentDateTime();
        sale.setDateSale(timeApi.getDatetime());
        sale.setDateSale(timeAPIService.formatterDateTime(sale.getDateSale()));
        
        double totalSaleAmount = 0.0;
        
        // Obtener cliente
        ClientDTO clientDTO = saleDTO.getClient();
        Client client = new Client(clientDTO.getDni(), clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail(), clientDTO.getPhone(), clientDTO.getAddress());
        sale.setClient(client);
        saleDTO.setClient(clientDTO);
        
        List<ItemSaleDTO> itemsDTO = saleDTO.getItems();
        for (ItemSaleDTO itemDTO : itemsDTO) {
            // Obtener producto
            ProductDTO productDTO = productService.getProductDTOById(itemDTO.getProduct().getId());
            if (productDTO == null) {
                throw new RuntimeException("El producto con ID " + itemDTO.getProduct().getId() + " no existe");
            }
            
            // Verificar cantidad y stock disponible
            if (itemDTO.getQuantity() > productDTO.getStock()) {
                throw new RuntimeException("La cantidad de producto solicitada es mayor que el stock disponible");
            }
            
            // Actualizar stock del producto
            updateStock(productDTO.getId(), itemDTO.getQuantity());
            // Calcular monto total de la venta
            totalSaleAmount += productDTO.getPrice() * itemDTO.getQuantity();
            
            if (totalSaleAmount <= 0) {
                throw new RuntimeException("El monto total de la venta no es válido");
            }
            
            // Crear ItemVenta y almacenar los datos relevantes del producto en el momento de la venta
            SaleItem itemSale = new SaleItem();
            itemSale.setQuantity(itemDTO.getQuantity());
            itemSale.setProductId(productDTO.getId());
            itemSale.getCode(productDTO.getCode());
            itemSale.setCategory(productDTO.getCategory());
            itemSale.setBrand(productDTO.getBrand());
            itemSale.setName(productDTO.getName());
            itemSale.setDescription(productDTO.getDescription());
            itemSale.setSalePrice(productDTO.getPrice());
            itemSale.setStock(productDTO.getStock());
            itemSale.setPromotion(productDTO.isPromotion());
            
            // Asociar ItemVenta con Venta
            itemSale.setSale(sale);
            sale.getItems().add(itemSale);
        }
        
        //Obtener monto total de venta
        sale.setTotalPrice(totalSaleAmount);
        
        // Guardar la venta en la base de datos
        sale = saleRepository.save(sale);
        
        // Actualizar el ID de venta en el DTO
        saleDTO.setId(sale.getId());
        saleDTO.setDateSale(sale.getDateSale());
        saleDTO.setTotalSaleAmount(sale.getTotalPrice());
        
        return saleDTO;
    }
    
    
    public void updateStock(Integer productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }
    
    
    // Obtener todas las ventas
    public List<Sale> getAllSales (){
    	return saleRepository.findAll();
    }
    
    // Obtener lista de ventas por DNI de cliente
    public List<Sale> getSalesByClientDni(Integer clientDni) {
        return saleRepository.findByClientDni(clientDni);
    }
        
    // Obtener venta por id
    public Sale getSaleById(Integer id) {
			return saleRepository.findById(id).orElse(null);
	}

    // Eliminar venta por id
    public boolean deleteSaleById(Integer id) {
		try {
			saleRepository.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
    

}
