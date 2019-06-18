package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Comment;
import com.example.form.CommentForm;
import com.example.repository.CommentRepository;

@Controller
@RequestMapping("/insert-comment")
public class InsertCommentController {

	@Autowired
	private CommentRepository repository;

	/**
	 * コメントフォームのインスタンスを返す.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public CommentForm setUpForm() {
		return new CommentForm();
	}

	/**
	 * コメントを投稿（追加）する.<br>
	 * 追加後、掲示板ページに遷移する。
	 * 
	 * @param form  入力されたコメント
	 * @param model モデル
	 * @return 掲示板ページ
	 */
	@RequestMapping("/post-comment")
	public String postComment(@Validated CommentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorId", form.getArticleId());
			return "redirect:/";
		}
		Comment comment = new Comment();
		BeanUtils.copyProperties(form, comment);
		repository.insert(comment);

		return "redirect:/";
	}
}
