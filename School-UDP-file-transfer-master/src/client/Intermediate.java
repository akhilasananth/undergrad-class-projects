package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Intermediate {
	private static DatagramSocket receiveSocket;
	private static DatagramSocket sendReceiveSocket;
	private static DatagramSocket sendSocket;
	private static DatagramPacket requestPacket,sendRequestPacket;
	private static DatagramPacket responsePacket,sendResponsePacket;
	private static int destPort = 69; //destination port address
	
	public Intermediate(){
		try{
			receiveSocket = new DatagramSocket(68); //to receive at port 68
			sendReceiveSocket = new DatagramSocket();
		}//end of try block
		catch (SocketException se) {   // Can't create the socket.
	         se.printStackTrace();
	         System.exit(1);
	}//end of catch block
	}//end of constructor
	
	//Sends and receives datagrams from bothr the client and the server
	public void sendAndReceive(){
		while(true){
			System.out.println("Intermediate is running");
		//--------Host waits to receive a request from port 68--------
			
		//Construct Datagram packet for receiving packets
	      byte data[] = new byte[100];
	      requestPacket= new DatagramPacket(data, data.length);
	      try {
	          // Block until a datagram is received via sendReceiveSocket.  
	    	  receiveSocket.receive(requestPacket);
	       } //end of try block
	      catch(IOException e) { //if receivePacket is invalid 
	          e.printStackTrace();
	          System.exit(1);
	       }//end of catch block
	      
	      //Process the received Datagram
	      System.out.println("Client: Packet received:");
	      System.out.println("From host: " + requestPacket.getAddress());
	      System.out.println("Host port: " + requestPacket.getPort());
	      int len = requestPacket.getLength();
	      System.out.println("Length: " + len);
	      System.out.println("Containing String: "+ new String(data,0,len)); //prints info sent as String
		  System.out.println("Containing Bytes: " + Arrays.toString(requestPacket.getData()));
	      System.out.print("\n"); 
			
	    //--------Host sends request to port 69----------
	      
	    //Construct Datagram packet that is being sent to destination port 
			 try {
				 sendRequestPacket = new DatagramPacket(requestPacket.getData(),requestPacket.getData().length,InetAddress.getLocalHost(), destPort);
		      } //end try block
			 catch (UnknownHostException e) { //If sendPacket is invalid
		         e.printStackTrace();
		         System.exit(1);
		      }//end catch block
		
			 System.out.println("Client: Sending packet:");
		     System.out.println("To host: " + sendRequestPacket.getAddress());
		     System.out.println("Destination host port: " + sendRequestPacket.getPort());
		     len = sendRequestPacket.getLength();
		     System.out.println("Length: " + len);
		     System.out.println("Containing String: " + new String(sendRequestPacket.getData(),0,len)); // prints info sent as String
			 System.out.println("Containing Bytes: " + Arrays.toString(sendRequestPacket.getData()));
		     System.out.print("\n");
		     
		     //Send Datagram packet to server vis sendRecieveSocket 
		     try {
		         sendReceiveSocket.send(sendRequestPacket);
		      } //end try block
		     catch (IOException e) {
		         e.printStackTrace();
		         System.exit(1);
		      }//end catch block
		      System.out.println("Client: Packet sent.\n");
		      
		    //--------Host waits to receive a response from port 69--------
				
				//Construct Datagram packet for receiving packets
			      byte data1[] = new byte[100];
			      responsePacket = new DatagramPacket(data1, data1.length);
			      try {
			          // Block until a datagram is received via sendReceiveSocket.  
			          sendReceiveSocket.receive(responsePacket);
			       } //end of try block
			      catch(IOException e) { //if receivePacket is invalid 
			          e.printStackTrace();
			          System.exit(1);
			       }//end of catch block
			      
			      //Process the received Datagram
			      System.out.println("Client: Packet received:");
			      System.out.println("From host: " + responsePacket.getAddress());
			      System.out.println("Host port: " + responsePacket.getPort());
			      len = responsePacket.getLength();
			      System.out.println("Length: " + len);
			      System.out.print("Containing String: "+ new String(data,0,len)); //prints info sent as String
				  System.out.println("Containing Bytes: " + Arrays.toString(responsePacket.getData()));
			      System.out.print("\n"); 
					
			    //--------Host sends response to port 68----------
			      
			    //Construct Datagram packet that is being sent to destination port 
					 try {
						 sendResponsePacket = new DatagramPacket(responsePacket.getData(),responsePacket.getData().length,InetAddress.getLocalHost(),requestPacket.getPort());
				      } //end try block
					 catch (UnknownHostException e) { //If sendPacket is invalid
				         e.printStackTrace();
				         System.exit(1);
				      }//end catch block
					 
					 System.out.println("Client: Sending packet:");
				     System.out.println("To host: " + sendResponsePacket.getAddress());
				     System.out.println("Destination host port: " + sendResponsePacket.getPort());
				     len = sendResponsePacket.getLength();
				     System.out.println("Length: " + len);
				     System.out.println("Containing String: " + new String(sendResponsePacket.getData(),0,len)); // prints info sent as String
				     System.out.println("Containing Bytes: " + Arrays.toString(sendResponsePacket.getData()));
			         System.out.print("\n");
				     
				     //Send Datagram packet to server vis sendRecieveSocket 
				     try {
				    	 sendSocket = new DatagramSocket();
				         sendSocket.send(sendResponsePacket);
				      } //end try block
				     catch (IOException e) {
				         e.printStackTrace();
				         System.exit(1);
				      }//end catch block
		      
		}//end of while loop
	}//end of sendAndReceive
	
//---------------------------------------------------------------------------------------------------------------	
	public static void main(String[] args){
		Intermediate interm = new Intermediate();
		interm.sendAndReceive();
		
	}//end of main
}//end of Intermediate class
