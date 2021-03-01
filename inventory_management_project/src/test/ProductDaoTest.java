package test;



import dao.ProductDAO;
import dto.ProductDTO;
import org.junit.Test;

import java.util.List;

public class ProductDaoTest {

    ProductDAO productDAO = new ProductDAO();

    @Test
    public void testGetProduct(){
        System.out.println("test");

        List<ProductDTO> productList = productDAO.getProduct();
        for(ProductDTO product : productList){

            System.out.println("ID : "+product.getId()+" Title: "+product.getTitle()+
                    " Price: " + product.getPrice()+ " Stock: " + product.getStock());
        }
    }

    @Test
    public void testInsertProduct(){

        ProductDTO product = new ProductDTO();
        product.setTitle("Test"+Math.random());
        product.setPrice(2000.07);
        product.setStock(345);


       productDAO.insert(product);
    }

    @Test
    public void testProductDelete(){

        productDAO.delete(999999999L);
    }

    @Test
    public void testProductUpdate(){

        ProductDTO product = new ProductDTO();
        product.setId(2L);
        product.setTitle("Test12"+Math.random());
        product.setPrice(2050.97);
        product.setStock(575);


        productDAO.update(product);
    }
}
