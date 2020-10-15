package main.java.sort.decorator;

/**
 * @author lijiangtao
 * @description
 * @date 2020/8/27
 */
public class SuausageDecorator extends  BattercakeDecorator{

	public SuausageDecorator(Battercake battercake){
		super(battercake);
	}

	@Override
	protected void doSomething() {

	}

	@Override
	protected String getMsg() {
		return super.getMsg() + "加一根香肠";
	}

	@Override
	protected int getPrice() {
		return super.getPrice() + 2;
	}
}