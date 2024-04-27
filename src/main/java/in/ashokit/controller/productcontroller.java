package in.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.Entity.product;
import in.ashokit.Repository.productrepo;

@Controller
public class productcontroller {
	@Autowired
	private productrepo repo;
	
	@GetMapping("/edit")
	public String edit(@RequestParam("pid")Integer pid,Model model)
	{
		Optional<product> byId = repo.findById(pid);
		if(byId.isPresent())
		{
		product product = byId.get();
		model.addAttribute("product", product);
		}
		return "index";
	}
	
	@GetMapping("/delete")
public String deletedata(@RequestParam("pid")Integer pid,Model model)
{
	repo.deleteById(pid);
	model.addAttribute("msg","Product Deleted");
	model.addAttribute("products",repo.findAll());
	return "data";
}
	@GetMapping("/products")
	public String getallproducts(Model model)
	{
		List<product> list = repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}
	
	@PostMapping("/product")
	public String saveproduct(@Validated @ModelAttribute("product") product product,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "index";
		}
		in.ashokit.Entity.product p = repo.save(product);
		if(p.getPid()!=null)
		{
			model.addAttribute("msg","Product is saved in the cart");
		}
		
		return "index";
	}
	
	
	@GetMapping("/")
	public String loadform(Model model)
	{
	model.addAttribute("product",new product());
		return "index";
	}

}
