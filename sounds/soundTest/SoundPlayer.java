package soundTest;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class SoundPlayer {
	//Objekt för at spela upp ljud
	String levelMusic = "198896__bone666138__8-bit-circus-music.wav";
	String shine = "399904__mrthenoronha__shining-8-bit.wav";
	String boss = "179684__nicolasdrweski__mario-boss.wav";
 
private AudioClip alarmSoundclip;
  
private File defaultAlarmSoundFile = new File("sounds/resources/Soundfiles/"+boss);

  
  
  ///soundTest/src/resources/Soundfiles/265308__volvion__8-bit-bossfight.mp3
  
  public void playSound() {
	
		try {
			//skapa nytt ljudklipp 
			alarmSoundclip = Applet.newAudioClip(new File(defaultAlarmSoundFile.toString()).toURI().toURL());
			alarmSoundclip.loop();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//
		//alarmSoundclip.loop();
		//alarmSoundclip.stop();
		
	}
	
}
