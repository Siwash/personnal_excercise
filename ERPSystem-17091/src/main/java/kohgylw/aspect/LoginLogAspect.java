package kohgylw.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import kohgylw.mapper.SysMembermanageLoginlogMapper;
import kohgylw.model.SysMembermanageLoginlog;


/**
 * @author kohgylw
 * 
 * */
@Aspect
@Component
public class LoginLogAspect {
	
	@Resource
	private SysMembermanageLoginlogMapper smllm;
	/*
	 * 用于创建用户登录日志的切面
	 * */
	@After("execution(* kohgylw.service.impl.SysMemberInfoServiceImpl.determineLoginMember(..))")
	public void createLoginLogRow(JoinPoint point) {
		Object[] args=point.getArgs();
		String loginid="NaN";
		String ip="NaN";
		if(args.length>=4) {
			loginid=(String)args[0];
			ip=(String)args[3];
		}
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		SysMembermanageLoginlog smll=new SysMembermanageLoginlog();
		smll.setLoginlogDate(sdf.format(d));
		smll.setLoginlogId(UUID.randomUUID().toString());
		smll.setLoginlogIp(ip);
		smll.setMemberinfoId(loginid);
		smllm.insert(smll);
	}

	public SysMembermanageLoginlogMapper getSmllm() {
		return smllm;
	}

	public void setSmllm(SysMembermanageLoginlogMapper smllm) {
		this.smllm = smllm;
	}

}
