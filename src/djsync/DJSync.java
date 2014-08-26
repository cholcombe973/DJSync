package djsync;

public class DJSync {
  public native int startPlayback();
  public native int clearPlaylist();
  public native int status();
  private native int setVolume(int volume); // 0 to 255
  public native int playlistLength();
  public native int restartWinamp();
  public native int toggleRepeat(); //switches repeat button to opposite
  public native int toggleShuffle(); //switches shuffle button to opposite
  public native int fadeoutAndStop();
  public native int nextTrack();
  public native int previousTrack();
  public native int stop();
  public native int pause();
  public native int getWindowHandle();
  public native int getPosition();
  public native int seekPosition(int pos); //position is in milli's

  public DJSync(){
  }
  static{
    System.loadLibrary("Sync");
  }
  public void setWinampVolume(int volume){
    if(volume >0 && volume<255){
      setVolume(volume);
    }
  }
}
