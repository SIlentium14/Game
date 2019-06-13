package Levels;

import java.util.ArrayList;
import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.RPG;

import Engine.TriggerListener;
import Entities.Buff;
import Entities.Buff.BuffType;
import Environment.ActivatingObject;
import Environment.GameBuff;
import Environment.MovementPlatform;
import Environment.Platform;
import Environment.SecretPlatform;
import Environment.ShowablePlatform;
import Environment.Trigger;
import aiall.AiCustom;
import aiall.Level1Ai;
import aiall.Level2Ai;
import aiall.Level3Ai;

public class Level2 extends BaseLevel{
	
	public Level2(RPG game) {
		super(game);
	}
	
	
	//@Override
	public ArrayList<AiCustom> createEnemy() {
		 bots = new ArrayList<AiCustom>();
			bots.add(new Level3Ai(new Vector2(300.0f,300.0f) , new Vector2(203*SS,4*SS),3, rpgWorld));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f) , new Vector2(31*SS,18*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f) , new Vector2(4*SS,12*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f) , new Vector2(33*SS,3*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f) , new Vector2(48*SS,22*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f) , new Vector2(58*SS,23*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f) , new Vector2(59*SS,16*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(46*SS,3*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(68*SS,3*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(74*SS,3*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(84*SS,3*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(97*SS,3*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(93*SS,16*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(115*SS,24*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(177*SS,6*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(179*SS,6*SS),1));
			bots.add(new Level1Ai(new Vector2(150.0f,150.0f)  , new Vector2(188*SS,25*SS),1));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(37*SS,24*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(74*SS,13*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(94*SS,26*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(117*SS,24*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(102*SS,4*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(126*SS,18*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(153.5f*SS,16*SS),2));// bolshoyRange
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(192*SS,25*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(198*SS,25*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(182*SS,7*SS),2));
			bots.add(new Level2Ai(new Vector2(150.0f,150.0f)  , new Vector2(174*SS,21*SS),2));
			
			
			
			
			//bots.add(new AiCustom(new Vector2(150.0f,150.0f) , new Vector2(1100.0f,150.0f),1));
		//bots.add(new AiCustom(new Vector2(150.0f,150.0f) , new Vector2(1300.0f,150.0f),1));
		return bots;
	}	
	
	
	@Override
	protected void triggerReaction() {
		if(TriggerListener.objects.get(118)) {
			TriggerListener.objects.set(118, false);
			TriggerListener.objects.set(114, false);
			//if(music[currentMusic].getVolume()!=0) {
			//music[currentMusic].setVolume(music[currentMusic].getVolume()-0.02f);
			//}
			if(!platforms.get(127).myData.wasActivated) {
				music[currentMusic].setVolume(0);
				music[4].setVolume(0.5f);
				music[4].play();
			}
			else
				if(music[4].getVolume() > 0) {
					music[4].setVolume(music[4].getVolume()-0.01f);
				}
		}
		if(TriggerListener.objects.get(119)) {
			sounds[5].play(1.0f);
			TriggerListener.objects.set(119, false);
			platforms.get(119).myData.wasActivated = true;
		}
		if(TriggerListener.objects.get(120)) {
			sounds[0].play(1.0f);
			TriggerListener.objects.set(120, false);
			platforms.get(120).myData.wasActivated = true;
		}
		if(TriggerListener.objects.get(121)) {
			sounds[1].play(1.0f);
			platforms.get(121).myData.wasActivated = true;
			TriggerListener.objects.set(121, false);
		}
		if(TriggerListener.objects.get(122)) {
			sounds[2].play(1.0f);
			platforms.get(122).myData.wasActivated = true;
			TriggerListener.objects.set(122, false);
		}
		if(TriggerListener.objects.get(123)) {
			sounds[3].play(1.0f);
			platforms.get(123).myData.wasActivated = true;
			TriggerListener.objects.set(123, false);
		}
		if(TriggerListener.objects.get(124)) {
			sounds[4].play(1.0f);
			platforms.get(124).myData.wasActivated = true;
			TriggerListener.objects.set(124, false);
		}
		if(TriggerListener.objects.get(125)) {
			hero.getEntitieData().setNewBuff(BuffType.ARMOR, 1, 120, false);
			platforms.get(125).myData.wasActivated = true;
		}
		if(TriggerListener.objects.get(127)) {
			for(int i=0;i<sounds.length;i++)
				sounds[i].stop();
			gameOver.play();
			platforms.get(127).myData.wasActivated = true;
		}
		if(TriggerListener.objects.get(128)) {
			hero.getEntitieData().setNewBuff(BuffType.ARMOR, 1, 180, false);
			hero.getEntitieData().setNewBuff(BuffType.DAMAGE, 10, 180, false);
			hero.getEntitieData().setNewBuff(BuffType.POWER, 10, 180, false);
			hero.getEntitieData().setNewBuff(BuffType.AGILITY, 10, 180, false);
			hero.getEntitieData().setNewBuff(BuffType.INTELLIGENCY, 10, 180, false);
			hero.getEntitieData().setNewBuff(BuffType.MANA, 0.1f, 180, true);
			hero.getEntitieData().setNewBuff(BuffType.HITPOINTS, 0.1f, 180, true);
			platforms.get(128).myData.wasActivated = true;
		}
		if(bots.isEmpty()) {
			TriggerListener.objects.set(115,false);
		}
		else
			if(bots.get(0).level != 3)
				TriggerListener.objects.set(115,false);
			else
				TriggerListener.objects.set(115,true);
			
	}
	
	//@Override
	public Array<Platform> createEnvironment() {
		platforms = new Array<Platform>();
		
		platforms.add(new Platform(0,new Vector2(-5,-10), new Vector2(8,30*SS),rpgWorld)); // Earth platform
		platforms.add(new Platform(platforms.size,new Vector2(0*SS,14*SS),new Vector2(20*SS,5*SS),rpgWorld));//1
		platforms.add(new Platform(platforms.size,new Vector2(10*SS,6*SS),new Vector2(10*SS,8*SS),rpgWorld));//2          
		platforms.add(new Platform(platforms.size,new Vector2(13f*SS,4*SS),new Vector2(7*SS,2*SS),rpgWorld));//3
		platforms.add(new Platform(platforms.size,new Vector2(20*SS,5*SS),new Vector2(24*SS,5*SS),rpgWorld));//4
		platforms.add(new Platform(platforms.size,new Vector2(32*SS,4*SS),new Vector2(12*SS,1*SS),rpgWorld));//5
		platforms.add(new Platform(platforms.size,new Vector2(5*SS,3*SS),new Vector2(2*SS,9*SS),rpgWorld));//6
		platforms.add(new Platform(platforms.size,new Vector2(0*SS,0*SS),new Vector2(5*SS,11*SS),rpgWorld));//7
		platforms.add(new Platform(platforms.size,new Vector2(5*SS,0*SS),new Vector2(6*SS,3*SS),rpgWorld));//8
		platforms.add(new Platform(platforms.size,new Vector2(11*SS,0*SS),new Vector2(17*SS,2*SS),rpgWorld));//9
		platforms.add(new Platform(platforms.size,new Vector2(28*SS,0*SS),new Vector2(2*SS,3*SS),rpgWorld));//10
		platforms.add(new Platform(platforms.size,new Vector2(35*SS,0*SS),new Vector2(55*SS,2*SS),rpgWorld));//11
		platforms.add(new Platform(platforms.size,new Vector2(30*SS,0*SS),new Vector2(5*SS,1*SS),rpgWorld));//12
		platforms.add(new Platform(platforms.size,new Vector2(25*SS,16*SS),new Vector2(1*SS,3*SS),rpgWorld));//13
		platforms.add(new Platform(platforms.size,new Vector2(26*SS,16*SS),new Vector2(7*SS,1*SS),rpgWorld));//14
		platforms.add(new Platform(platforms.size,new Vector2(28*SS,20*SS),new Vector2(28*SS,1*SS),rpgWorld));//15
		platforms.add(new Platform(platforms.size,new Vector2(31*SS,21*SS),new Vector2(11*SS,2*SS),rpgWorld));//16
		platforms.add(new Platform(platforms.size,new Vector2(34*SS,23*SS),new Vector2(1*SS,1*SS),rpgWorld));//17
		platforms.add(new Platform(platforms.size,new Vector2(38*SS,23*SS),new Vector2(1*SS,1*SS),rpgWorld));//18
		platforms.add(new Platform(platforms.size,new Vector2(36*SS,15*SS),new Vector2(8*SS,1*SS),rpgWorld));//19
		
		
		//platforms.add(new Platform(platforms.size,new Vector2(0*SS,0*SS),new Vector2(0*SS,0*SS),rpgWorld));// 20 MOVING!!!
		platforms.add(new MovementPlatform(platforms.size, new Vector2(7*SS+5,2*SS), new Vector2(3*SS-40,1*SS-20), rpgWorld, new Vector2(7*SS+5,12*SS), new Vector2(0,80), true));
		
		platforms.add(new Platform(platforms.size,new Vector2(50*SS,16*SS),new Vector2(3*SS,1*SS),rpgWorld));//21
		platforms.add(new Platform(platforms.size,new Vector2(54*SS,14*SS),new Vector2(1*SS,4*SS),rpgWorld));//22
		platforms.add(new Platform(platforms.size,new Vector2(55*SS,14*SS),new Vector2(2*SS,3*SS),rpgWorld));//23
		platforms.add(new Platform(platforms.size,new Vector2(57*SS,14*SS),new Vector2(7*SS,1*SS),rpgWorld));//24
		platforms.add(new Platform(platforms.size,new Vector2(48*SS,4*SS),new Vector2(6*SS,6*SS),rpgWorld));//25
		platforms.add(new Platform(platforms.size,new Vector2(54*SS,4*SS),new Vector2(1*SS,1*SS),rpgWorld));//26
		platforms.add(new Platform(platforms.size,new Vector2(54*SS,9*SS),new Vector2(6*SS,1*SS),rpgWorld));//27
		platforms.add(new Platform(platforms.size,new Vector2(54*SS,10*SS),new Vector2(9*SS,2*SS),rpgWorld));//28
		platforms.add(new Platform(platforms.size,new Vector2(56*SS,2*SS),new Vector2(33*SS,1*SS),rpgWorld));//29
		platforms.add(new Platform(platforms.size,new Vector2(57*SS,3*SS),new Vector2(3*SS,3*SS),rpgWorld));//30  
		platforms.add(new Platform(platforms.size,new Vector2(52*SS,21*SS),new Vector2(9*SS,1*SS),rpgWorld));//31
		platforms.add(new Platform(platforms.size,new Vector2(61*SS,21*SS),new Vector2(2*SS,3*SS),rpgWorld));//32
		platforms.add(new Platform(platforms.size,new Vector2(60*SS,17*SS),new Vector2(1*SS,2*SS),rpgWorld));//33
		platforms.add(new Platform(platforms.size,new Vector2(61*SS,17*SS),new Vector2(9*SS,1*SS),rpgWorld));//34
		platforms.add(new Platform(platforms.size,new Vector2(65*SS,18*SS),new Vector2(5*SS,3*SS),rpgWorld));//35
		platforms.add(new Platform(platforms.size,new Vector2(67*SS,21*SS),new Vector2(3*SS,2*SS),rpgWorld));//36
		platforms.add(new Platform(platforms.size,new Vector2(70*SS,24*SS),new Vector2(4*SS,1*SS),rpgWorld));//37
		platforms.add(new Platform(platforms.size,new Vector2(62*SS,7*SS),new Vector2(28*SS,1*SS),rpgWorld));// 38
		platforms.add(new Platform(platforms.size,new Vector2(65*SS,5*SS),new Vector2(2*SS,2*SS),rpgWorld));//39
		platforms.add(new Platform(platforms.size,new Vector2(70*SS,5*SS),new Vector2(2*SS,2*SS),rpgWorld));//40
		platforms.add(new Platform(platforms.size,new Vector2(75*SS,5*SS),new Vector2(2*SS,2*SS),rpgWorld));//41
		platforms.add(new Platform(platforms.size,new Vector2(65*SS,8*SS),new Vector2(25*SS,1*SS),rpgWorld));//42
		platforms.add(new Platform(platforms.size,new Vector2(68*SS,9*SS),new Vector2(22*SS,1*SS),rpgWorld));//43
		platforms.add(new Platform(platforms.size,new Vector2(70*SS,10*SS),new Vector2(20*SS,1*SS),rpgWorld));//44
		platforms.add(new Platform(platforms.size,new Vector2(71*SS,11*SS),new Vector2(19*SS,1*SS),rpgWorld));//45
		platforms.add(new Platform(platforms.size,new Vector2(77*SS,12*SS),new Vector2(6*SS,9*SS),rpgWorld));//46
		platforms.add(new Platform(platforms.size,new Vector2(83*SS,12*SS),new Vector2(7*SS,3*SS),rpgWorld));//47
		platforms.add(new Platform(platforms.size,new Vector2(80*SS,5*SS),new Vector2(2*SS,2*SS),rpgWorld));//48
		platforms.add(new Platform(platforms.size,new Vector2(85*SS,5*SS),new Vector2(5*SS,2*SS),rpgWorld));//49
		platforms.add(new Platform(platforms.size,new Vector2(95*SS,15*SS),new Vector2(6*SS,1*SS),rpgWorld));//50
		platforms.add(new Platform(platforms.size,new Vector2(112*SS,15*SS),new Vector2(5*SS,2*SS),rpgWorld));//51
		platforms.add(new Platform(platforms.size,new Vector2(90*SS,18*SS),new Vector2(9*SS,2*SS),rpgWorld));//52
		platforms.add(new Platform(platforms.size,new Vector2(88*SS,20*SS),new Vector2(12*SS,1*SS),rpgWorld));//53
		platforms.add(new Platform(platforms.size,new Vector2(94*SS,21*SS),new Vector2(6*SS,1*SS),rpgWorld));//54
		platforms.add(new Platform(platforms.size,new Vector2(97*SS,22*SS),new Vector2(3*SS,1*SS),rpgWorld));//55
		platforms.add(new Platform(platforms.size,new Vector2(100*SS,20*SS),new Vector2(12*SS,4*SS),rpgWorld));//56
		platforms.add(new Platform(platforms.size,new Vector2(105*SS,24*SS),new Vector2(4*SS,1*SS),rpgWorld));//57
		platforms.add(new Platform(platforms.size,new Vector2(92*SS,24*SS),new Vector2(3*SS,1*SS),rpgWorld));//58
		platforms.add(new Platform(platforms.size,new Vector2(88*SS,23*SS),new Vector2(4*SS,6*SS),rpgWorld));//59
		platforms.add(new Platform(platforms.size,new Vector2(92*SS,27*SS),new Vector2(19*SS,2*SS),rpgWorld));//60
		platforms.add(new Platform(platforms.size,new Vector2(111*SS,26*SS),new Vector2(2*SS,4*SS),rpgWorld));//61
		platforms.add(new Platform(platforms.size,new Vector2(113*SS,28*SS),new Vector2(10*SS,2*SS),rpgWorld));//62
		platforms.add(new Platform(platforms.size,new Vector2(112*SS,19*SS),new Vector2(5*SS,4*SS),rpgWorld));//63
		platforms.add(new Platform(platforms.size,new Vector2(117*SS,20*SS),new Vector2(6*SS,3*SS),rpgWorld));//64
		platforms.add(new Platform(platforms.size,new Vector2(119*SS,23*SS),new Vector2(4*SS,5*SS),rpgWorld));//65
		platforms.add(new Platform(platforms.size,new Vector2(99*SS,5*SS),new Vector2(1*SS,2*SS),rpgWorld));//66
		platforms.add(new Platform(platforms.size,new Vector2(90*SS,7*SS),new Vector2(26*SS,8*SS),rpgWorld));//67
		platforms.add(new Platform(platforms.size,new Vector2(90*SS,0*SS),new Vector2(14*SS,2*SS),rpgWorld));//68
		platforms.add(new Platform(platforms.size,new Vector2(104*SS,0*SS),new Vector2(33*SS,4*SS),rpgWorld));//69
		platforms.add(new Platform(platforms.size,new Vector2(112*SS,8*SS),new Vector2(25*SS,7*SS),rpgWorld));//70
		platforms.add(new Platform(platforms.size,new Vector2(120*SS,4*SS),new Vector2(17*SS,5*SS),rpgWorld));//71
		platforms.add(new Platform(platforms.size,new Vector2(127*SS,15*SS),new Vector2(6*SS,1*SS),rpgWorld));//72
		platforms.add(new Platform(platforms.size,new Vector2(131*SS,16*SS),new Vector2(1*SS,1*SS),rpgWorld));//73
		platforms.add(new Platform(platforms.size,new Vector2(153*SS,0*SS),new Vector2(10*SS,15*SS),rpgWorld));//74
		platforms.add(new Platform(platforms.size,new Vector2(163*SS,11*SS),new Vector2(2*SS,2*SS),rpgWorld));//75
		platforms.add(new Platform(platforms.size,new Vector2(163*SS,9*SS),new Vector2(4*SS,2*SS),rpgWorld));//76
		platforms.add(new Platform(platforms.size,new Vector2(163*SS,7*SS),new Vector2(6*SS,2*SS),rpgWorld));//77
		platforms.add(new Platform(platforms.size,new Vector2(163*SS,5*SS),new Vector2(8*SS,2*SS),rpgWorld));//78
		platforms.add(new Platform(platforms.size,new Vector2(163*SS,3*SS),new Vector2(20*SS,2*SS),rpgWorld));//79
		platforms.add(new Platform(platforms.size,new Vector2(163*SS,0*SS),new Vector2(69*SS,3*SS),rpgWorld));//80
		platforms.add(new Platform(platforms.size,new Vector2(167*SS,23*SS),new Vector2(2*SS,10*SS),rpgWorld));//81
		platforms.add(new Platform(platforms.size,new Vector2(167*SS,17*SS),new Vector2(63*SS,1*SS),rpgWorld));//82
		platforms.add(new Platform(platforms.size,new Vector2(167*SS,18*SS),new Vector2(5*SS,2*SS),rpgWorld));//83
		platforms.add(new Platform(platforms.size,new Vector2(172*SS,18*SS),new Vector2(3*SS,1*SS),rpgWorld));//84
		platforms.add(new Platform(platforms.size,new Vector2(175*SS,18*SS),new Vector2(4*SS,3*SS),rpgWorld));//85
		platforms.add(new Platform(platforms.size,new Vector2(179*SS,18*SS),new Vector2(9*SS,5*SS),rpgWorld));//86
		platforms.add(new Platform(platforms.size,new Vector2(188*SS,8*SS),new Vector2(2*SS,15*SS),rpgWorld));//87
		platforms.add(new Platform(platforms.size,new Vector2(190*SS,18*SS),new Vector2(33*SS,5*SS),rpgWorld));//88
		platforms.add(new Platform(platforms.size,new Vector2(181*SS,26*SS),new Vector2(13*SS,5*SS),rpgWorld));//89
		platforms.add(new Platform(platforms.size,new Vector2(194*SS,29*SS),new Vector2(5*SS,2*SS),rpgWorld));//90
		platforms.add(new Platform(platforms.size,new Vector2(199*SS,23*SS),new Vector2(23*SS,8*SS),rpgWorld));//91
		platforms.add(new Platform(platforms.size,new Vector2(212*SS,10*SS),new Vector2(19*SS,5*SS),rpgWorld));//92
		platforms.add(new Platform(platforms.size,new Vector2(224*SS,3*SS),new Vector2(7*SS,8*SS),rpgWorld));//93
		platforms.add(new Platform(platforms.size,new Vector2(24*SS,16*SS),new Vector2(1*SS,9*SS),rpgWorld));//94
		platforms.add(new Platform(platforms.size,new Vector2(48*SS,10*SS),new Vector2(1*SS,1*SS),rpgWorld));//95
		platforms.add(new Platform(platforms.size,new Vector2(65*SS,11*SS),new Vector2(1*SS+50,1*SS),rpgWorld));//96
		platforms.add(new Platform(platforms.size,new Vector2(47*SS,15*SS),new Vector2(5*SS,1*SS),rpgWorld));//98
		platforms.add(new Platform(platforms.size,new Vector2(166*SS,17*SS),new Vector2(6*SS,1*SS),rpgWorld));//99
		platforms.add(new Platform(platforms.size,new Vector2(165*SS,16*SS),new Vector2(6*SS,1*SS),rpgWorld));//100
		
		
		//97
		platforms.add(new MovementPlatform(platforms.size, new Vector2(83*SS,15*SS+20), new Vector2(4*SS-15,1*SS-20), rpgWorld, new Vector2(83*SS,21*SS), new Vector2(0,70), true));
		
		//98 USE
		platforms.add(new MovementPlatform(platforms.size, new Vector2(137*SS,14*SS), new Vector2(3*SS,1*SS), rpgWorld, new Vector2(153*SS,14*SS), new Vector2(90,0), false));
		platforms.add(new ActivatingObject(platforms.size, new Vector2(119*SS,24*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		//B1 
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(49*SS,2*SS), new Vector2(1*SS,2*SS), rpgWorld, true));
		platforms.add(new ActivatingObject(platforms.size, new Vector2(0*SS,12*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		//B2 
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(60*SS,19*SS), new Vector2(1*SS,2*SS), rpgWorld, true));
		platforms.add(new ActivatingObject(platforms.size, new Vector2(61*SS,22*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		//B3 
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(60*SS,3*SS), new Vector2(1*SS,1*SS), rpgWorld, false));
		platforms.add(new ActivatingObject(platforms.size, new Vector2(104*SS,3*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		//B5
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(89*SS,21*SS), new Vector2(1*SS,2*SS), rpgWorld, true));
		
		platforms.add(new ActivatingObject(platforms.size, new Vector2(131*SS,16*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		//B6
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(167*SS,20*SS), new Vector2(1*SS,3*SS), rpgWorld, true));
		platforms.add(new ActivatingObject(platforms.size, new Vector2(182*SS,3*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		//B7
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(189*SS,3*SS), new Vector2(1*SS,5*SS), rpgWorld, true));
		
		platforms.add(new ActivatingObject(platforms.size, new Vector2(200*SS,25*SS), new Vector2(1*SS,1*SS), rpgWorld,platforms.size-1));
		
		
		//B8
		platforms.add(new ShowablePlatform(platforms.size, new Vector2(209*SS,3*SS), new Vector2(3*SS,11*SS), rpgWorld, true));
		Gdx.app.log("", ""+(platforms.size-1));
		
		//Secrets
		platforms.add(new SecretPlatform(platforms.size, new Vector2(44*SS,4*SS),  new Vector2(4*SS,6*SS), rpgWorld, false));
		
		platforms.add(new SecretPlatform(platforms.size, new Vector2(104*SS,4*SS),  new Vector2(12*SS,3*SS), rpgWorld, false));
		//118 id
		//adding triggers.
		platforms.add(new Trigger(platforms.size, new Vector2(192*SS,3*SS), new Vector2(3*SS,10*SS), rpgWorld, false));
		
		platforms.add(new Trigger(platforms.size, new Vector2(136*SS,15*SS), new Vector2(3*SS,10*SS), rpgWorld, false));
		platforms.add(new Trigger(platforms.size, new Vector2(84*SS,1*SS), new Vector2(3*SS,5*SS), rpgWorld, false));
		platforms.add(new Trigger(platforms.size, new Vector2(72*SS,11*SS), new Vector2(3*SS,5*SS), rpgWorld, false));
		platforms.add(new Trigger(platforms.size, new Vector2(60*SS,14*SS), new Vector2(3*SS,5*SS), rpgWorld, false));
		platforms.add(new Trigger(platforms.size, new Vector2(104*SS,24*SS), new Vector2(3*SS,5*SS), rpgWorld, false));
		platforms.add(new Trigger(platforms.size, new Vector2(180*SS,24*SS), new Vector2(3*SS,5*SS), rpgWorld, false));
		//
		
		//adding buffs
		platforms.add(new GameBuff(platforms.size, new Vector2(198*SS,25*SS), new Vector2(1*SS,1*SS), rpgWorld)); // 125
		
		//adding listeners
		TriggerListener.objects.add(false); // 151 ID dead Boss
		//Gdx.app.log("", ""+(TriggerListener.objects.size()-1));
		
		//FCKNG 
		platforms.add(new Platform(platforms.size,new Vector2(65*SS,12*SS),new Vector2(1*SS-10,1*SS),rpgWorld));
		platforms.add(new Trigger(platforms.size, new Vector2(213*SS,2*SS), new Vector2(10*SS,10*SS), rpgWorld, false));
		platforms.add(new GameBuff(platforms.size, new Vector2(117.5f*SS,4.5f*SS), new Vector2(1*SS,1*SS), rpgWorld)); // 125
		
		return platforms;
		}
	//@Override
	public  void managerLoad() {
		/*
		 * assetManager.load("Battleground1.png", Texture.class);
		 * assetManager.load("Hero.png", Texture.class);
		 * assetManager.load("1.mp3",Music.class);
		 * assetManager.load("2.mp3",Music.class);
		 * assetManager.load("3.mp3",Music.class);
		 * assetManager.load("4.mp3",Music.class);
		 * assetManager.load("5.mp3",Music.class);
		 * assetManager.load("attack1.wav",Sound.class);
		 * assetManager.load("teleport.wav",Sound.class);
		 * assetManager.load("attack2.wav",Sound.class);
		 * assetManager.load("magic.wav",Sound.class);
		 * assetManager.load("move.wav",Sound.class);
		 * assetManager.load("buttonclick.wav",Sound.class);
		 * assetManager.load("gamebutton.wav",Sound.class);
		 * assetManager.load("dead.mp3",Sound.class);
		 * assetManager.load("gameover.wav",Sound.class);
		 * assetManager.load("trigger1.wav",Sound.class);
		 * assetManager.load("trigger2.wav",Sound.class);
		 * assetManager.load("trigger3.wav",Sound.class);
		 * assetManager.load("trigger4.wav",Sound.class);
		 * assetManager.load("trigger5.wav",Sound.class);
		 * assetManager.load("trigger6.mp3",Sound.class);
		 * assetManager.load("skelet.wav",Sound.class);
		 * assetManager.load("dark_skills.png",Texture.class);
		 * assetManager.load("niceBG.jpg",Texture.class);
		 * assetManager.load("woodenBG.jpg",Texture.class);
		 * assetManager.load("buttons.png",Texture.class);
		 * assetManager.load("menu_font.fnt",BitmapFont.class);
		 * assetManager.load("armor_blocked.png", Texture.class);
		 * assetManager.load("armor_earned.png", Texture.class);
		 * assetManager.load("armor_unearned.png", Texture.class);
		 * assetManager.load("armor2_blocked.png", Texture.class);
		 * assetManager.load("armor2_earned.png", Texture.class);
		 * assetManager.load("armor2_unearned.png", Texture.class);
		 * assetManager.load("buff_blocked.png", Texture.class);
		 * assetManager.load("buff_earned.png", Texture.class);
		 * assetManager.load("buff_unearned.png", Texture.class);
		 * assetManager.load("cooldown_blocked.png", Texture.class);
		 * assetManager.load("cooldown_earned.png", Texture.class);
		 * assetManager.load("cooldown_unearned.png", Texture.class);
		 * assetManager.load("duration_blocked.png", Texture.class);
		 * assetManager.load("duration_earned.png", Texture.class);
		 * assetManager.load("duration_unearned.png", Texture.class);
		 * assetManager.load("HP_earned.png", Texture.class);
		 * assetManager.load("HP_unearned.png", Texture.class);
		 * assetManager.load("magic_blocked.png", Texture.class);
		 * assetManager.load("magic_earned.png", Texture.class);
		 * assetManager.load("magic_unearned.png", Texture.class);
		 * assetManager.load("MANA_earned.png", Texture.class);
		 * assetManager.load("MANA_unearned.png", Texture.class);
		 * assetManager.load("max_blocked.png", Texture.class);
		 * assetManager.load("max_earned.png", Texture.class);
		 * assetManager.load("max_unearned.png", Texture.class);
		 * assetManager.load("regen_blocked.png", Texture.class);
		 * assetManager.load("regen_earned.png", Texture.class);
		 * assetManager.load("regen_unearned.png", Texture.class);
		 * assetManager.load("teleport_blocked.png", Texture.class);
		 * assetManager.load("teleport_earned.png", Texture.class);
		 * assetManager.load("teleport_unearned.png", Texture.class);
		 * assetManager.load("tripple_blocked.png", Texture.class);
		 * assetManager.load("tripple_earned.png", Texture.class);
		 * assetManager.load("tripple_unearned.png", Texture.class);
		 * assetManager.load("vampire_blocked.png", Texture.class);
		 * assetManager.load("vampire_earned.png", Texture.class);
		 * assetManager.load("vampire_unearned.png", Texture.class);
		 * assetManager.load("startImage.png",Texture.class);
		 * assetManager.load("buffSound.wav",Sound.class);
		 */
		assetManager.load("Battleground1.png", Texture.class);
		assetManager.load("Hero.png", Texture.class);		
		assetManager.load("1.mp3",Music.class);
		assetManager.load("2.mp3",Music.class);
		assetManager.load("3.mp3",Music.class);
		assetManager.load("4.mp3",Music.class);
		assetManager.load("5.mp3",Music.class);		
		assetManager.load("attack1.wav",Sound.class);
		assetManager.load("teleport.wav",Sound.class);
		assetManager.load("attack2.wav",Sound.class);
		assetManager.load("magic.wav",Sound.class);
		assetManager.load("move.wav",Sound.class);		
		assetManager.load("buttonclick.wav",Sound.class);
		assetManager.load("gamebutton.wav",Sound.class);	
		assetManager.load("dead.mp3",Sound.class);
		assetManager.load("gameover.wav",Sound.class);
		assetManager.load("trigger1.wav",Sound.class);
		assetManager.load("trigger2.wav",Sound.class);
		assetManager.load("trigger3.wav",Sound.class);
		assetManager.load("trigger4.wav",Sound.class);
		assetManager.load("trigger5.wav",Sound.class);
		assetManager.load("trigger6.mp3",Sound.class);
		assetManager.load("skelet.wav",Sound.class);
		assetManager.load("dark_skills.png",Texture.class);
		assetManager.load("niceBG.jpg",Texture.class);
		assetManager.load("woodenBG.jpg",Texture.class);
		assetManager.load("buttons.png",Texture.class);
		assetManager.load("menu_font.fnt",BitmapFont.class);
		assetManager.load("armor_blocked.png", Texture.class);
		assetManager.load("armor_earned.png", Texture.class);
		assetManager.load("armor_unearned.png", Texture.class);
		assetManager.load("armor2_blocked.png", Texture.class);
		assetManager.load("armor2_earned.png", Texture.class);
		assetManager.load("armor2_unearned.png", Texture.class);
		assetManager.load("buff_blocked.png", Texture.class);
		assetManager.load("buff_earned.png", Texture.class);
		assetManager.load("buff_unearned.png", Texture.class);
		assetManager.load("cooldown_blocked.png", Texture.class);
		assetManager.load("cooldown_earned.png", Texture.class);		
		assetManager.load("cooldown_unearned.png", Texture.class);
		assetManager.load("duration_blocked.png", Texture.class);
		assetManager.load("duration_earned.png", Texture.class);
		assetManager.load("duration_unearned.png", Texture.class);
		assetManager.load("HP_earned.png", Texture.class);
		assetManager.load("HP_unearned.png", Texture.class);
		assetManager.load("HP_blocked.png", Texture.class);
		assetManager.load("magic_blocked.png", Texture.class);
		assetManager.load("magic_earned.png", Texture.class);
		assetManager.load("magic_unearned.png", Texture.class);
		assetManager.load("MANA_earned.png", Texture.class);
		assetManager.load("MANA_unearned.png", Texture.class);
		assetManager.load("MANA_blocked.png", Texture.class);
		assetManager.load("max_blocked.png", Texture.class);
		assetManager.load("max_earned.png", Texture.class);
		assetManager.load("max_unearned.png", Texture.class);
		assetManager.load("regen_blocked.png", Texture.class);
		assetManager.load("regen_earned.png", Texture.class);
		assetManager.load("regen_unearned.png", Texture.class);
		assetManager.load("teleport_blocked.png", Texture.class);
		assetManager.load("teleport_earned.png", Texture.class);
		assetManager.load("teleport_unearned.png", Texture.class);
		assetManager.load("tripple_blocked.png", Texture.class);
		assetManager.load("tripple_earned.png", Texture.class);
		assetManager.load("tripple_unearned.png", Texture.class);
		assetManager.load("vampire_blocked.png", Texture.class);
		assetManager.load("vampire_earned.png", Texture.class);
		assetManager.load("vampire_unearned.png", Texture.class);
		assetManager.load("power_unearned.png", Texture.class);
		assetManager.load("power_blocked.png", Texture.class);
		assetManager.load("aghility_unearned.png", Texture.class);
		assetManager.load("aghility_blocked.png", Texture.class);
		assetManager.load("intellegens_unearned.png", Texture.class);
		assetManager.load("intellegens_blocked.png", Texture.class);
		assetManager.load("startImage.png",Texture.class);
		assetManager.load("buffSound.wav",Sound.class);
	}

}
