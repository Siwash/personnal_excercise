package company.items.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import company.items.mapper.ZtreeMapper;
import company.items.model.Ztree;
import company.items.service.ZtreeService;
@Service
public class ZtreeServiceImpl implements ZtreeService {
	@Resource
	ZtreeMapper ztreeMapper;
	public String queryAllByJson() {
		List<Ztree> ztrees=ztreeMapper.queryAllZtree();
		Gson gson=new Gson();
		
		return gson.toJson(ztrees);
	}
	public String updataPidById(String id, String pid) {
		Map<String, Integer> tMap=new HashMap<String, Integer>();
		tMap.put("id", Integer.parseInt(id));
		tMap.put("pid", Integer.parseInt(pid));
		int r=ztreeMapper.updatePidById(tMap);
		if (r>0) {
			return "success";
		}else {
			return "erro";
		}
	}
	public String updataCheckById(String nodes) {
		Gson gson=new Gson();
		List<Ztree> ztrees= gson.fromJson(nodes,new TypeToken<List<Ztree>>(){}.getType());
		int result=0;
		for (int i = 0; i < ztrees.size();i++) {
		int j=ztreeMapper.updateByPrimaryKeySelective(ztrees.get(i));
		if (j>0) {
			result++;
			}	
		}
		if (result>=ztrees.size()) {
			return "修改成功";
		}else if (result>0&result!=ztrees.size()) {
			return "修改了："+result+"条数据";
		}else {
			return "修改失败";
		}
		
	}

}
