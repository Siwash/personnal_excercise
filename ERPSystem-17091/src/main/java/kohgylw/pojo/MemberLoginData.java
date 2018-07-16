package kohgylw.pojo;

//用于根据cookie获取用户登录信息并封装发送至页面的模型
public class MemberLoginData {
	private String username;
	private String password;

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
}
