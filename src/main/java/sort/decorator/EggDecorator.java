package main.java.sort.decorator;

/**
 * @author lijiangtao
 * @description
 * @date 2020/8/27
 */
public class EggDecorator extends  BattercakeDecorator{

	public EggDecorator(Battercake battercake){
		super(battercake);
	}

	@Override
	protected void doSomething() {

	}

	@Override
	protected String getMsg() {
		return super.getMsg() + "加一个鸡蛋";
	}

	@Override
	protected int getPrice() {
		return super.getPrice() + 1;
	}
}