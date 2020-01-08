import java.net.*;
import java.io.*;
class Udpchatclient
{
	public static void main(String args[])
	{
		String str="";
		try
		{
			DatagramSocket ds=new DatagramSocket(7000);
			byte databuffer[]=new byte[100];
			DatagramPacket dp=new DatagramPacket(databuffer,100);
			Handler t=new Handler(ds);
			t.start();
			while(true)
			{
				ds.receive(dp);
				byte recv[]=dp.getData();
				str=new String(recv);
				System.out.println(str.trim());
				str="";
			}
		}
		catch(IOException e)
		{
			System.out.print(e);
		}
    }
}


class Handler extends Thread
{
	String str="";
	int i=0;
	DatagramSocket ds;
	Handler(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try
		{
			InetAddress ips=InetAddress.getLocalHost();
			while(true)
			{
				while(i!='\n')
				{
					i=System.in.read();
					str=str+(char)i;
				}
				i=0;
				byte data[]=str.getBytes();
				DatagramPacket dp=new DatagramPacket(data,str.length(),ips,8000);
				str="";
				ds.send(dp);
			}
		}
		catch(IOException e)
		{
			System.out.print(e);
		}
	}
}