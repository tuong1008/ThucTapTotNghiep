package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ptithcm.entity.Cart;
import ptithcm.entity.CartItem;
import ptithcm.entity.Customer;
import ptithcm.entity.Product;
import ptithcm.service.CartItemService;
import ptithcm.service.CartService;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartItemController {

    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;
    @Autowired
    CartItemService cartItemService;
    //GET CART FOR REST SERVICE

    @RequestMapping(value = "/{cartId}.htm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getCartById(@PathVariable("cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        return cart;
    }
    //ADD PRODUCT IN THE CART

    @RequestMapping(value = "/add/{productId}.htm", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable("productId") int productId, HttpServletRequest request) {
        String activeUser = request.getSession().getAttribute("username").toString();
        Customer customer = customerService.findCustomerByUsername(activeUser);
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItem();

        double grandTotal = cart.getGrandTotal();
        //IF PRODUCT ALREADAY EXIST IN CART THEN INCREASE ITS QUANTITY

        for (int i = 0; i < cartItems.size(); i++) {
            if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                productService.updateProduct(product);
                cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
                cartItemService.updateCartItem(cartItem);
                grandTotal += product.getProductPrice();
                cart.setGrandTotal(grandTotal);
                cartService.updateCart(cart);
                return;
            }
        }
        //IF PRODUCT IS NEW
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        productService.updateProduct(product);
        cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);

        grandTotal += product.getProductPrice();
        cart.setGrandTotal(grandTotal);

        cartService.updateCart(cart);

    }

    //REMOVE A CARTITEM FROM CART
    @RequestMapping(value = "/remove/{cartItemId}.htm", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(@PathVariable("cartItemId") int cartItemId, HttpServletRequest request) {
        CartItem cartItem = cartItemService.findItemById(cartItemId);

        String activeUser = request.getSession().getAttribute("username").toString();
        Customer customer = customerService.findCustomerByUsername(activeUser);

        Cart cart = customer.getCart();
        double grandTotal = cart.getGrandTotal();
        grandTotal = grandTotal - cartItem.getTotalPrice();
        cart.setGrandTotal(grandTotal);

        cartService.updateCart(cart);
        cartItemService.deleteCartItem(cartItem);
    }


    //REMOVE CART/CLEAR CART
    @RequestMapping(value = "/{cartId}.htm", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void clearCart(HttpServletRequest request, @PathVariable(value = "cartId") int cartId) {
        String activeUser = request.getSession().getAttribute("username").toString();
        Customer customer = customerService.findCustomerByUsername(activeUser);


        Cart cart = customer.getCart();
        cart.setGrandTotal(0);

        cartService.updateCart(cart);
        cartItemService.removeAllCartItems(cartId);
    }
//
//	
//	//EXCEPTION HANDLING
//	
//	@ExceptionHandler(IllegalArgumentException.class)
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="")
//	public void handleClientErrors(Exception e){}
//	
//	
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Illegal request,please verify your payload")
//	public void handleServerErrors(Exception e){}
//	
//	
//	
//	
//	
//	
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		ModelAndView modelAndView=new ModelAndView();
//		CustomError error=new CustomError();
//	
//		if (ex instanceof IllegalArgumentException) {
//			
//			error.setMessage("Internal server error");
//			modelAndView.addObject("customError", error);
//			modelAndView.setViewName("error_page");
//			return  modelAndView;
//			
//		}
//		error.setMessage("Your request is not valid.Please Enter a valid request.");
//		modelAndView.addObject("customError", error);
//		modelAndView.setViewName("error_page");
//		
//		return modelAndView;
//	}
}
