package rpf.test;

public class Test {
	public static void main(String[] args) {
		Logs logs=new Logs();
		Object object=new Object();
		CPU cpu=new CPU(logs,object);
		cpu.setName("处理器");
		GPU gpu=new GPU(logs,object);
		gpu.setName("显卡");
		cpu.start();
		gpu.start();
	}
}
