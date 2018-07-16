package tx.items;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor=Exception.class)
public class Inser {
		@Resource
		PersonMapper personMapper;
		public void insert() throws Exception {
			Person p1=new Person();
			p1.setName("喜洋洋");
			p1.setSex("公");
			Person p2=new Person();
			p2.setName("美洋洋");
			p2.setSex("母");
			Person p3=new Person();
			p3.setName("肥洋洋");
			p3.setSex("公");
			Person p4=new Person();
			p4.setName("懒洋洋");
			p4.setSex("公");
			List<Person> persons=new ArrayList<Person>();
			persons.add(p1);
			persons.add(p2);
			persons.add(p3);
			persons.add(p4);
			for(int i=0;i<persons.size();i++) {
				if (i==3) {
					//throw new Exception();
				}
				personMapper.insert(persons.get(i));
			}
		}
}
