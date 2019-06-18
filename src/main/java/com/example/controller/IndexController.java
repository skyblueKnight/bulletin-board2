package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;

/**
 * 掲示板画面へ遷移するコントローラ.
 * 
 * @author momoyo kanie
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private ArticleRepository artrepository;

	/**
	 * 記事投稿フォームの準備.
	 * 
	 * @return 記事投稿フォーム
	 */
	@ModelAttribute
	public ArticleForm setupArticleForm() {
		return new ArticleForm();
	}

	
	/**
	 * ※未完成です。記事一覧を取得する機能の追加をお願いします。
	 * 掲示板ページに遷移する.<br>
	 * 
	 * 
	 * @param model モデル
	 * @return 掲示板ページ
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList=artrepository.findAll();
		model.addAttribute("articleList",articleList);

		return "bulletin-board";
	}
	
}
