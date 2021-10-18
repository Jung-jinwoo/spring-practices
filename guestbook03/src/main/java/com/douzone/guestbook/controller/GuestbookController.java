package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired(required=true)
	private GuestbookRepository guestbookRepository;

	@RequestMapping("")
	public String list(Model model) {
		/*
		 * if (session.getAttribute("authUser") == null) { return "/WEB-INF/views/"; }
		 */
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list",list);
		return "/WEB-INF/views/guestbook/list.jsp";
	}
	
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
	public String deleteform(@PathVariable Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/guestbook/deleteform.jsp";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	
}
