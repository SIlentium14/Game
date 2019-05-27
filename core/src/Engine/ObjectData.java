package Engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import Entities.Buff;
import Entities.Buff.BuffType;
import Entities.Hero;
import Entities.PlayerStats;

/**
 * @author Slava Stankevich
 *
 */
public class ObjectData {
	//_______________________________________________
	// Local parameters
	Preferences preferences;
	public PlayerStats stats;
	Array<Buff> buffs;
	
	protected float MAXHITPOINT;
	public float getMAXHITPOINT() {
		return MAXHITPOINT;
	}

//	public void setMAXHITPOINT(float mAXHITPOINT) {
//		MAXHITPOINT = mAXHITPOINT;
//	}

	public float getMAXMANA() {
		return MAXMANA;
	}

//	public void setMAXMANA(float mAXMANA) {
//		MAXMANA = mAXMANA;
//	}
	protected float MAXMANA;
	
	
	//_______________________________________________
	
	/**
	 * 	if this parametr is true - entitie attack and do damage
	 */
	public int isAttacking = 0;
	public boolean isAi = false;
	public float attackTime = 0;
	public boolean isInvisible = false;
	public boolean shouldEvade = false;
	public boolean shouldRemove = false;
	public boolean isBull = false;
	public float skillDamage = 1.0f;
	
	public int sideView = 1;
	
	private float HITPOINT;
	protected float MANA;
	protected float ARMOR;
	protected float DAMAGE;
	
	private float addIntel;
	private float addAgility;
	private float addPower;
	
	public ObjectData(String object) { 
		
		preferences = Gdx.app.getPreferences(object);
		stats = new PlayerStats(object+"_stat");
		loadPref();
		buffs = new Array<Buff>();
	}
	
	public float getHITPOINT() {
		return HITPOINT;
	}
	
	public float getMANA() {
		return MANA;
	}
	
	public float getARMOR() {
		return ARMOR;
	}
	
	public float getDAMAGE() {
		return DAMAGE+stats.DAMAGE();
	}
	
	/**
	 * Descrease hitpoints on damage parameter
	 * @param damage
	 */
	public void setHitpoint(float damage) {
		checkARMOR();
		HITPOINT -= damage/(ARMOR+1);
		
	}
	/**
	 *  reset value of HP to 0.0f
	 */
	public void resetHitpoints() {
		HITPOINT = 0.0f;
	}
	
	/**
	 * Descrease mana on param
	 * @param mana value
	 */
	public boolean setMANA(float mana) {
		MANA -= mana;
		if(MANA < 0) {
			MANA += mana ;
			return false;
		}
		return true;
	}
	/**
	 * @param armor cannot be lower than 0 and biggest than 1
	 */
	public void setARMOR(float armor) {
		ARMOR = armor;
		checkARMOR();
	}
	
	public void setNewBuff(BuffType what, float value, float durating,boolean cycling) {
		buffs.add(new Buff(what, value, durating,cycling));
		addStats(buffs.get(buffs.size-1));
		
	}
	

	private void loadPref() {
		
		MAXHITPOINT = 100.0f * stats.MAXHP();
		MAXMANA = 100.0f * stats.MAXMANA();
		HITPOINT = preferences.getFloat("HITPOINT", MAXHITPOINT);
		DAMAGE = preferences.getFloat("DAMAGE", 25.0f) * stats.DAMAGE();
		ARMOR = preferences.getFloat("ARMOR", 0.0f);
		checkARMOR();
		MANA = preferences.getFloat("MANA", MAXMANA);
	
	}
	
	public void resetPref() {
		preferences.clear();
		preferences.putFloat("HITPOINT", 100.0f);
		preferences.putFloat("DAMAGE", 1.0f) ;
		preferences.putFloat("ARMOR", 0.0f);
		preferences.putFloat("MANA", 0.0f);
		preferences.flush();
	}
	float regenClock = 0.0f;
	float regenTime = 3.0f;
	/**
	 * set new time to regen stats
	 * @param newTime
	 */
	public void setRegenTime(float newTime) {
		regenTime = newTime;
	}
	public float getRegenTime() {
		return regenTime;
	}
	Hero hero;
	
	/**
	 * Method need for regen and check valid values
	 * @param hero 
	 */
	public boolean updateData() {
		//this.hero = hero;
		regenClock += Gdx.graphics.getDeltaTime();
		if(regenClock >= regenTime) {
			regenClock = 0.0f;
			regenHP();
			regenMANA();
		}
		
			updateBuffs(Gdx.graphics.getDeltaTime());
		checkStats();
		return false;
	}
	
	/**
	 *  check on max and min values
	 */
	private void checkStats() {
		if(HITPOINT > MAXHITPOINT)
			HITPOINT = MAXHITPOINT;
		//if(HITPOINT < 0)
		//	HITPOINT = 0;
		if(MANA > MAXMANA)
			MANA = MAXMANA;
		if(MANA < 0)
			MANA = 0;
		if(DAMAGE < 1)
			DAMAGE = 1;
		if(regenTime < 0f)
			regenTime = 0.1f;
		if(regenTime > 3f)
			regenTime = 3f;
		checkARMOR();
	}
	
	/**
	 *  if entitie get buff, inscrease parameters
	 */
	private void addStats(Buff buff) {
			switch(buff.type) {
			case POWER:stats.setPower(stats.getPower()+buff.value); break;
			case AGILITY:stats.setAgility(stats.getAgility()+buff.value); break; 
			case INTELLIGENCY:stats.setIntel(stats.getIntel()+buff.value); break; 
			case HITPOINTS: HITPOINT+=buff.value; break; 
			case MANA: MANA+=buff.value ; break; 
			case ARMOR: ARMOR+=buff.value ; break; 
			case DAMAGE: DAMAGE+=buff.value ; break;
			case REGEN_FREQUENCY: regenTime-=buff.value; break;
			default: break;
			}
	}
	private void descrease(Buff buff) {
		switch(buff.type) {
		case POWER:stats.setPower(stats.getPower()-buff.getFinalValue()); break;
		case AGILITY:stats.setAgility(stats.getAgility()-buff.getFinalValue()); break; 
		case INTELLIGENCY:stats.setIntel(stats.getIntel()-buff.getFinalValue()); break; 
		case HITPOINTS:; break; 
		case MANA:; break; 
		case ARMOR: ARMOR-=buff.getFinalValue(); break; 
		case DAMAGE: DAMAGE-=buff.getFinalValue(); break;
		case REGEN_FREQUENCY: regenTime+=buff.getFinalValue(); break;
		default: break;
		}
	}
	/**
	 * Update buffs, which has entitie
	 * @param delta time
	 */
	private void updateBuffs(float delta) {
		for(int i = 0; i < buffs.size; i++) {
			if(buffs.get(i).update(delta) == 0) {
				descrease(buffs.get(i));
				buffs.removeIndex(i);
			}
			else
				if(buffs.get(i).isCycle) {
					addStats(buffs.get(i));
				}
		}
	}


	private void regenMANA() {
		MANA += stats.MANAREG();
	}

	private void regenHP() {
		if(HITPOINT<= 0 )
			HITPOINT = 0;
		else
			HITPOINT += stats.HPREG();
	}

	private void checkARMOR() {
		if(ARMOR > 1) {
			ARMOR = 1;
		}
		if(ARMOR < 0) {
			ARMOR = 0;
		}
	}

	public float getSkillDamage() {
		return DAMAGE*skillDamage;
	}
	
	public Array<Buff> getBuffs() {
		return buffs;
	}
}
