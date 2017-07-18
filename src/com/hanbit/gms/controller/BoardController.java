package com.hanbit.gms.controller;
import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Button;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.serviceImpl.ArticleServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		ArticleBean bean = null;
		Button[] buttons = { Button.EXIT, Button.INSERT, Button.SELECT_ALL, Button.SELECT_BY_ID, Button.SELECT_BY_SEQ, Button.COUNT,
				Button.UPDATE, Button.DEL };
		do {
			flag: switch ((Button) JOptionPane.showInputDialog(null, // frame
					"Board Management", // frame title
					"SELECT MENU", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1] // default) {
			)) {
			case EXIT:
				return;
			case INSERT:
				bean = new ArticleBean();
				bean.setId(JOptionPane.showInputDialog("ID?"));
				bean.setTitle(JOptionPane.showInputDialog("TITLE"));
				bean.setContent(JOptionPane.showInputDialog("Content"));
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().write(bean));
				break flag;
			case SELECT_ALL:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().list());
				break flag;
			case SELECT_BY_ID:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().findById(JOptionPane.showInputDialog("ID")));
				break flag;
			case SELECT_BY_SEQ:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findBySeq(JOptionPane.showInputDialog("seq입력")));
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().count());
				break flag;
			case UPDATE:
				bean=new ArticleBean();
				bean.setContent(JOptionPane.showInputDialog("content"));
				bean.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("seq")));
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().modify(bean));
				break flag;
			case DEL:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().remove(JOptionPane.showInputDialog("seq?")));
				break flag;
			}
		} while (true);
	}
}
