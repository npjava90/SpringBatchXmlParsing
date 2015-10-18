package org.batch.mapper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class geMAC {

	
	public static void main(String[] args) {
	
		String str =GenarateMac();
		
		System.out.println("mac address is ..................."+str);
	}
	
	public static String GenarateMac()
	{
		System.out.println(System.getProperty("os.name").toString()); 
		String Osname = System.getProperty("os.name").toString();
		if(Osname.equalsIgnoreCase("Linux")) 
		{
			  StringBuilder sb = new StringBuilder();
			   try {
			    	Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			        while(networkInterfaces.hasMoreElements())
			        {
			            NetworkInterface network = networkInterfaces.nextElement();
			            byte[] mac = network.getHardwareAddress();
			            if(mac == null)
			            {
			            	 String msg = "Error Occured due to some problem with hardware of your system...!!!";
			                 //JOptionPane.showMessageDialog(null, msg, "Hardware error...!", JOptionPane.ERROR_MESSAGE);            
			            }
			            else
			            {
			                System.out.print("MAC address :");
			                for (int	 i = 0; i < mac.length; i++)
			                {
			                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));        
			                }
			                System.out.println("here:"+sb.toString());  
			                break;
			            }
			        }
			    } catch (SocketException e){
			      e.printStackTrace();
			    }
			   return sb.toString();
		}
		
		else
		{
			InetAddress ip;
		    try {
		    	ip = InetAddress.getLocalHost();
		        System.out.println("Current IP address : " + ip.getHostAddress());
		       NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		        byte[] mac = network.getHardwareAddress();

		        System.out.print("Current MAC address : ");

		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < mac.length; i++) {
		            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));        
		        }
		        System.out.println(sb.toString());
		        return sb.toString();

		    } catch (IOException e) {

		        e.printStackTrace();
		        return "";

		    }
		}
	}

}
