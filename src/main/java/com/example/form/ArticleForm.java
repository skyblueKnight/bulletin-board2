package com.example.form;

import javax.validation.constraints.NotBlank;

/**
 * 記事投稿フォーム.
 * 
 * @author ayane.tanaka
 *
 */
public class ArticleForm {
	/**  投稿者名 */
	@NotBlank(message="名前を入力してください")
	private String name;
	/** 投稿内容 */
	@NotBlank(message="コメントを入力してください")
	private String content;
	
	@Override
	public String toString() {
		return "ArticleForm [name=" + name + ", content=" + content + "]";
	}

	//get&set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
