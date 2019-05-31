package com.cultural.serviceimp;

import java.util.List;

import com.cultural.bean.ForbiddenBoard;
import com.cultural.bean.ModeratorAuthority;
import com.cultural.bean.UserAuthority;
import com.cultural.daoimp.AuthorityDao;

public class AuthorityService {
	private AuthorityDao authorityDao;

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
	public UserAuthority getUserAu(Integer userId){
		return authorityDao.getUserAu(userId);
	}
	public ModeratorAuthority getModertorAu(Integer userId) {
		System.out.println(authorityDao.getModertorAu(userId).getBoardManageAu());
		return authorityDao.getModertorAu(userId);
	}
	public void saveUserAu(UserAuthority userAuthority) {
		authorityDao.saveUserAu(userAuthority);
	}
	public void saveModeratorAu(ModeratorAuthority moderatorAuthority) {
		authorityDao.saveModeratorAu(moderatorAuthority);
	}
	public void saveForbiddeBoard(ForbiddenBoard forbiddenBoard) {
		authorityDao.saveForbiddenUser(forbiddenBoard);
	}
	public List<ForbiddenBoard> getForbiddenBoards(Integer userId) {
		return authorityDao.getForbiddenBoards(userId);
	}
}
