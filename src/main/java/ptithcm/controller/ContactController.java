package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ptithcm.entity.Customer;
import ptithcm.entity.Message;
import ptithcm.service.CustomerService;
import ptithcm.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class ContactController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageService messageService;

    @RequestMapping("/contact")
    public String contact(ModelMap model) {
        model.addAttribute("userMessage", new Message());

        return "customer/contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contact(HttpServletRequest request, @Valid @ModelAttribute("userMessage") Message message, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "customer/contact";
        }

        Customer c = (Customer) request.getSession().getAttribute("user");
        if (c != null) {
            message.setCustomer(c);
        }
        messageService.addMessage(message);
        return "redirect:/trang-chu.htm";
    }
}
