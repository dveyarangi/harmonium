package yar.dots.level.units.node;

import com.badlogic.gdx.math.Vector2;

import eir.resources.AnimationHandle;
import eir.resources.TextureHandle;
import eir.resources.levels.UnitDef;

public class SingularityDef extends UnitDef
{

	public SingularityDef(Vector2 position, int faction, float size,
			TextureHandle unitSprite, AnimationHandle deathAnimation )
	{
		super(SingularityFactory.NAME, faction, size, unitSprite, deathAnimation, true, 0);
		
		this.position = position;
	}

}
