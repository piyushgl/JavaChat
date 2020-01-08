import java.net.*;
import java.io.*;
class Udpserverp
{
	public static void main(String args[])
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(8000);
		byte data[]=new byte[100];
		DatagramPacket dp=new DatagramPacket(data,100);
		System.out.println("waiting");
		ds.receive(dp);
		System.out.println("received");
		byte recvd[]=dp.getData();
String str=new String(recvd);

		int len=dp.getLength();
		InetAddress ipe=dp.getAddress();
		int portc=dp.getPort();

		System.out.println(str);

		DatagramPacket dp1=new DatagramPacket(recvd,len,ipe,portc);
		ds.send(dp1);
	}
	catch(IOException e)
	{
		System.out.print(e);
	}
	}
}