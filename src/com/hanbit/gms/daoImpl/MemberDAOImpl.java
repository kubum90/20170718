package com.hanbit.gms.daoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.SQL;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;
public class MemberDAOImpl implements MemberDAO {
	public static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	private MemberDAOImpl(){}	

	@Override
	public String insert(MemberBean bean) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1,bean.getId());
			pstmt.setString(2,bean.getName());
			pstmt.setString(3,bean.getPassword());
			pstmt.setString(4,bean.getSsn());
			rs = String.valueOf(pstmt.executeUpdate());
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
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
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
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
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
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
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
	public String count() {
		int count=0;
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@Override
	public String update(MemberBean bean) {
		// TODO Auto-generated method stub
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, bean.getPassword());
			pstmt.setString(2, bean.getId());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String id) {
		String rs = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs =String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
