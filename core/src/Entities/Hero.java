package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;



public class Hero  extends Entities{

	public Hero(Vector2 heroSize,Vector2 heroCoord) {
		
		setSize(heroSize);
		sideView = true; 
		
		allSheets = new Texture(Gdx.files.internal("Hero.png"));
		//����� ���������� �������� � �����
		PIC_FRAME_COLS = 10;
		PIC_FRAME_ROWS = 10;
		//���������� �������� �����
		STAY_FRAME_COLS = 10;
		STAY_FRAME_COL = 0;
		STAY_FRAME_ROWS = 1;
		STAY_FRAME_ROW = 0;
		//���������� �������� ��������
		MOVE_FRAME_COL = 0;
		MOVE_FRAME_COLS = 10;
		MOVE_FRAME_ROW = 2;
		MOVE_FRAME_ROWS = 1;
		//���������� ���������� ����� ��������� �� �����
		imageCollector = TextureRegion.split(allSheets,allSheets.getWidth()/PIC_FRAME_ROWS,allSheets.getHeight()/PIC_FRAME_COLS);
		//������������� ���� TextureRegion'�� 
		stayFrames = new TextureRegion[STAY_FRAME_COLS*STAY_FRAME_ROWS];
		moveFrames = new TextureRegion[MOVE_FRAME_COLS*MOVE_FRAME_ROWS];
		
		//���������� TextureRegion'�� ���������
		int index = 0;
		for(int i=0;i<STAY_FRAME_ROWS;i++)  //���������� �����
			for(int j=0;j<STAY_FRAME_COLS;j++) {
				stayFrames[index++] = imageCollector[i+STAY_FRAME_ROW][j+STAY_FRAME_COL];
			}
		index = 0;
		for(int i=0;i<MOVE_FRAME_ROWS;i++)  //���������� ��������
			for(int j=0;j<MOVE_FRAME_COLS;j++)
				moveFrames[index++] = imageCollector[i+MOVE_FRAME_ROW][j+MOVE_FRAME_COL];
		//������������� ���������� ��������
		stayAnimation = new Animation<TextureRegion>(0.10f, stayFrames);
		moveAnimation = new Animation<TextureRegion>(0.10f,moveFrames);
		currentFrame = stayAnimation.getKeyFrame(0.0f, true);
	}
	
	@Override
	public void update(float delta) {
		
			if(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {   //�������� ������
				
				currentFrame = moveAnimation.getKeyFrame(delta, true);
				
				if(currentFrame.isFlipX()) {
					currentFrame.flip(true, false);
				}
				coordX += 500 * Gdx.graphics.getDeltaTime();
				sideView = true;
				return;	
			}
			if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {    //�������� �����
				
				currentFrame = moveAnimation.getKeyFrame(delta, true);
				
				if(!currentFrame.isFlipX())
					currentFrame.flip(true, false);
				coordX -= 500 * Gdx.graphics.getDeltaTime();
				sideView = false;
				
				return;
			}
			
			currentFrame = stayAnimation.getKeyFrame(delta, true);							//����� �������� ����� -- � ����� ���
			if(sideView) {                                                                 //� �� ����, �� ��������
				if(!currentFrame.isFlipX())												   // ��� ������� � ������� � ���. ��� 
					currentFrame.flip(false, false); 
				else
					currentFrame.flip(true, false);
			}
			else {
				if(currentFrame.isFlipX())
					currentFrame.flip(false, false);
				else
					currentFrame.flip(true, false);
			}
			
		}
	@Override
	public void dispose() {
		allSheets.dispose();
		stayFrames = null;
		imageCollector = null;
		stayAnimation = null;
	}
}
