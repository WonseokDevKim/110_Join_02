package com.feb.join.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.join.dao.MemberDao;
import com.feb.join.util.Sha512Encoder;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public int join(HashMap<String, String> params) {
		// 사용자가 입력한 비밀번호(평문)을 암호화
		String passwd = params.get("passwd");
		String encodeTxt = Sha512Encoder.getInstance().getSecurePassword(passwd);
		params.put("passwd", encodeTxt);
		return memberDao.join(params);
	}
}
