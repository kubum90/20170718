package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberBean bean = null;
		Butt[] buttons = { Butt.EXIT, Butt.ADD, Butt.LIST, Butt.FIND_NAME, 
				Butt.FIND_ID, Butt.COUNT, Butt.UPDATE, Butt.DEL };
		do {
			flag:
			switch ((Butt) JOptionPane.showInputDialog(null, // frame
					"MEMBER ADMIN", // frame title
					"SELECT MENU", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1] // default) {
					)){
			case EXIT:
				return;
			case ADD:
				// 회원가입
				bean = new MemberBean();
				bean.setId(JOptionPane.showInputDialog("id??"));
				bean.setName(JOptionPane.showInputDialog("name?"));
				bean.setPassword(JOptionPane.showInputDialog("pass??"));
				bean.setSsn(JOptionPane.showInputDialog("ssn??"));
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().addMember(bean));
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().list());
				break flag;
			case COUNT:
				// count
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().count());
				break flag;
			case FIND_ID:
				// find id
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findById(JOptionPane.showInputDialog("id")));
				break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findByName(JOptionPane.showInputDialog("name")));
				break flag;
			case UPDATE:
				bean = new MemberBean();
				String[] idPw = JOptionPane.showInputDialog("pass/id").split("/");
				bean.setPassword(idPw[0]);
				bean.setId(idPw[1]);
				MemberServiceImpl.getInstance().modify(bean);
				JOptionPane.showMessageDialog(null, "update complete");
				break flag;
			case DEL:
				String deleteId = JOptionPane.showInputDialog("삭제할 아이디 입력");
				MemberServiceImpl.getInstance().remove(deleteId);
				JOptionPane.showMessageDialog(null, "회원을 삭제했습니다.");
				break flag;
			}

		}while (true);
	}
}
