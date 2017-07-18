package com.hanbit.gms.serviceImpl;

import java.util.List;

import com.hanbit.gms.daoImpl.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.sevice.MemberService;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl instance = new MemberServiceImpl();
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	private MemberServiceImpl() {}

	@Override
	public String addMember(MemberBean member) {
		return  MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public String count() {
		return String.valueOf(MemberDAOImpl.getInstance().count());
	}

	@Override
	public List<MemberBean> list() {
		return MemberDAOImpl.getInstance().selectAll();
	}

	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modify(MemberBean bean) {
		return MemberDAOImpl.getInstance().update(bean);
	}

	@Override
	public String remove(String deleteId) {
		return MemberDAOImpl.getInstance().delete(deleteId);
	}
}