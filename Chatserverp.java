import java.io.*;
import java.net.*;
class Chatserverp
{
	public static void main(String args[])
	{
		ServerSocket ss;
		Socket s;
		OutputStream out;
		InputStream in;
		int ch=0;
		try
		{
			ss=new ServerSocket (7000);
			System.out.println("waiting");
            s=ss.accept();
			System.out.println("got client");
			out=s.getOutputStream();
			in=s.getInputStream();
			Chatthreads ct=new Chatthreads(out);
            ct.start();
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


 class Chatthreads extends Thread
 {
	 int i=0;
	 OutputStream out;
	 Chatthreads(OutputStream o)
	 {
		 out=o;

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
		  }
		  catch(IOException e)
		  {
			  System.out.print(e);
		  }
	 }
 }

