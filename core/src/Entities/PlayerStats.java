package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PlayerStats {
	
	private float experience;
	private int level;
	
	private float power;
	private float agility;
	private float intelligency;
	
	private int freestats;
	
	Preferences pref;
	public PlayerStats(String object) {
		pref = Gdx.app.getPreferences(object);
		int isBegin = pref.getInteger("FirstLaunch", 0);
		if(isBegin == 0) {
			startStats();
		}
		//pref.clear(); // REMOVE!!!
		experience = pref.getFloat("Exp",0.0f);
		level = pref.getInteger("Level", 1);
		power = pref.getFloat("Power", 1.0f);
		agility = pref.getFloat("Agility", 1.0f);
		intelligency = pref.getFloat("Intel",1.0f);
		freestats = pref.getInteger("FreeStatements", 0);
	}
	void startStats() {
		pref.clear();
		pref.putInteger("FirstLaunch", 1);
		pref.putFloat("Exp", 0.0f);
		pref.putInteger("Level", 1);
		pref.putFloat("Power", 1.0f);
		pref.putFloat("Agility", 1.0f);
		pref.putFloat("Intel", 1.0f);
		pref.putInteger("FreeStatements", 0);
	}
	public void ADDEXP(float exp) {
		experience+=exp;
		checkLevel();
	}
	private void checkLevel() {
		if(experience >= level*10) {
			experience = 0.0f;
			level++;
			freestats+=3;
		}
	}
	public float HP() {
		return (float) (power*1.1);
	}
	public float DAMAGE() {
		return (float) (power*1.05);
	}
	public float SPEED() {
		return (float) (agility*1.005);
	}
	public float ATKSPEED() {		// Don't touch!
		return (float) (agility*0.007<0.75 ? agility*0.007 : 0.75);
	}
	
	public float MANA() {
		return (float)(intelligency*1.1);
	}
	public float MANAREG() {
		return (float)(intelligency*1.1);
	}
	public float HPREG() {
		return (float)(power*1.05);
	}
}
