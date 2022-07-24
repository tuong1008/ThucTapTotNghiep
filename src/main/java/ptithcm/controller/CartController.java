package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.entity.Cart;
import ptithcm.entity.Customer;
import ptithcm.service.CustomerService;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(HttpServletRequest request) throws Exception {
        String activeUser = request.getSession().getAttribute("username").toString();
        Customer customer = customerService.findCustomerByUsername(activeUser);
        if (customer.getCart() == null) {
            Cart cart = new Cart();
            customer.setCart(cart);
            customerService.updateCustomer(customer);
            return "redirect:/customer/cart/" + cart.getCartId() + ".htm";
        } else {
            return "redirect:/customer/cart/" + customer.getCart().getCartId() + ".htm";
        }

    }

    @RequestMapping("/{cartId}.htm")
    public String getCartRedirect(@PathVariable(value = "cartId") long cartId, ModelMap model) {
        model.addAttribute("cartId", cartId);

        return "customer/cart";
    }
//		public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//				Exception ex) {
//			ModelAndView modelAndView=new ModelAndView();
//			CustomError error=new CustomError();
//
//
//			error.setMessage("Your request is not valid.Please Enter a valid request.");
//			modelAndView.addObject("customError", error);
//			modelAndView.setViewName("error_page");
//
//			return modelAndView;
//		}

}
