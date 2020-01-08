import java.net.*;
import java.io.*;
class Udpclientp
{
	public static void main(String args [])
	{
		try
		{

		DatagramSocket ds=new DatagramSocket();
		String str="heoiii";
		byte[] data=str.getBytes();

		InetAddress ips=InetAddress.getLocalHost();
		DatagramPacket dp=new DatagramPacket(data,str.length(),ips,8000);
		ds.send(dp);
		ds.receive(dp);
		byte recv[]=dp.getData();
		String st=new String(recv);
		System.out.print(st);

	}
	catch(IOException e)
	{
		System.out.print(e);
	}
	}
}