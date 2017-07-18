package com.hanbit.gms.dao;
import java.util.List;

import com.hanbit.gms.domain.MemberBean;
public interface MemberDAO {
	public String insert(MemberBean bean);
	public List<MemberBean> selectAll(); 
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(String id);
	public String count();
	public String update(MemberBean member);
	public String delete(String id);
}
