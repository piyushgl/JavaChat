import java.io.*;
import java.net.*;
class Servep extends Thread
{
	public void run()
	{
		ServerSocket ss;
				Socket s;
				OutputStream out;
				InputStream in;


				try
				{
					ss=new ServerSocket (7000);
		     	    System.out.println("waiting");
		    	    s=ss.accept();
		        	System.out.println("got client");
		        	out=s.getOutputStream();
		        	in=s.getInputStream();
		        	while(true)
		    		{
						int ch=0,i=0;
						String str="";
						while(ch!='\n')
						{
							ch=in.read();
							System.out.print((char)ch);
					    }
					    while(i!='\n')
					    {
							i=System.in.read();
			    	        str=str+(char)i;
						}
						out.write(str.getBytes());
					}
					//out.close();
			    	//in.close();
			        //s.close();
				}
				catch(IOException e)
				{
					System.out.println(e);
		}

}
}

class Chatp
{
	public static void main(String args[])
	{
		Servep obj=new Servep();
		obj.start();
		try
				{
					Socket s=new Socket("localhost",7000);
				    OutputStream out=s.getOutputStream();
			    	InputStream in=s.getInputStream();

			    	while(true)
			    	{
							int ch=0,i=0;
							String str="";
						while(i!='\n')
						{
							i=System.in.read();
					    	str=str+(char)i;
					    }
					    out.write(str.getBytes());
					    while(ch!='\n')
					    {
							ch=in.read();
							System.out.print((char)ch);
						}
					}
					//in.close();
					//out.close();
				    //s.close();
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
			}
}


