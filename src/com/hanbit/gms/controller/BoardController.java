package com.hanbit.gms.controller;
import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Button;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.serviceImpl.ArticleServiceImpl;
import com.hanbit.gms.sevice.ArticleService;

public class BoardController {
	public static void main(String[] args) {
		ArticleBean bean = null;
		ArticleService service = new ArticleServiceImpl();
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
				JOptionPane.showMessageDialog(null, service.write(bean));
				break flag;
			case SELECT_ALL:
				JOptionPane.showMessageDialog(null, service.list());
				break flag;
			case SELECT_BY_ID:
				JOptionPane.showMessageDialog(null,service.findById(JOptionPane.showInputDialog("ID")));
				break flag;
			case SELECT_BY_SEQ:
				
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.count());
				break flag;
			case UPDATE:
				bean=new ArticleBean();
				bean.setContent(JOptionPane.showInputDialog("content"));
				bean.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("seq")));
				JOptionPane.showMessageDialog(null, service.modify(bean));
				break flag;
			case DEL:
				JOptionPane.showMessageDialog(null, service.remove(bean.getId()));
				break flag;
			}

		} while (true);
	}
}
