package com.example.Common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class MyAnnotationClass {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		MyAnnotationClass myanno=new MyAnnotationClass();
		Method method = myanno.getClass().getMethod("myMethod");
		MyAnnotation m = method.getAnnotation(MyAnnotation.class);
		System.out.println(m.value1());
	}
	
	@MyAnnotation(value1=10)
	public void myMethod(){
		System.out.println("inside method myMethod");
	}
}


@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
@interface MyAnnotation {
	int value1();
}