public class CalcServer { // CalcServer.java，服务器主程序
	public static void main(String[] args) {
		new NwServer(4321, new ThreadSupport(new CalcProtocol()));
        //new CalcProtocol指明协议实现
	}
}
