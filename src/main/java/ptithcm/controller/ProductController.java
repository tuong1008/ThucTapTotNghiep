package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ptithcm.entity.Product;
import ptithcm.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList/{productCategory}/{pageNumber}.htm")
    public String getProductByCategory(@PathVariable("pageNumber") int pageNumber, @PathVariable("productCategory") String productCategory, Model model) {
        List<Product> page = productService.getAllProductByCategoryInStock(productCategory, pageNumber);
        long totalProducts = productService.getTotalProductByCategoryInStock(productCategory);

        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) {
            totalPages = 1;
        }

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("products", page);
        model.addAttribute("productCategory", productCategory);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "customer/productList";
    }

    @RequestMapping(value = "/search/{pageNumber}.htm", method = RequestMethod.POST)
    public String productSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable Integer pageNumber, ModelMap model) {
        List<Product> page = productService.findAllProductByNameInStock(searchTerm, pageNumber);
        long totalProducts = productService.getTotalProductByNameInStock(searchTerm);


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
        return "customer/productList";
    }


    //
//	
//	
//	
//	@RequestMapping(value="/productList/{productCategory}/{pageNumber}",method=RequestMethod.POST)
//	public String getProductBySearch(@RequestParam("searchTerm")String searchTerm,@PathVariable("pageNumber")int pageNumber,@PathVariable("productCategory")String productCategory,Model model){
//		
//		
//		
//		Page<Product> page=productService.getAllProductByBrandOrModel(pageNumber, searchTerm, productCategory);
//		
//		List<Product> products=new ArrayList<>();
//		
//		for (Product product : page) {
//			products.add(product);
//		}
//		
//		if (products.size()==0) {
//			model.addAttribute("msg","No product to show");
//		}
//		
//		int currentPageNumber=page.getNumber()+1;
//		int beginIndex=Math.max(1, currentPageNumber-5);
//		int endIndex=Math.min(beginIndex+10, page.getTotalPages());
//		
//		
//		model.addAttribute("products",products);
//		model.addAttribute("productCategory",productCategory);
//		model.addAttribute("totalPages",page.getTotalPages());
//		model.addAttribute("currentPageNumber",currentPageNumber);
//		model.addAttribute("beginIndex",beginIndex);
//		model.addAttribute("endIndex",endIndex);
//		
//		
//		return "productList";
//	}
//	
//	
//	
//	
//	
//	
    @RequestMapping("/productList.htm")
    public String getAllProduct(ModelMap model) {
        int pageNumber = 1;
        List<Product> page = productService.getAllProductInStock(pageNumber);
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
        return "customer/productList";
    }

    @RequestMapping("/viewProduct/{productId}.htm")
    public String ProductDetailPage(@PathVariable("productId") long productId, Model model) {

        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "customer/productDetail";
    }
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		ModelAndView modelAndView=new ModelAndView();
//		CustomError error=new CustomError();
//	
//		
//		error.setMessage("Your request is not valid.Please Enter a valid request.");
//		modelAndView.addObject("customError", error);
//		modelAndView.setViewName("error_page");
//		
//		return modelAndView;
//	}
}
