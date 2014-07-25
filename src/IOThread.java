import java.net.Socket;
/**
 *该类是在没有线程池的时候每次一个socket到来的时候
 *直接new 该类直接运行，加入线程池之后，为了使得每个线程都运行起来
 *必须在run函数刚进入的时候就直接阻塞，当有任务socket到来的时候再次唤醒
 *所以该类就不实用了，新的线程池支持的是Thread2
 *
 */
public class IOThread extends Thread { // 扩展的线程类，IOThread.java
	private Socket socket; // 执行和客户端的通信协议
	private IOStrategy ios; // ios指向一个协议对象

	public IOThread(Socket socket, IOStrategy ios) {
		this.socket = socket;
		this.ios = ios;
	}

	public void run() {
		ios.service(socket); // 执行协议
	}
}
