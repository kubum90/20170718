package com.hanbit.gms.sevice;
import java.util.List;

import com.hanbit.gms.domain.MemberBean;
public interface MemberService {
	public String addMember(MemberBean member);
	public List<MemberBean> list(); //목록을 가져와서 보여주기
	public List<MemberBean> findByName(String name);
	public MemberBean findById(String id);
	public String count();
	public String modify(MemberBean member);
	public String remove(String id);
}
