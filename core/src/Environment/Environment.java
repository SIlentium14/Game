package Environment;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.math.Vector2;

public class Environment {
	
	
	
	private String name_;              // ��� �������
	private Texture sprite_;		   // ��������
	
	private Vector2 coords_;		   // ����������
	
	private boolean prochod_;			// ������������
	public Environment(String name, Vector2 coords, boolean prochod) {
		name_ = name;
		coords_ = coords;
		prochod_ = prochod;
	}
	
	
	
	
}
