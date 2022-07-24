package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ptithcm.entity.*;
import ptithcm.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BillingAddressService billingAddressService;

    @Autowired
    private ShippingAddressService shippingAddressService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/register.htm")
    public String registerCustomer(Model model) {
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();

        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("customer", customer);

        return "customer/registerCustomer";
    }

    @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, @RequestParam(name = "update", required = false) String update, @RequestParam(name = "oldUserId", required = false) Long oldUserId, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "customer/registerCustomer";
        }
        if (update != null && update.equalsIgnoreCase("update")) {
            String username = request.getSession().getAttribute("username").toString();
            Customer oldCustomer = customerService.findCustomerByUsername(username);

            billingAddressService.addBillingAddress(customer.getBillingAddress());
            shippingAddressService.addShippingAddress(customer.getShippingAddress());

            BillingAddress oldBillingAddress = oldCustomer.getBillingAddress();
            ShippingAddress oldShippingAddress = oldCustomer.getShippingAddress();

            oldCustomer.setBillingAddress(customer.getBillingAddress());
            oldCustomer.setShippingAddress(customer.getShippingAddress());

            if (!oldCustomer.getPassword().equals(customer.getPassword())
                    && customer.getPassword().length() != 0) {
                oldCustomer.setPassword(customer.getPassword());
            }
            oldCustomer.setCustomerEmailAddress(customer.getCustomerEmailAddress());
            oldCustomer.setCustomerName(customer.getCustomerName());
            oldCustomer.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());

            String error = customerService.updateCustomer(oldCustomer);
            if (error == null) {
                billingAddressService.removeBillingAddress(oldBillingAddress);
                shippingAddressService.removeShippingAddress(oldShippingAddress);
                model.addAttribute("message", "Register Successfully!");
                return "customer/success_page";
            } else {
                model.addAttribute("error", error);
                return "customer/registerCustomer";
            }

        } else {
            billingAddressService.addBillingAddress(customer.getBillingAddress());
            shippingAddressService.addShippingAddress(customer.getShippingAddress());
            customer.setEnabled(true);

            Authorities authorities = new Authorities();
            authorities.setAuthorityType("ROLE_USER");
            authorities.setUsername(customer.getUsername());

            authoritiesService.addAuthorities(authorities);

            Cart cart = new Cart();

            cart.setGrandTotal(0);

            cartService.addCart(cart);

            customer.setCart(cart);
            String error = customerService.addCustomer(customer);

            if (error == null) {
                autoLogin(customer, request);
                model.addAttribute("message", "Register Successfully!");
                return "customer/success_page";
            } else {
                model.addAttribute("error", error);
                return "customer/registerCustomer";
            }
        }
    }

    private void autoLogin(Customer customer, HttpServletRequest request) {
    }

    @RequestMapping("/customer/update.htm")
    public String customerUpdate() {
        return "customer/updateCustomer";
    }

    @RequestMapping(value = "/customer/update.htm", method = RequestMethod.POST)
    public String customerUpdatePost(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Customer customer = customerService.findCustomerByUsernameAndPassword(username, password);
        String currentUsername = request.getSession().getAttribute("username").toString();
        if (customer == null || !(username.equals(currentUsername))) {
            model.addAttribute("error", "Username or password invaild!");
            return "customer/updateCustomer";
        }
        model.addAttribute("customer", customer);
        model.addAttribute("update", "update");
        return "customer/registerCustomer";
    }
}
