package client;
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server {
	private static DatagramPacket sendPacket, receivePacket;
	private static DatagramSocket sendSocket, receiveSocket;
	private static byte[] receivedMsg;
	private static byte[] sendReadMsg = {0,3,0,1};
	private static byte[] sendWriteMsg = {0,4,0,0};
	
	public Server(){
		try{
			receiveSocket = new DatagramSocket(69); //port 69
		}//end of try block
		catch (SocketException se) {
	         se.printStackTrace();
	         System.exit(1);
	      } //end of catch block
	}//end of constructor
	
	public void sendAndReceive(){
		while(true){
			System.out.println("Server is running");
			//--------Server waits to receive a request from port 68--------
			
			//Construct Datagram packet for receiving packets
		      byte data[] = new byte[100];
		      receivePacket= new DatagramPacket(data, data.length);
		      try {
		          // Block until a datagram is received via sendReceiveSocket.  
		    	  receiveSocket.receive(receivePacket);
		       } //end of try block
		      catch(IOException e) { //if receivePacket is invalid 
		          e.printStackTrace();
		          System.exit(1);
		       }//end of catch block
		   
		      //Check if the packet received is valid
		      receivedMsg= receivePacket.getData();
		      int len = receivePacket.getLength();
		      if(validate(receivedMsg)){
		    	  System.out.println("The received packet is valid.");
		      }//end of valid check
		      else{
		    	  System.out.println("The received packet is invalid.So,quit.");
		    	  System.out.println("Containing string: "+ new String(data,0,len)); 
		    	  System.out.println("Containing bytes: "+ Arrays.toString(receivedMsg)); 
		    	  System.exit(1);
		      }//end of invalid check
		    
		      //Print info about the received datagram packet 
		      System.out.println("Client: Packet received:");
		      System.out.println("This is a(n)"+ checkReadOrWrite(receivedMsg) +" request.");
		      System.out.println("From host: " + receivePacket.getAddress());
		      System.out.println("Host port: " + receivePacket.getPort());
		      System.out.println("Length: " + len);
		      System.out.println("Containing String: "+ new String(data,0,len)); //prints info sent as String
			  System.out.println("Containing Bytes: " + Arrays.toString(receivePacket.getData()));
		      System.out.print("\n"); 
		      
		    //--------Server sends a response back --------
		      if(checkReadOrWrite(receivedMsg).equals("Read")){
		    	  sendBackMsg(sendReadMsg);
		      }//end of read response
		      else if(checkReadOrWrite(receivedMsg).equals("Write")){
		    	  sendBackMsg(sendWriteMsg);
		      }//end of write response
		      else{
		    	  System.out.println("Invalid request. Therefore, no response sent.");
		      }//end of no response
		}//end of while loop 
	}//end of sendAndReceive()
	
	//Parse through received packet to check if it's valid
	private boolean validate(byte[] info){
		   int zerosCount =0; //counts number of zeros in the packet received
		   boolean chk1=false,chk2=false,chk3=true,chk4=false;//checkpoints 
		   
		   if(info[0]==0){
			   chk1=true;
			   zerosCount++;
		   	}//end of zero count check
		   if(info[1]==1 || info[1]==2){//read or write request
			   chk2=true;
		   }// end of read or write check
		   for(int i=2; i<info.length; i++){
			   if(info[i]<32 && info[i]!=0){//In the ASCII table all characters range between 65 and 122 i.e. implies a string
				   chk3=false;
			   }//end of string check
			   if(info[i]==0){
				   zerosCount++;
			   }//end of statement that skips the middle zero
		   }
		   if(info[info.length-1]==0){//checks if there's nothing after 0 in the end
			   chk4=true;
		   }//end of last element check
		  return(chk1&&chk2&&chk3&&chk4&&zerosCount>=3); 
	}//end of validate
	
	//Checks if a message received is read or a write. The first element - "0" in the message is not checked 
	//in this method because the method validate already checks for it and it is called prior to this method
	/**
	 * @param info
	 * @return
	 */
	private String checkReadOrWrite(byte[] info){
		String status = "unchecked";
		if(info[1]==1){
			status = "Read";
		}// end of read
		else if(info[1]==2){
			status = "Write";
		}//end of write
		else{
			status = "Invalid";
		}//end of invalid
		return status;
	}//end of checkReadOrWrite
	
	//Sends message back to the Client 
	/**
	 * @param msg
	 */
	private void sendBackMsg(byte[] msg){
		try{
			sendSocket = new DatagramSocket();
		}//end of try block
		catch (SocketException se) {
	         se.printStackTrace();
	         System.exit(1);
	      } //end of catch block
		
		try {
	         sendPacket = new DatagramPacket(msg, msg.length,InetAddress.getLocalHost(), receivePacket.getPort());
	      } //end try block
		 catch (UnknownHostException e) { //If sendPacket is invalid
	         e.printStackTrace();
	         System.exit(1);
	      }//end catch block
	
		 System.out.println("Client: Sending packet:");
	     System.out.println("To host: " + sendPacket.getAddress());
	     System.out.println("Destination host port: " + sendPacket.getPort());
	     int len = sendPacket.getLength();
	     System.out.println("Length: " + len);
	     System.out.println("Containing String: " + new String(sendPacket.getData(),0,len)); // prints info sent as String
		 System.out.println("Containing Bytes: " + Arrays.toString(sendPacket.getData()));
	     System.out.print("\n");
	     
	     //Send Datagram packet 
	     try {
	         sendSocket.send(sendPacket);
	      } //end try block
	     catch (IOException e) {
	         e.printStackTrace();
	         System.exit(1);
	      }//end catch block
	      System.out.println("Client: Packet sent.\n");
	    //Close sendReceiveSocket because we're done
	      sendSocket.close();
	}//end of sendBackMsg
	
//---------------------------------------------------------------------------------------------------------------		
	public static void main(String[] args){
		Server serv = new Server();
		serv.sendAndReceive();
		
	}//end of main
}//end of server class
