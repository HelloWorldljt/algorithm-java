package main.java.sort.decorator;

/**
 * @author lijiangtao
 * @description
 * @date 2020/8/27
 */
public class BaseBattercake extends Battercake{

	@Override
	public String getMsg() {
		return "煎饼";
	}

	@Override
	public int getPrice() {
		return 5;
	}
}