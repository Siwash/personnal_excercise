package utils;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.Authority;
/**
 * 
 * 
 * 
 * @author Mr.Fox
 * @version 1.0.0
 * <h1>根据权限表格式生成需要的对象集合</h1>
 * <p>权限表字段如下</p>
 * <table>
 * <tr>
 * 	<td>id（必须）</td>
 * 	<td>pId（必须）</td>
 * 	<td>name</td>
 * 	<td>等等字段</td>
 * </tr>
 * </table>
 * */
public class ActiveMenu {
	
		//获得所有满足条件的子菜单；
		/**
		 * <h1>说明：</h1>
		 * 递归获得与{@authority}匹配的权限集合；
		 * innerClass内部类保证变量隔离性
		 * 
		 * 
		 * */
		public List<Authority> getMenu(List<Authority> aList,Authority authority) {
			//内部类初始化变量
			class InnerClass{
				private List<Authority> filtList=new ArrayList<Authority>();
				
				private List<Authority> recursive(List<Authority> aList,Authority authority){
					if (filtList.size()==0) {
						filtList.add(authority);
					}
					for (int i = 0; i < aList.size(); i++) {
						//Authority auth=aList.get(i);
						if (aList.get(i).getpId().equals(authority.getAuthorityId())) {
							this.recursive(aList, aList.get(i));
							filtList.add(aList.get(i));	
						}
					}
					
					
					return filtList;
					
				}
			}
			InnerClass innerClass=new InnerClass();
			return innerClass.recursive(aList, authority);
		}
		//获得根节点
		public Object getRootNum(List<Authority> rootList) {
			boolean isRoot=true;
			Object rootNode = null;
			for (int i = 0; i < rootList.size(); i++) {
				for (int j = 0; j < rootList.size(); j++) {
					if (i!=j&&rootList.get(i).getpId().equals(rootList.get(j).getAuthorityId())) {
						isRoot=false;
					}
				}
				if (rootNode==null) {
					rootNode=isRoot? rootList.get(i):null;
				}
				isRoot=true;
			}
			return rootNode;
		}
}
