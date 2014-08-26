package djsync;

import java.util.*;

public class PlayDelay {
  private Timer t;
  private long currentTime = System.currentTimeMillis();
  private DJSync sync;
  private Date d = new Date();

  public PlayDelay(DJSync sync, int delay){
    this.sync = sync;
    d.setTime(currentTime+delay);
  }
  public void startPlay(){
    t = new Timer();
    t.schedule(new TimerTask(){
      public void run(){
        sync.startPlayback();
      }
    },d);
  }
}