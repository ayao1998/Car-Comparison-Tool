import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Car {
	int year;
	String make, model, mpg, hp, weight, trans, engine, body_style, car_size;

	//, hwyMpg, cityMpg;

	public Car(int y, String m1, String m2, String mpg, String hp, String weight, String trans, String engine, String body_style, String car_size)
	{
		year = y;
		make = m1;
		model = m2;
		this.mpg = mpg;
		this.hp = hp;
		this.weight = weight;
		this.trans = trans;
		this.engine = engine;
		this.body_style = body_style;
		this.car_size = car_size;
		
	}
	
	public void setMake(String m) 
	{
		make = m;
	}
	
	
	public void setModel(String m) 
	{
		model = m;
	}
	
	public void setYear(int y)
	{
		year = y;
	}
	/*
	public void setHwyMpg(int hm)
	{
		hwyMpg = hm;
	}
	
	public void setCityMpg(int cm)
	{
		cityMpg = cm;
	}*/
	
	public String getMake() 
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void printCar()
	{
		System.out.println(year + " " + make + " " + model);
	}
	
	public JLabel printCarLabel()
	{
		JLabel car = new JLabel(year + " " + make + " " + model);
		return car;
	}
	
}
