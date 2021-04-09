package com.shopable.controller;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopable.model.Userinformation;
import com.shopable.service.AddProduct;
import com.shopable.service.DisplayProducts;
import com.shopable.service.Shopping;
import com.shopable.service.VerifyCredentials;
import com.shopable.service.Wallet;
//controller class
@Controller
public class AppController {
	@Autowired
	VerifyCredentials verify;
	@Autowired
	DisplayProducts dispprod;
	@Autowired
	Shopping shop;
	@Autowired
	AddProduct ap;
	@Autowired
	Wallet wp;

	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String initialpage(ModelMap map) {
        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);
        map.addAttribute("currrenttimestamp",timestamp.toString());
       
        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);
        map.addAttribute("specifictime",specificTime.toString());
        return "login";
	}
	

	@PostMapping("/logincheck")
	public String validateUser(@ModelAttribute("user") Userinformation person, HttpServletRequest req, Model model)
			throws Exception {

		HttpSession ses = req.getSession();

		String uname = (verify.check(person.getUsername(), person.getPassword()));
		int len = uname.length();
		if (len != 0) {
			ses.setAttribute("name", uname);
			model.addAttribute("uname", uname);
			model.addAttribute("plist", dispprod.showall());
			return "welcome";
		} else {
			model.addAttribute("msg", "Invalid UserName or Password");
			return "login";
		}
	}

	@RequestMapping("/shopping")
	public String shoppingpage(HttpServletRequest req, Model model) {

		HttpSession ses = req.getSession();
		if(ses.getAttribute("name")==null) {
			return "login";
		}
		String name = ses.getAttribute("name").toString();

		model.addAttribute("ulist", shop.usercart(name));
		int total = ap.computetotal(name);
		model.addAttribute("carttotal", total);

		return "shop";

	}

	@PostMapping("add")
	public String addproduct(@RequestParam("productid") String id, @RequestParam("quantity") String quant,
			HttpServletRequest req, Model model) {
		int quantity = Integer.parseInt(quant);
		HttpSession ses = req.getSession();
		String uname = ses.getAttribute("name").toString();

		String message = ap.add(id, uname, quantity);
		model.addAttribute("msg", message);
		return "redirect:/shopping";
	}

	@RequestMapping("/deleteproduct")
	public String deleteproduct(String pid, HttpServletRequest req, Model model) {
		System.out.println("connected");
		HttpSession ses = req.getSession();
		String uname = ses.getAttribute("name").toString();

		String productid = req.getParameter("cid");
		System.out.println(productid);

		shop.deleteitem(uname, productid);
		model.addAttribute("msg", "Dleted succesfully");

		return "redirect:/shopping";
	}

	@RequestMapping("checkout")
	public String paymentpage(HttpServletRequest req, Model model) {

		HttpSession ses = req.getSession();
		if(ses.getAttribute("name")==null) {
			return "login";
		}
		String name = ses.getAttribute("name").toString();

		model.addAttribute("ulist", shop.usercart(name));

		int total = ap.computetotal(name);
		model.addAttribute("carttotal", total);

		int w_money = wp.getwallet(name);
		model.addAttribute("wallet", w_money);
		return "payment";

	}

	@RequestMapping("success")
	public String SuccessPage(HttpServletRequest req, Model model) {

		HttpSession ses = req.getSession();
		if(ses.getAttribute("name")==null) {
			return "login";
		}
		String uname = ses.getAttribute("name").toString();

		int bool = wp.computemoney(uname);
		if (bool == 1) {
			shop.deletecart(uname);
			return "success";
		} else if (bool == 0) {
			model.addAttribute("nomoney", "Uh-oh Not enough money");
			return "payment";
		} else {
			model.addAttribute("noitem", "No items in your cart");
			return "payment";
		}

	}

	@RequestMapping("new")
	public String againshop(HttpServletRequest req, Model model) {
		HttpSession ses = req.getSession();
		if(ses.getAttribute("name")==null) {
			return "login";
		}
		model.addAttribute("plist", dispprod.showall());
		return "welcome";
	}

	@RequestMapping("logout")
	public String Logout(HttpServletRequest req) {
		HttpSession ses = req.getSession();
		String uname = ses.getAttribute("name").toString();
		shop.deletecart(uname);
		ses.setAttribute("name", null);;
		return "thankyou";
	}

	@RequestMapping("register")
	public String registeruser() {
		return "register";
	}

	@RequestMapping("doregister")
	public String regsuccess(@ModelAttribute("user") Userinformation person, Model model) {
		verify.adduser(person);
		model.addAttribute("msg", "Registration successful");

		return "login";
	}
	

}
