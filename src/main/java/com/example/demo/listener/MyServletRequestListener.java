package com.example.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("MyServletRequestListener.requestDestroyed()"); 
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("MyServletRequestListener.requestInitialized()"); 
	}

}
