package djsync;

public class Bitwise  {
  //port = 40289
  private static final int play =        0x0001;
  private static final int stop =        0x0002;
  private static final int previous =    0x0004;
  private static final int next =        0x0008;
  private static final int pause =       0x0010;
  private static final int fadeAndStop = 0x0020;
//private static final int restart =     0x0080;
//private static final int shuffle =     0x0100;
//private static final int repeat =      0x0120;

  private byte flags = 0;

  public void setPlayFlag(boolean playFlag){
    if(playFlag){
      flags |= play;
    }
  }
  public boolean isPlayOn(){
    if ((flags & play) == play) {
      return true;
    }
    return false;
  }
  public void resetPlay(){
    if((flags & play)==play){
      flags ^= play;

    }
  }
  /*
  uncomment if only setting 1 flag at a time
  private boolean isSettable(){
    boolean result = false;
    if((flags & stop)==stop){
      result = false;
    }
    else if((flags & play)==play){
      result = false;
    }
    else if((flags & previous)==previous){
      result = false;
    }
    else if((flags & next)==next){
      result = false;
    }
    else if((flags & pause)==pause){
      result = false;
    }
    else if((flags & restart)==restart){
      result = false;
    }
    else if((flags & shuffle)==shuffle){
      result = false;
    }
    else if((flags & repeat)==repeat){
      result = false;
    }
    else if((flags & fadeAndStop)==fadeAndStop){
      result = false;
    }
    else{
      result = true;
    }
    return result;
  }
  */
  public void setStopFlag(boolean stopFlag){
    if(stopFlag){
      flags |= stop;
    }
  }
  public boolean isStopOn(){
    if((flags & stop) == stop){
      return true;
    }
    return false;
  }
  public void resestStop(){
    if((flags & stop)==stop){
      flags ^= stop;
    }
  }
  public void setPreviousFlag(boolean previousFlag){
    if(previousFlag){
      flags |= previous;
    }
  }
  public boolean isPreviousOn(){
    if((flags & previous)== previous){
      return true;
    }
    return false;
  }
  public void resetPrevious(){
    if((flags & previous)== previous){
      flags ^= previous;
    }
  }
  public void setNextFlag(boolean nextFlag){
    if(nextFlag){
      flags |= next;
    }
  }
  public boolean isNextOn(){
    if((flags & next)==next){
      return true;
    }
    return false;
  }
  public void resetNext(){
    if((flags & next)==next){
      flags ^= next;
    }
  }
  public void setPauseFlag(boolean pauseFlag){
    if(pauseFlag){
      flags |= pause;
    }
  }
  public boolean isPauseOn(){
    if((flags & pause)==pause){
      return true;
    }
    return false;
  }
  public void resetPause(){
    if((flags & pause)==pause){
      flags ^= pause;
    }
  }
/*
  public void setRestartFlag(boolean restartFlag){
    if(restartFlag){
//      if(isSettable()){
        flags = flags | restart;
//      }
    }
  }
  public boolean isRestartOn(){
    if((flags & restart)==restart){
      return true;
    }
    return false;
  }
  public void resetRestart(){
    if((flags & restart)==restart){
      flags = flags ^ restart;
    }
  }
*/
/*
  public void setShuffleFlag(boolean shuffleFlag){
    if(shuffleFlag){
//      if(isSettable()){
        flags = flags | shuffle;
//      }
    }
  }
  public boolean isShuffleOn(){
    if((flags & shuffle)==shuffle){
      return true;
    }
    return false;
  }
  public void resetShuffle(){
    if((flags & shuffle)==shuffle){
      flags = flags ^ shuffle;
    }
  }
*/
/*
  public void setRepeatFlag(boolean repeatFlag){
    if(repeatFlag){
//      if(isSettable()){
        flags = flags | repeat;
//      }
    }
  }
  public boolean isRepeatOn(){
    if((flags & repeat)==repeat){
      return true;
    }
    return false;
  }
  public void resetRepeat(){
    if((flags & repeat)==repeat){
      flags = flags ^ repeat;
    }
  }
*/
  public void setFadeAndStopFlag(boolean fadeAndStopFlag){
    if(fadeAndStopFlag){
        flags |= fadeAndStop;
    }
  }
  public boolean isFadeAndStopOn(){
    if((flags & fadeAndStop)==fadeAndStop){
      return true;
    }
    return false;
  }
  public void resetFadeAndStop(){
    if((flags & fadeAndStop)==fadeAndStop){
      flags ^= fadeAndStop;
    }
  }
  public void resetFlags(){
    flags = 0;
  }
  public byte getPacket(){
    return flags;
  }
}