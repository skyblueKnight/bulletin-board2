package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;

@Controller
@RequestMapping("/deleteArticle")
public class DeleteArticleController {
	
	@Autowired
	private ArticleRepository artrepository;
	
	
	/**
	 * 指定されたidの記事とその記事へのコメントを削除する.
	 * 
	 * @param articleId 指定されたid
	 * @param model リクエストスコープ
	 * @return　記事一覧画面
	 */
	@RequestMapping("/articledelete")
	public String articleDelete(Integer articleId,Model model) {
		artrepository.deleteById(articleId);
		return "redirect:/";
	}

}
