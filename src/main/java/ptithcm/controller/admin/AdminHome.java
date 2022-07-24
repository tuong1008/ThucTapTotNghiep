package ptithcm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ptithcm.entity.*;
import ptithcm.exceptions.PageNotFoundException;
import ptithcm.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ShippingAddressService shippingAddressService;

    @Autowired
    private BillingAddressService billingAddressService;

    @Autowired
    private MessageService messageService;

    @Autowired
    Mailer mailer;

    @RequestMapping("/home.htm")
    public String adminPage() {
        return "admin/index";
    }


    @RequestMapping("/productManagement/{pageNumber}.htm")
    public String productManagement(@PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Product> page = productService.getAllProduct(pageNumber);
        long totalProducts = productService.getTotalProduct();

        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("products", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/productInventory";
    }

    @RequestMapping("/customerManagement/{pageNumber}.htm")
    public String customerManagement(@PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Customer> customers = customerService.getAllCustomers(pageNumber);
        long totalCustomers = customerService.getTotalCustomers();

        int totalPages = (int) Math.ceil(totalCustomers / 10.0); //mỗi page có 10 dòng
        if (totalCustomers == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("customers", customers);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/customerMgmt";
    }

    @RequestMapping(value = "/customerManagement/search/{pageNumber}.htm")
    public String customerManagementSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Customer> page = customerService.findAllCustomerByUsernameOrEmail(searchTerm, pageNumber);
        long totalProducts = customerService.getTotalCustomerByUsernameOrEmail(searchTerm);

        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("customers", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        model.addAttribute("search", searchTerm);
        return "admin/customerMgmt";
    }

    @RequestMapping("/customerManagement/address/{customerId}")
    public String customerShippingBillingAddress(@PathVariable("customerId") long customerId, ModelMap model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);

        return "admin/customerAddr";
    }

    @RequestMapping("/customerManagement/update/{customerId}")
    public String updateCustomer(@PathVariable("customerId") long customerId, ModelMap model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);

        return "admin/updateCustomer";
    }

    @RequestMapping(value = "/customerManagement/update/{customerId}", method = RequestMethod.POST)
    public String updateCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "admin/updateCustomer";
        }

        customerService.updateCustomer(customer);
        return "redirect:/admin/customerManagement/1.htm";
    }

    @RequestMapping("/customerManagement/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") long customerId, ModelMap model) throws PageNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            throw new PageNotFoundException("Customer doesn't exist");
        } else if (customerOrderService.getTotalOrderByCustomerId(customerId) == 0) {
            customerService.deleteCustomer(customer);
        } else {
            customer.setEnabled(false);
            customerService.updateCustomer(customer);
            model.addAttribute("message", "Delete successfully");
        }
        return "redirect:/admin/customerManagement/1.htm";
    }

    @RequestMapping("/customerOrder/{pageNumber}.htm")
    public String customerOrder(@PathVariable Integer pageNumber, ModelMap model) {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders(pageNumber);
        long totalCustomers = customerOrderService.getTotalCustomerOrders();

        int totalPages = (int) Math.ceil(totalCustomers / 10.0); //mỗi page có 10 dòng
        if (totalCustomers == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("orders", customerOrders);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/orderList";
    }

    @RequestMapping(value = "/customerOrder/search/{pageNumber}.htm", method = RequestMethod.POST)
    public String customerOrderSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<CustomerOrder> page = customerOrderService.findAllOrderByUsernameOrEmail(searchTerm, pageNumber);
        long totalProducts = customerOrderService.getTotalOrderByUsernameOrEmail(searchTerm);

        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("orders", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        model.addAttribute("search", "search");
        return "admin/orderList";
    }

    @RequestMapping("/customerOrder/deleteOrder/{customerOrderId}.htm")
    public String deleteCustomerOrder(@PathVariable("customerOrderId") long customerOrderId, ModelMap model) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);
        List<CartItem> listItem = customerOrder.getCart().getCartItem();

        for (CartItem item : listItem) {
            Product product = item.getProduct();
            product.setUnitInStock(product.getUnitInStock() + item.getQuantity());
            productService.updateProduct(product);
            cartItemService.deleteCartItem(item);
        }

        customerOrderService.removeCustomerOrder(customerOrder);
        cartService.removeCart(customerOrder.getCart());
        shippingAddressService.removeShippingAddress(customerOrder.getShippingAddress());
        billingAddressService.removeBillingAddress(customerOrder.getBillingAddress());

        return "redirect:/admin/customerOrder/1.htm";
    }

    @RequestMapping("/customerOrder/productList/{customerOrderId}.htm")
    public String getCustomerOrderProduct(@PathVariable("customerOrderId") long customerOrderId, ModelMap model) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);
        //List<CartItem> cartItems=customerOrder.getCart().getCartItems();
        model.addAttribute("order", customerOrder);

        return "admin/orderDetails";
    }

    @RequestMapping(value = "/productManagement/search/{pageNumber}.htm", method = RequestMethod.POST)
    public String productSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Product> page = productService.findAllProductByNameorCategory(searchTerm, pageNumber);
        long totalProducts = productService.getTotalProductByNameorCategory(searchTerm);

        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("products", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        model.addAttribute("search", "search");
        return "admin/productInventory";
    }

    @RequestMapping("/messages")
    public String customerMessage() {
        return "redirect:/admin/messages/1.htm";
    }

    @RequestMapping("/messages/{pageNumber}.htm")
    public String customerMessage(@PathVariable Integer pageNumber, ModelMap model) {
        List<Message> messages = messageService.getAllMessage(pageNumber);
        long total = messageService.getTotalMessages();

        int totalPages = (int) Math.ceil(total / 10.0);
        if (total == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("messages", messages);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/messages";
    }

    @RequestMapping("/messages/delete/{messageId}.htm")
    public String customerMessage(@PathVariable Long messageId, ModelMap model) {
        Message m = messageService.getMessageById(messageId);

        if (m == null) {
            model.addAttribute("error", "Delete failed.");
        } else {
            messageService.deleteMessage(m);
            model.addAttribute("message", "Delete successfully");
        }

        return "redirect:/admin/messages/1.htm";
    }

    @RequestMapping("/messages/mail.htm")
    public String send(ModelMap model, @RequestParam(name = "to") String to, @RequestParam(name = "body") String body) {
        try {
            mailer.send("NikeShopSupport", to, "Update to your NikeShop question", body);
            model.addAttribute("message", "Reply success.");
        } catch (Exception e) {
            model.addAttribute("message", "Fail to reply. Check if receiver's email is valid.");
        }
        return "admin/success";
    }
}
