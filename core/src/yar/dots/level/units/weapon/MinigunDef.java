package yar.dots.level.units.weapon;

import yarangi.numbers.RandomUtil;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

import eir.resources.AnimationHandle;
import eir.resources.ResourceFactory;
import eir.resources.TextureHandle;
import eir.resources.levels.UnitDef;
import eir.world.Effect;
import eir.world.unit.Damage;
import eir.world.unit.Unit;
import eir.world.unit.cannons.TargetProvider;
import eir.world.unit.weapon.Bullet;
import eir.world.unit.weapon.BulletFactory;
import eir.world.unit.weapon.IBulletBehavior;
import eir.world.unit.weapon.Weapon;
import eir.world.unit.weapon.WeaponDef;

public class MinigunDef extends WeaponDef
{

	public MinigunDef(final String type, final int faction, final float size,
			final TextureHandle unitSprite, final AnimationHandle deathAnimation, final boolean isPickable)
	{
		super( type, faction, size, unitSprite, deathAnimation, isPickable );

		bulletBehavior = new MassDriverBehavior();

		bulletDamage = new Damage(10f,0,0,0);

		this.bulletDef = new UnitDef( BulletFactory.NAME, faction, 0.3f, ResourceFactory.FIREBALL_TXR, null, false, getBulletSpeed() );
	}

	private IBulletBehavior bulletBehavior;

	private Damage bulletDamage;

	private Animation hitAnimation;

	private UnitDef bulletDef;


	@Override
	public void init(final ResourceFactory gameFactory)
	{
		this.hitAnimation = gameFactory.getAnimation( ResourceFactory.EXPLOSION_04_ANIM );

	}

	@Override
	public int getBurstSize() { return 15; }

	@Override
	public float getMagazineReloadTime() { return 0.5f; }

	@Override
	public float getReloadingTime() { return 0.05f; }

	@Override
	public float getDispersion() { return 1f; }

	@Override
	public IBulletBehavior getBulletBehavior() { return bulletBehavior; }

	@Override
	public float createSpeed() { return getBulletSpeed(); }

	@Override
	public float getBulletSpeed() { return 50; }

	@Override
	public Effect createTraceEffect(final Bullet bullet) { return null; }


	@Override
	public float getBulletLifeDuration() { return 1; }


	@Override
	public Damage getDamage()
	{
		return bulletDamage;
	}
	@Override
	public float getAngularSpeed() { return 200f; }


	@Override
	public float getMaxFireAngle() { return 10f; }

	@Override
	public boolean decayOnNoTarget() { return true; }


	@Override
	public UnitDef getBulletDef() { return bulletDef; }


	@Override
	public Effect createHitEffect( final Bullet bullet, final boolean b ) {
		return Effect.getEffect( hitAnimation,
				15, bullet.getBody().getAnchor(), Vector2.Zero, RandomUtil.N( 360 ), 3 );
	}

	@Override
	protected float createAngle( final Weapon weapon, final Vector2 firingDir )
	{
		return RandomUtil.STD( firingDir.angle(), getDispersion());
	}

	@Override
	public TargetProvider createTargetProvider( final Unit owner )
	{
		return TargetProvider.CLOSEST_TARGETER( owner );
	}

	@Override
	public float getSensorRadius() { return 30; }
}


