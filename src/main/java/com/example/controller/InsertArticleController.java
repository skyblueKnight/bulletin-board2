package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;

/**
 * 記事を投稿するコントローラ.
 * 
 * @author ayane.tanaka
 *
 */
@Controller
@RequestMapping("/insertArticle")
public class InsertArticleController {
	
	@Autowired
	private IndexController indexController;
	
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
	 * 記事を投稿する.
	 * 
	 * @param form 投稿内容
	 * @param result　エラーチェック
	 * @param model　リクエストスコープ
	 * @return　記事一覧画面
	 */
	@RequestMapping("")
	public String articlePost(@Validated ArticleForm form ,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return indexController.index(model);
		}
		Article article=new Article();
		article.setName(form.getName());
		article.setContent(form.getContent());
		artrepository.insert(article);
		return "redirect:/";
	}

}
