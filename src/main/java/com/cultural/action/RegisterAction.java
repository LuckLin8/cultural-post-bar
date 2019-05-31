package com.cultural.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cultural.bean.User;
import com.cultural.bean.UserAuthority;
import com.cultural.serviceimp.AuthorityService;
import com.cultural.serviceimp.LoginService;
import com.cultural.serviceimp.RegisterService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private User user;
	private String username;
	private String password;
	private String repassword;
	private RegisterService registerService;
	private String checkCode;
	private LoginService loginService;
	private AuthorityService authorityService;
	
	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public String execute() {
		if (username.length()<=0||username.length()>=10) {
			this.addFieldError("username", "请输入0-10位用户名");
			return INPUT;
		}
		if (loginService.find(username)!=null) {
			this.addFieldError("username", "用户名已存在");
			return INPUT;
		}
		if (password.length()<=0||password.length()>=16) {
			this.addFieldError("password", "请输入0-16位密码");
			return INPUT;
		}
		if (!password.equals(repassword)) {
			this.addFieldError("password", "两次密码输入不一致");
			return INPUT;
		}
		user = new User(username,password, 1);
		ServletActionContext.getRequest().getSession().setAttribute("user", user);		
		registerService.save(user);
		user = loginService.find(username);
		UserAuthority userAuthority = new UserAuthority(user.getUserId(), "true", "true");
		authorityService.saveUserAu(userAuthority);
		return SUCCESS;
	}

	@Override
	public void validate() {
		HttpSession session = ServletActionContext.getRequest().getSession();

		String checkCode2 = (String) session.getAttribute("checkCode");

		if (!checkCode.equals(checkCode2)) {
			this.addActionError("输入的验证码不正确，请重新输入！");
		}
	}
}
