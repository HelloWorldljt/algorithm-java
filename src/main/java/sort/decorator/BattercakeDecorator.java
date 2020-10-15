package main.java.sort.decorator;

/**
 * @author lijiangtao
 * @description
 * @date 2020/8/27
 */
public abstract class BattercakeDecorator extends Battercake{

	private Battercake battercake;

	public BattercakeDecorator(Battercake battercake){
		this.battercake = battercake;
	}

	protected abstract void doSomething();

	@Override
	protected String getMsg() {
		return this.battercake.getMsg();
	}

	@Override
	protected int getPrice() {
		return this.battercake.getPrice();
	}
}