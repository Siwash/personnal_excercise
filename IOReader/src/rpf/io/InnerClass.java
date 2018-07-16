package rpf.io;

import java.util.ArrayList;
import java.util.List;

class Test{
	public void m1() {
		class Inner2{
			List<Integer> list=new ArrayList<>();
			private List<Integer> M2() {
				list.add((int)(Math.random()*10));
				if (list.size()<10) {
					M2();
				}
				return list;
			}
		}
		Inner2 inner2=new Inner2();
		System.out.println(inner2.M2());
	}
}
public class InnerClass {
		public static void main(String[] args) {
			Test test=new Test();
			for(int i=0;i<40;i++)
			test.m1();
		}
	
}
