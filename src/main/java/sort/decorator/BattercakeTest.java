package main.java.sort.decorator;

/**
 * @author lijiangtao
 * @description 测试装饰者模式
 * @date 2020/8/28
 */
public class BattercakeTest {

	public static void main(String[] args) {

		Battercake battercake;
		battercake = new BaseBattercake();

		battercake = new EggDecorator(battercake);

		battercake = new EggDecorator(battercake);

		battercake = new SuausageDecorator(battercake);

		System.out.println(battercake.getMsg()+"，总价："+battercake.getPrice());

	}

}