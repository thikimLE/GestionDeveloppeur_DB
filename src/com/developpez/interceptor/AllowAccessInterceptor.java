package com.developpez.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AllowAccessInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;


	public void init(){
		System.out.println("dans la méthode init.......");
	}

	public String intercept(ActionInvocation arg0) throws Exception {


		System.out.println("dans la méthode intercept.......");

		Map<String, Object> session = arg0.getInvocationContext().getSession();

		
		if(session.get("allowAccess")==null)
		{
			return "allowAccess";
		}else
		{
			if (!session.isEmpty())
			{
				return arg0.invoke();
			}
			else
			{
				return "allowAccess";
			}
		}
	}


}
