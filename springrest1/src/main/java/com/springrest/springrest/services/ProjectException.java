package com.springrest.springrest.services;

public class ProjectException extends Exception 
{
	String exceptionText;
	public ProjectException(String exception) 
	{
		exceptionText=exception;
	}
	public String toString() 
	{
		return "Exception Message: "+exceptionText;
	}

}
