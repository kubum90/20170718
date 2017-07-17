package com.hanbit.gms.daoImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO {
	public ArticleDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Load Fail");
			e.printStackTrace();
		}
	}
	@Override
	public int insert(ArticleBean bean) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement()
					.executeUpdate(String.format(
							"INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES(article_seq.nextval,'%s','%s','%s',0,SYSDATE)",
							DB.TABLE_BOARD, DB.ARTICLE_SEQ, DB.ARTICLE_ID, DB.ARTICLE_TITLE, DB.ARTICLE_CONTENT,
							DB.HIT_COUNT, DB.ARTICLE_REGDATE, bean.getId(), bean.getTitle(), bean.getContent()));
		} catch (SQLException e) {
			System.out.println("터짐");
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement()
					.executeQuery(String.format("SELECT * FROM %s", DB.TABLE_BOARD));
			while (rs.next()) {
				bean = new ArticleBean();
				bean.setArticleSeq(Integer.parseInt(rs.getString(DB.ARTICLE_SEQ)));
				bean.setId(rs.getString(DB.ARTICLE_ID));
				bean.setTitle(rs.getString(DB.ARTICLE_TITLE));
				bean.setContent(rs.getString(DB.ARTICLE_CONTENT));
				bean.setRegdate(rs.getString(DB.ARTICLE_REGDATE));
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("LIST 터짐");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement()
					.executeQuery(String.format("SELECT * FROM Board WHERE id='%s'",id));
			while (rs.next()) {
				bean = new ArticleBean();
				bean.setArticleSeq(Integer.parseInt(rs.getString(DB.ARTICLE_SEQ)));
				bean.setId(rs.getString(DB.ARTICLE_ID));
				bean.setTitle(rs.getString(DB.ARTICLE_TITLE));
				bean.setContent(rs.getString(DB.ARTICLE_CONTENT));
				bean.setRegdate(rs.getString(DB.ARTICLE_REGDATE));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean = new ArticleBean();
		if (seq.equals(bean.getArticleSeq())) {
			bean.toString();
		}
		return bean;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format(
					"SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_BOARD));
			if(rs.next()){
				count = Integer.parseInt(rs.getString("count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int update(ArticleBean bean) {
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(String.format(
					"UPDATE %s SET %s='%s' WHERE %s='%s'",
					DB.TABLE_BOARD,DB.ARTICLE_CONTENT,bean.getContent(),DB.ARTICLE_SEQ,bean.getArticleSeq()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(String seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
