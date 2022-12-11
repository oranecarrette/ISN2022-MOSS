package com.moss.main;

import com.moss.object.Key;
import com.moss.object.TreasureClose;
import com.moss.object.TreasureOpen;

public class AssetSetter {
	GamePanel pan;
	
	public AssetSetter(GamePanel pan) {
		this.pan=pan;
	}
	
	public void setObject() {
		 pan.obj[0]=new Key();
		 pan.obj[0].x=14*pan.tileSize;
		 pan.obj[0].y=1*pan.tileSize;
		 
		 pan.obj[1]=new TreasureClose();
		 pan.obj[1].x=13*pan.tileSize;
		 pan.obj[1].y=10*pan.tileSize;
	}

}
