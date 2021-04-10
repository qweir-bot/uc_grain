package com.example.demo.DesignPattern.observe;

/**
 * 无法动态加入接入的第三方
 */
public class Client {
	public static void main(String[] args) {
		//创建接入方 currentConditions
		CurrentConditions currentConditions = new CurrentConditions();
		//创建 WeatherData 并将接入方 currentConditions 传入 WeatherData
		WeatherData weatherData = new WeatherData(currentConditions);
		
		//更新天气情况
		weatherData.setData(30, 150, 40);
		
		//天气情况变化
		System.out.println("============天气情况发生了变化=============");
		weatherData.setData(40, 160, 20);
		

	}
}
