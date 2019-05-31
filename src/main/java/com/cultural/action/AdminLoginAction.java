package com.cultural.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cultural.bean.ModeratorAuthority;
import com.cultural.bean.User;
import com.cultural.serviceimp.AuthorityService;
import com.cultural.serviceimp.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private LoginService loginService;
	private Map session;
	private AuthorityService authorityService;
	
	
	  public AuthorityService getAuthorityService() {
		return authorityService;
	}



	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public LoginService getLoginService() {
		return loginService;
	}



	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}



	public String adminLogin() {
			User user = loginService.find(username);
			if (password.equals(user.getPassword())&&user.getTypeId()>=2) {
				session.put("admin", user);
				if (user.getTypeId()==2) {
					ModeratorAuthority moderatorAuthority = authorityService.getModertorAu(user.getUserId());
					session.put("authority", moderatorAuthority);
					return "moderator";
				}
				if (user.getTypeId()==3) {					
					return "admin";
				}
			}
			this.addActionError("您没有权限或者您账号密码错误");
	    	return "login";	    	
		}

	public String adminLoginOut() {
		session.clear();
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
}
