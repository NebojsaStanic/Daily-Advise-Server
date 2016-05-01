import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviseServer {
	
	String[] adviseList = {"Take smaller bites", 
			"Go for the tight jeans. No they do NOT make you look fat.",
			"One word: inappropriate", 
			"Just for today, be honest. Tell your boss what you *really* think", 
			"You might want to rethink that haircut."};
			 
	public void go(){
		try{
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true){
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advise = getAdvice();
				writer.println(advise);
				writer.close();
				System.out.println(advise);
			}
			
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	private String getAdvice(){
		int random = (int) (Math.random()*adviseList.length);
		return adviseList[random];
	}
	
	public static void main(String[] args) {
		DailyAdviseServer server = new DailyAdviseServer();
		server.go();
	}
}
