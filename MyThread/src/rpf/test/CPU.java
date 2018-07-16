package rpf.test;


public class CPU extends Thread {
	private Logs logs;
	private Object object;
	public CPU(Logs logs,Object object) {
		super();
		this.logs = logs;
		this.object=object;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			synchronized (logs) {
				logs.CPUWork();
				try {
					//logs.notifyAll();
					logs.wait(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		}	
	}
}
