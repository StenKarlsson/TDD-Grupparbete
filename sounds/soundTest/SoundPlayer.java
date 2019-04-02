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
	String enterDoor = "270319__littlerobotsoundfactory__jingle-win-01.wav";
String evolve = "391656__jeckkech__evolve.wav";
String respawn = "458251__tolerabledruid6__you-died.wav";
	private AudioClip gameSoundclip;
  
private File levelSoundFile = new File("sounds/resources/Soundfiles/"+levelMusic);
private File treasureSoundFile = new File("sounds/resources/Soundfiles/"+shine);
private File enterDoorSoundFile = new File("sounds/resources/Soundfiles/"+evolve);
private File respawnSoundFile = new File("sounds/resources/Soundfiles/"+respawn);


  
  
  ///soundTest/src/resources/Soundfiles/265308__volvion__8-bit-bossfight.mp3
  
  public void loopLevelSound() {
	
		try {
			//skapa nytt ljudklipp 
			gameSoundclip = Applet.newAudioClip(new File(levelSoundFile.toString()).toURI().toURL());
			gameSoundclip.loop();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//
		//alarmSoundclip.loop();
		//alarmSoundclip.stop();
		
	}
	
  public void playTreasureSound() {
		
		try {
			//skapa nytt ljudklipp 
			gameSoundclip = Applet.newAudioClip(new File(treasureSoundFile.toString()).toURI().toURL());
			gameSoundclip.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//
		//alarmSoundclip.loop();
		//alarmSoundclip.stop();
		
	}
  
  public void playDoorEntrySound() {
		
		try {
			//skapa nytt ljudklipp 
			gameSoundclip = Applet.newAudioClip(new File(enterDoorSoundFile.toString()).toURI().toURL());
			gameSoundclip.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//
		//alarmSoundclip.loop();
		//alarmSoundclip.stop();
		
	}
  public void playRespawnSound() {
		
		try {
			//skapa nytt ljudklipp 
			gameSoundclip = Applet.newAudioClip(new File(respawnSoundFile.toString()).toURI().toURL());
			gameSoundclip.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//
		//alarmSoundclip.loop();
		//alarmSoundclip.stop();
		
	}
  
}
