package it.dstech.gestione.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import it.dstech.gestione.model.Prodotto;
import it.dstech.gestione.service.ProdottoService;

@Controller
public class ProdottoController {
@Autowired ProdottoService prodottoService;

@RequestMapping("/")
public ModelAndView home() {
	List<Prodotto> listaProdotti = prodottoService.listAll();
	ModelAndView mav = new ModelAndView("home");
	mav.addObject("listaProdotti", listaProdotti);
	return mav;
}
@RequestMapping("/nuovo")
public String newCustomerForm(Map<String, Object> model) {
	Prodotto prodotto = new Prodotto();
	model.put("prodotto", prodotto);
	return "nuovo_prodotto";
}
@RequestMapping(value = "/salva", method = RequestMethod.POST)
public String saveCustomer(@ModelAttribute("customer") Prodotto prodotto) {
	prodottoService.save(prodotto);
	return "redirect:/";
}
@RequestMapping("/edit")
public ModelAndView editCustomerForm(@RequestParam long id) {
	ModelAndView mav = new ModelAndView("edit_prodotto");
	Prodotto prodotto = prodottoService.get(id);
	mav.addObject("prodotto", prodotto);
	
	return mav;
}
@RequestMapping("/elimina")
public String deleteCustomerForm(@RequestParam long id) {
	prodottoService.delete(id);
	return "redirect:/";		
}

}
