package kohgylw.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


/*
 * 工具类：用于获取各种IP地址
 * */
@Component
public class GetNetMessageUtil {
	
	/*
	 * 功能：根据request获取到发送请求的IP地址
	 * */
	public String getIp(HttpServletRequest request) {
		String ipForward = request.getHeader("x-forwarded-for");
		String cIp=request.getHeader("Proxy-Client-IP");
		String Addrip=request.getRemoteAddr();
		String ip="NaN";
		if(ipForward==null) {
			if(cIp==null) {
				ip=Addrip;
			}else {
				ip=cIp;
			}
		}else {
			ip=ipForward;
		}
		return ip;
	}
	
	public String getLocalName() {
		try {
			InetAddress addr=InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return "获取主机名失败";
		}
	}
	
	public String getLocatAddress() {
		try {
			InetAddress addr=InetAddress.getLocalHost();
			return addr.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return "获取主机IP失败";
		}
	}

}
