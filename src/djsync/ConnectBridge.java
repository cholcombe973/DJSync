package djsync;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class ConnectBridge extends Thread {
  private DatagramSocket ds;
  private Socket s;
  private JOptionPane jOptionPane1 = new JOptionPane();
  private InetAddress in;
  private int timeDelay = 0;
  private Frame1 frame;

  public ConnectBridge(Frame1 frame){
    this.frame = frame;
  }
  public void run(){
    try{
      ds = new DatagramSocket(4289);
      byte[] buff = new byte[1];
      while(!ds.isClosed()){
        DatagramPacket p = new DatagramPacket(buff,1);
        ds.receive(p);
        ds.close();
        in = p.getAddress();
        frame.connected = true;
      }
    }
    catch(SocketException e){JOptionPane.showMessageDialog(jOptionPane1,e,"Socket Exception",JOptionPane.ERROR_MESSAGE);}
    catch(IOException e){JOptionPane.showMessageDialog(jOptionPane1,e,"IOException", JOptionPane.ERROR_MESSAGE);}
    try{
      s = new Socket(in,4290);
      OutputStream out = s.getOutputStream();
      out.write("1".getBytes());
      InputStream input = s.getInputStream();
      byte[] b = new byte[4];
      input.read(b,0,4);
      input.read(b,0,4);
      timeDelay = (int)(b[0] << 24)|(int)(b[1] <<16)|(int)(b[2]<<8)|(int)(b[3]);
      if(frame!=null){
        frame.setTimeDelay(timeDelay);
        JOptionPane.showMessageDialog(jOptionPane1,"Bridge is now connected!","Connected", JOptionPane.INFORMATION_MESSAGE);
      }
      else{
        JOptionPane.showMessageDialog(jOptionPane1,"Frame variable is null","Frame Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    catch(IOException e){JOptionPane.showMessageDialog(jOptionPane1,e,"IOException", JOptionPane.ERROR_MESSAGE);}
  }
  private void connect(){
    //used for reconnect's if needed
    byte[] buff = new byte[1];
    try{
      ds = new DatagramSocket(4289);
      while(!ds.isClosed()){
        DatagramPacket p = new DatagramPacket(buff,1);
        ds.receive(p);
        ds.close();
        in = p.getAddress();
        frame.connected = true;
        //syncUp();
      }
      }catch(SocketException e){JOptionPane.showMessageDialog(jOptionPane1,e,"Socket Exception in connect: ",JOptionPane.ERROR_MESSAGE);}
      catch(IOException e){JOptionPane.showMessageDialog(jOptionPane1,e,"IOException in connect: ", JOptionPane.ERROR_MESSAGE);}
  }
  public void sendPacket(byte data){
    try{
      OutputStream out = s.getOutputStream();
      out.write(data);
    }catch(IOException e){JOptionPane.showMessageDialog(jOptionPane1,e,"IOException", JOptionPane.ERROR_MESSAGE);}
  }
  public void sendPacket(int data){
    try{
      OutputStream out = s.getOutputStream();
      out.write(data);
    }catch(IOException e){JOptionPane.showMessageDialog(jOptionPane1,e,"IOException in Send Packet", JOptionPane.ERROR_MESSAGE);}
  }
  public void cleanUp(){
    try{
      if(s!=null){
        s.close();
      }
    }catch(IOException e){JOptionPane.showMessageDialog(jOptionPane1,e,"IOException", JOptionPane.ERROR_MESSAGE);}
    catch(Exception e){JOptionPane.showMessageDialog(jOptionPane1,e,"Exception", JOptionPane.ERROR_MESSAGE);}
  }
  public void syncUp(){
    //should keep track of sync's and when they are needed
    //don say's sync before every song.
    //not gonna work.  god dammit!!!
    DJSync sync = new DJSync();
/*
    java.util.Timer t = new java.util.Timer();
    t.schedule(new TimerTask(){
      public void run(){
        //sync here...
        //after connected this should be called to keep in sync
        sendPacket(sync.getPosition());
      }
    },1000,1000);
*/
    System.out.println("seek position 10000: " + sync.seekPosition(10000));
  }
}