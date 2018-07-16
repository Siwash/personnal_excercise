package rpf.test;

public class GPU extends Thread {
	private Logs logs;
	private Object object;
	public GPU(Logs logs,Object object) {
		this.object=object;
		this.logs = logs;
	}

	@Override
	public void run() {
		super.run();
		// TODO Auto-generated method stub
		while (true) {
			synchronized (logs) {
				logs.GPUWork();
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
