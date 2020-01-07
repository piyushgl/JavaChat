import java.io.*;
import java.net.*;
class Chatclientp
{
	public static void main(String args[])
	{
		int ch=0,i=0;
		try
		{
			Socket s=new Socket("localhost",7000);
		    OutputStream out=s.getOutputStream();
	    	InputStream in=s.getInputStream();
	    	Chatthread t=new Chatthread(out);
            while(true)
            {
				while(ch!='\n')
				{
					ch=in.read();
					System.out.print((char)ch);
				}
				ch=0;
			}
		}
		catch(IOException e)
		{
			System.out.print(e);
		}
	}
}


class Chatthread extends Thread
{
	int i=0;
	OutputStream out;
	Chatthread(OutputStream out)
	{
		this.out=out;
		start();
	}
	public void run()
	{
		try
		{
			while(true)
			{
				i=System.in.read();
				if(i==-1)break;
				out.write(i);
			}
			//System.out.print("outside");
		}
	    catch(IOException e)
	    {
			System.out.print(e);
		}
	}

}


