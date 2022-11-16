package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;


@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookrepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookrepository.findAll();
		
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no")Long no, Model model) {
		model.addAttribute("no",no);
		return"/WEB-INF/views/delete.jsp";
		
	}
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no")Long no,@RequestParam(value="password",required=true,defaultValue="")String password) {
		guestbookrepository.deleteByNoAndPassword(no, password);
		return"redirect:/";
	
	}



	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookrepository.insert(vo);
		return"redirect:/";
	}



}
