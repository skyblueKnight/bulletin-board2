package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 掲示板画面へ遷移するコントローラ.
 * 
 * @author momoyo kanie
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	
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
		
		return "bulletin-board";
	}
	
}
