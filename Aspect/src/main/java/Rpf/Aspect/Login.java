package Rpf.Aspect;

import org.springframework.stereotype.Component;

@Component
public class Login {
	public String doLogin(int i) {
		System.err.println("login:"+i);
		return i>0? "登录成功":"登录失败";
	}
	
}
