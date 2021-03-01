package test;


import dao.SoldProductDAO;
import dto.SoldProductDTO;
import org.junit.Test;



import java.util.Date;
import java.util.List;


public class SoldProductDaoTest {

   SoldProductDAO soldProductDAO = new SoldProductDAO();

    @Test
    public void testGetSoldProduct(){
        System.out.println("test");

        List<SoldProductDTO> soldProductList = soldProductDAO.getSoldProduct();
        for(SoldProductDTO soldProduct : soldProductList){
            System.out.println("ID : "+soldProduct.getID()+" Product ID: "+soldProduct.getProduct_id()+
                    " Customer ID: " + soldProduct.getCustomer_id()+ " Sold Date: " + soldProduct.getSold_date());
        }
    }

    @Test
    public void testInsertSoldProduct(){

        SoldProductDTO soldProduct = new SoldProductDTO();
        soldProduct.setProduct_id(1L);
        soldProduct.setCustomer_id(5L);
        soldProduct.setSold_date(new Date());




       soldProductDAO.insert(soldProduct);
    }

    @Test
    public void testSoldProductDelete(){

      soldProductDAO.delete(8L);
    }

    @Test
    public void testSoldProductUpdate(){

        SoldProductDTO soldProduct = new SoldProductDTO();
        soldProduct.setID(1L);
        soldProduct.setProduct_id(3L);
        soldProduct.setCustomer_id(7L);
        soldProduct.setSold_date(new Date());



        soldProductDAO.update(soldProduct);
    }

}
