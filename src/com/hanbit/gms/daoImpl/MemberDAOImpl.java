package com.hanbit.gms.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl(){
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Load Fail");
			e.printStackTrace();
		}
	}
	@Override
	public int insert(MemberBean member) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement()
					.executeUpdate(String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s',SYSDATE)",
							DB.TABLE_MEMBER, DB.MEMBER_ID, DB.MEMBER_NAME, DB.MEMBER_PASS, DB.MEMBER_SSN,
							DB.MEMBER_REGDATE, member.getId(), member.getName(), member.getPassword(),
							member.getSsn()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}
	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
			String.format("SELECT * FROM %s",DB.TABLE_MEMBER));
			MemberBean member=null;
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s WHERE %s = '%s'",DB.TABLE_MEMBER,DB.MEMBER_NAME,name));
			MemberBean bean = null;
			while(rs.next()){
				bean = new MemberBean();
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setName(rs.getString(DB.MEMBER_NAME));
				bean.setPassword(rs.getString(DB.MEMBER_PASS));
				bean.setSsn(rs.getString(DB.MEMBER_SSN));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("터짐");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Member WHERE id = '" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public int count() {
		Connection conn = null;
		int count=0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format(
					"SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_MEMBER));
			if (rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int update(MemberBean member) {
		// TODO Auto-generated method stub
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement()
					.executeUpdate(String.format("%s", ""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement()
					.executeUpdate(String.format("%s", ""));
			// rs = DriverManager.getConnection(Database.URL, Database.USERID,
			// Database.PASSWORD).createStatement().executeUpdate(String.format("%s",
			// ""));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

}
