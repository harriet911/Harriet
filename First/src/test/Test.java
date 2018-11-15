package test;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;


import entity.Userinfo;
public class Test {
   
	public	static void main(String[] args) throws IllegalArgumentException,IllegalAccessException {
		Userinfo userinfo=new Userinfo();
		userinfo.setId(100);
		userinfo.setUsername("中国");
		userinfo.setPassword("大中国");
		
		List valueList=new ArrayList();
		
		String sql ="insert into ";
		sql=sql + userinfo.getClass().getSimpleName().toLowerCase();
		
		String colSql="";
		
		String valueSql="";
		
		Field[] fieldArray=userinfo.getClass().getDeclaredFields();
		for(int i=0;i<fieldArray.length;i++){
			Field eachField=fieldArray[i];
			eachField.setAccessible(true);
			String fieldName=eachField.getName();
			colSql=colSql+","+fieldName;
			valueSql=valueSql+",?";
			Object value=fieldArray[i].get(userinfo);
			valueList.add(value);
			
			}
		colSql=colSql.substring(1);
		valueSql=valueSql.substring(1);
		colSql="("+colSql+")";
		valueSql="("+valueSql+")";
		sql=sql + colSql + " " + valueSql;
		System.out.println(sql);
		System.out.println();
		
		for(int i=0;i<valueList.size();i++) {
			Object value=valueList.get(i);
			System.out.println(value);
			
		}
		
	}
}
