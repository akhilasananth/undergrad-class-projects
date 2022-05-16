package client;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
	private static ArrayList<Byte>rmsg;
	private static ArrayList<Byte>wmsg;
	private static ArrayList<Byte>errmsg;
	private static DatagramPacket sendPacket, receivePacket;
	private static DatagramSocket sendReceiveSocket;
	private static String fileName = "test.txt";
	private static String mode = "octet";
	private static int destPort = 68; //destination port address
	
	public Client() {
		//Formatting read request
		rmsg = new ArrayList<Byte>();
		rmsg.add((byte) 0b00);
		rmsg.add((byte) 0b01);
		for(byte b: fileName.getBytes()){
			rmsg.add(b);}
		rmsg.add((byte) 0b00);
		for(byte b: mode.getBytes()){
			rmsg.add(b);}
		rmsg.add((byte) 0b00);
		
		//Formatting write request
		wmsg = new ArrayList<Byte>();
		wmsg.add((byte) 0b00);
		wmsg.add((byte) 0b10);
		for(byte b: fileName.getBytes()){
			wmsg.add(b);}
		wmsg.add((byte) 0b00);
		for(byte b: mode.getBytes()){
			wmsg.add(b);}
		wmsg.add((byte) 0b00);
		
		//Formatting invalid request
		errmsg = new ArrayList<Byte>();
		errmsg.add((byte) 0b00);
		errmsg.add((byte) 0b101);
		for(byte b: fileName.getBytes()){
			errmsg.add(b);}
		errmsg.add((byte) 0b00);
		for(byte b: mode.getBytes()){
			errmsg.add(b);}
		errmsg.add((byte) 0b00);

	}//end of client constructor
	
	//Sends 11 Packets to the server by looping 11 times
	public void sendAndReceivePackets(){//Sends 11 datagram packets
		int packetCount = 0; //number of packets being sent to destination port
		while(packetCount<11){
			if(packetCount%2 == 0 && packetCount!=10){ //Write request is sent
				sendAndReceive(wmsg,"Write Request: ");
			}//end of write request
			else if(packetCount==10){//Packet #11 is an invalid request
				sendAndReceive(errmsg,"Invalid Request: ");
			}//end of invalid request
			else{//Read request is sent
				sendAndReceive(rmsg, "Read Request: ");
			}//end of read request
		
	      packetCount ++;
		}//end of while loop
	}//end of sendAndReceive()
	
	//This method initializes the sendreceive socket and handles the sending and receiving of 
	//the given message
	/**
	 * @param msg
	 * @param requestType
	 */
	private void sendAndReceive(ArrayList<Byte> msg, String requestType){
		
		try{
			sendReceiveSocket = new DatagramSocket();
		}//end of try block
		catch (SocketException se) {   // Can't create the socket.
	         se.printStackTrace();
	         System.exit(1);
	      }//end of catch block
		
		byte[] buffMsg = toByteArray(msg);
		
		//Construct Datagram packet that is being sent to destination port 
		 try {
	         sendPacket = new DatagramPacket(buffMsg, buffMsg.length,InetAddress.getLocalHost(), destPort);
	      } //end try block
		 catch (UnknownHostException e) { //If sendPacket is invalid
	         e.printStackTrace();
	         System.exit(1);
	      }//end catch block
		 System.out.println(requestType);
		 System.out.println("Client: Sending packet:");
	     System.out.println("To host: " + sendPacket.getAddress());
	     System.out.println("Destination host port: " + sendPacket.getPort());
	     int len = sendPacket.getLength();
	     System.out.println("Length: " + len);
	     System.out.println("Containing String: " + new String(sendPacket.getData(),0,len)); // prints info sent as String
	     System.out.println("Containing Bytes: " + Arrays.toString(sendPacket.getData()));
	     System.out.print("\n");
	     
	     //Send Datagram packet to server via sendRecieveSocket 
	     try {
	         sendReceiveSocket.send(sendPacket);
	      } //end try block
	     catch (IOException e) {
	         e.printStackTrace();
	         System.exit(1);
	      }//end catch block
	      System.out.println("Client: Packet sent.\n");
	      
	      //Construct Datagram packet for receiving packets
	      byte data[] = new byte[100];
	      receivePacket = new DatagramPacket(data, data.length);
	      try {
	          // Block until a datagram is received via sendReceiveSocket.  
	          sendReceiveSocket.receive(receivePacket);
	       } //end of try block
	      catch(IOException e) { //if receivePacket is invalid 
	          e.printStackTrace();
	          System.exit(1);
	       }//end of catch block
	      
	      //Process the received Datagram
	      System.out.println("Client: Packet received:");
	      System.out.println("From host: " + receivePacket.getAddress());
	      System.out.println("Host port: " + receivePacket.getPort());
	      len = receivePacket.getLength();
	      System.out.println("Length: " + len);
	      System.out.println("Containing String: "+ new String(data,0,len)); //prints info sent as String
		  System.out.println("Containing Bytes: " + Arrays.toString(receivePacket.getData()));
	      System.out.print("\n"); 
	    //Close sendReceiveSocket because we're done
	      sendReceiveSocket.close();
	}// end of sendAndReceive

	//Converts a Byte arraylist to a byte array
	/**
	 * @param msg
	 * @return
	 */
	private byte[] toByteArray(ArrayList<Byte> msg){
		
		byte bArray[] = new byte[msg.size()];
		for(int i=0; i<msg.size(); i++){
			bArray[i] = msg.get(i);
		}//end of for loop
		return bArray;
	}//end of toByteArray
	
//---------------------------------------------------------------------------------------------------------------	
	public static void main(String[] args){
		Client c = new Client();
		c.sendAndReceivePackets();
		
	}//end of main
}//end of client class
