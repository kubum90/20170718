package com.hanbit.gms.dao;
import java.util.List;

import com.hanbit.gms.domain.MemberBean;
public interface MemberDAO {
	public int insert(MemberBean bean);
	public List<MemberBean> selectAll(); 
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(String id);
	public int count();
	public int update(MemberBean member);
	public int delete(String id);
}
