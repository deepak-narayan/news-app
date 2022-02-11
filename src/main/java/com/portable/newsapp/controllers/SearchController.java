package com.portable.newsapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portable.newsapp.model.NewsApiResponse;
import com.portable.newsapp.service.GuardianNewsService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private GuardianNewsService guardianNewsService;
	
	@GetMapping
	public String index() {
		return "search/index";
	}

	@GetMapping(path="/query")
	public String searchArticle(@RequestParam("searchTerm") String term, @RequestParam("pageNo") Integer pageNo, Model model) {

		NewsApiResponse results = guardianNewsService.searchArticles(term, pageNo);
		
		model.addAttribute("apiResponse", results);
		model.addAttribute("articleList", results.getResults());
		return "search/articleList";
	}
}
