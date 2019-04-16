package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Entities {
	
	//� ����� ������� ���������� ��������
	protected boolean sideView;  // true - ������, false - �����
	protected boolean isAttacking;
	//���������� ��������
	protected float coordX;
	protected float coordY;
	protected float coordZ;
	//������ ��������
	protected float sizeX;
	protected float sizeY;
	
	protected float ATTACK_SPEED = 0.05f;
	
	//������� ����
	public TextureRegion currentFrame;
	//��� ������� �� 1 �����
	protected Texture allSheets;
	//����� ���������� �������� � ��������
	protected static int PIC_FRAME_COLS;
	protected static int PIC_FRAME_ROWS;
	TextureRegion[][] imageCollector;
	
	// ���������� ����������� �������� ����� � ��������
	protected static int STAY_FRAME_COLS;  //���������� ������
	protected static int STAY_FRAME_COL;   //� ����� ������� �������� ����������
	protected static int STAY_FRAME_ROWS;  //���������� �����
	protected static int STAY_FRAME_ROW;   //� ����� ������
	//�������� �����
	protected Animation<TextureRegion> stayAnimation;
	
	// ���������� �������� ��������
	protected static int MOVE_FRAME_COLS;
	protected static int MOVE_FRAME_COL;
	protected static int MOVE_FRAME_ROWS;
	protected static int MOVE_FRAME_ROW;
	//�������� ��������
	protected Animation<TextureRegion> moveAnimation;
	
	// ������� �����
	protected static int ATTACK1_FRAME_COLS;
	protected static int ATTACK1_FRAME_COL;
	protected static int ATTACK1_FRAME_ROWS;
	protected static int ATTACK1_FRAME_ROW;
	
	protected float ATTACK1_DURATION = 0.10f;
	//�������� �����1
	protected Animation<TextureRegion> attack1Animation;
	
	protected TextureRegion[] stayFrames;
	protected TextureRegion[] moveFrames;
	protected TextureRegion[] attack1Frames;
	
	public void update(float delta) {
	
	}
	
	public void dispose() {
		
	}
	
	public void setSize(Vector2 newSize) {
		sizeX = newSize.x;
		sizeY = newSize.y;
	}
	public void setCoord(Vector2 newCoord) {
		coordX = newCoord.x;
		coordY = newCoord.y;
	}
	public float getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public float getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public float getCoordZ() {
		return coordZ;
	}

	public void setCoordZ(int coordZ) {
		this.coordZ = coordZ;
	}
	
	public float getSizeX() {
		return sizeX;
	}

	public void setSizeX(float sizeX) {
		this.sizeX = sizeX;
	}

	public float getSizeY() {
		return sizeY;
	}

	public void setSizeY(float sizeY) {
		this.sizeY = sizeY;
	}

}
