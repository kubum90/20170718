package com.hanbit.gms.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.daoImpl.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.sevice.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	ArticleBean bean;
	List<ArticleBean> list;
	Map<String, ArticleBean> map;
	int count;
	public ArticleServiceImpl() {
		bean = new ArticleBean();
		list = new ArrayList<>();
		map = new HashMap<>();
		count = 0;
	}
	@Override
	public String write(ArticleBean bean) {
		return (new ArticleDAOImpl().insert(bean)==1)?"Success":"Fail";
	}
	@Override
	public List<ArticleBean> list() {
		return new ArticleDAOImpl().selectAll();
	}
	@Override
	public List<ArticleBean> findByName(String name) {
		return new ArticleDAOImpl().selectById(name);
	}
	@Override
	public List<ArticleBean> findById(String id) {
		return new ArticleDAOImpl().selectById(id);
	}
	@Override
	public int count() {
		return new ArticleDAOImpl().count();
	}
	@Override
	public String modify(ArticleBean bean) {
		
		return (new ArticleDAOImpl().update(bean)==1)?"success":"fail";
	}

	@Override
	public String remove(String id) {
		String remove= "";
		
		return remove;
	}

}
