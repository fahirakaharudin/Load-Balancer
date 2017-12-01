import java.io.*;
import java.net.*;

public class lb{
	public static void main(String []args)throws IOException{
	ServerSocket s1 = new ServerSocket(1234);
	while(true){
		Socket connectionsocket = s1.accept();
		BufferedReader messagefromclient = new BufferedReader(new InputStreamReader(connectionsocket.getInputStream()));
		String clientsentence = messagefromclient.readLine();

	if(clientsentence.contains("Male")){
	Socket server = new Socket("192.168.139.133",2345);
	DataOutputStream outtoserver = new DataOutputStream(server.getOutputStream());
	outtoserver.writeBytes(clientsentence+"\n");
	server.close();
	}

	else if(clientsentence.contains("Female")){
	Socket server2 = new Socket("192.168.139.130",2346);
	DataOutputStream outtoserver2 = new DataOutputStream(server2.getOutputStream());
	outtoserver2.writeBytes(clientsentence+"\n");
	server2.close();
	}

	else{System.out.println("Connection Error!!!");}
	}
	}
}
