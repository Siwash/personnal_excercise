package rpf.test;

public class Logs {
	volatile public int time;
	volatile public int CPU;
	volatile public int GPU=1;
	volatile public boolean isWait=false;
	synchronized public void CPUWork() {
		System.out.print("第"+ ++time+"秒");
		//System.out.println(CPU+"--"+GPU+"--"+isWait+"1");
		if ((CPU+8)-time*2>=10||isWait) {
			isWait=true;
			
			System.out.print(Thread.currentThread().getName()+"处理了："+(CPU)+"MB"+" 进入暂停状态--");
		}else {
			CPU+=8;
			System.out.print(Thread.currentThread().getName()+"处理了："+CPU+"MB--");
			
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	synchronized public void GPUWork() {
		GPU=time*2;
		//System.err.println(CPU+"--"+GPU+"--"+isWait+"2");
		System.out.println(Thread.currentThread().getName()+"处理了:"+GPU+"MB");
		if (CPU-GPU>=10) {
			//isWait=true;
			//System.err.println(CPU+"--"+GPU+"--"+isWait+"3");
		}
		if (isWait) {
			if (CPU-GPU<5) {
				isWait=false;
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
