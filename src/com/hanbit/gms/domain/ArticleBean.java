package com.hanbit.gms.domain;

import java.io.Serializable;

public class ArticleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id, title, content, regdate;
	private int article_Seq, hitCount;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getArticleSeq() {
		return article_Seq;
	}

	public void setArticleSeq(int article_Seq) {
		this.article_Seq = article_Seq;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	@Override
	public String toString() {
		return "ArticleBean [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", articleSeq=" + article_Seq + ", hitCount=" + hitCount + "]\n";
	}
}
