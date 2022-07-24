package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.entity.Cart;
import ptithcm.entity.Customer;
import ptithcm.entity.CustomerOrder;
import ptithcm.entity.Product;
import ptithcm.exporter.OrderExcelExporter;
import ptithcm.service.CartService;
import ptithcm.service.CustomerOrderService;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CartService cartservice;

    @RequestMapping("/order/{cartId}.htm")
    public String createOrder(Model model, @PathVariable("cartId") long cartId, HttpServletRequest request) {

        Cart cart = cartService.getCartById(cartId);
        if (cart.getGrandTotal()==0){
            model.addAttribute("error", "Error! Cart is empty");
            return "customer/cart";
        }
        
        
        Product productMakeError = cartService.checkAndUpdateProductsInCart(cart);
        if (productMakeError == null) {
            CustomerOrder customerOrder = new CustomerOrder();

            customerOrder.setCart(cart);
            String username = request.getSession().getAttribute("username").toString();
            Customer customer = customerService.findCustomerByUsername(username);

            customerOrder.setTimeOrder(new Date(System.currentTimeMillis()));
            customerOrder.setCustomer(customer);
            customerOrder.setBillingAddress(customer.getBillingAddress());
            customerOrder.setShippingAddress(customer.getShippingAddress());
            customerOrderService.addCustomerOrder(customerOrder);
            //new cart after order successfully
            Cart newCart = new Cart();
            newCart.setGrandTotal(0);

            cartService.addCart(newCart);

            customer.setCart(newCart);
            customerService.updateCustomer(customer);

            model.addAttribute("message", "Order Successfully!");
            return "customer/success_page";
        } else {
            model.addAttribute("error", "Error! Unit in stock " + productMakeError.getProductName() + " is " + productMakeError.getUnitInStock());
            return "customer/cart";
        }
    }

    @RequestMapping("/order/excel.htm")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=orders_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<CustomerOrder> listOrders = customerOrderService.getAllCustomerOrder();

        OrderExcelExporter excelExporter = new OrderExcelExporter(listOrders);

        excelExporter.export(response);
    }
}
