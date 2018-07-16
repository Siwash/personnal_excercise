package company.items.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import Utils.RandomChineseNameUtile;
import company.items.mapper.PeopleMapper;
import company.items.model.People;
import company.items.service.PeopleService;
@Service
public class PeopleServiceImpl implements PeopleService {
	@Resource
	PeopleMapper peopleMapper;
	private boolean sex=true;
	public String getPageJson(String n,String k) {
		int m=0;
		if (n!=null) {
			m=Integer.parseInt(n);
		}else {
			m=1;
		}
		m=(m-1)*(Integer.parseInt(k));
		List<People> pList=peopleMapper.queryPeopleByPager(m,Integer.parseInt(k));
		Gson gson=new Gson();
		return gson.toJson(pList);
	}
	public String addPeopleData(int n) {
		RandomChineseNameUtile rc=new RandomChineseNameUtile();
		List<People> plist=new ArrayList<People>();
		for (int i = 0; i < n; i++) {
			People p=new People();
			if (sex) {
				p.setSex("男");
				p.setName(rc.getRandomMaleName());
			}else {
				p.setSex("女");
				p.setName(rc.getRandomFemaleName());
			}
			p.setAge((int)(18+Math.random()*10));
			peopleMapper.insertSelective(p);
			sex=!sex;
			plist.add(p);
		}
		Gson gson=new Gson();
		return gson.toJson(plist);
	}
	@Override
	public int queryAllData() {
		
		return peopleMapper.queryAllData();
	}
	
}
