package test;

import dao.CustomerDAO;
import dto.CustomerDTO;
import org.junit.Test;


import java.util.Date;
import java.util.List;


public class CustomerDaoTest {

    CustomerDAO customerDAO = new CustomerDAO();

    @Test
    public void testGetCustomer(){
        System.out.println("test");

        List<CustomerDTO> customerList = customerDAO.getCustomer();
        for(CustomerDTO customer : customerList){
            System.out.println("ID : "+customer.getId()+" First Name : "+customer.getFirst_name()+
                    " Last Name: " + customer.getLast_name()+ " Email: " + customer.getEmail() +
                    " Birth Date" + customer.getBirth_date()+ " Phone: " + customer.getPhone());
        }
    }

    @Test
    public void testInsertCustomer(){

        CustomerDTO customer = new CustomerDTO();
        customer.setFirst_name("Mahmut Test"+Math.random());
        customer.setLast_name("Tek"+Math.random());
        customer.setPhone("5555556555");
        customer.setEmail("örek"+Math.random()+"@gmail.com");
        customer.setAdress("Sincan");
        customer.setBirth_date(new Date());

        customerDAO.insert(customer);
    }

    @Test
    public void testCustomerDelete(){

        customerDAO.delete(10L);
    }

    @Test
    public void testCustomerUpdate(){

        CustomerDTO customer = new CustomerDTO();
        customer.setId(2L);
        customer.setFirst_name("Tst"+Math.random());
        customer.setLast_name("Tst"+Math.random());
        customer.setPhone("5368146753");
        customer.setEmail("test@gmail.com");
        customer.setAdress("Yenimahalle");
        customer.setBirth_date(new Date());

        customerDAO.update(customer);
    }

}
