package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "our first spring application" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Object student1 = context.getBean("student1");
        System.out.println(student1);
    }
}