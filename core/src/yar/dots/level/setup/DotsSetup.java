package yar.dots.level.setup;

import java.util.Set;

import yar.dots.level.controllers.InputController;
import yar.dots.level.units.node.SingularityFactory;
import eir.game.LevelSetup;
import eir.input.GameInputProcessor;
import eir.resources.levels.LevelDef;
import eir.world.Level;
import eir.world.unit.Unit;
import eir.world.unit.UnitsFactory.UnitFactory;

public class DotsSetup extends LevelSetup
{

	
	
	public DotsSetup()
	{
		super();
	}

	@Override
	protected void registerUnitFactories( Set<UnitFactory<? extends Unit>> factories )
	{
		factories.add( new SingularityFactory() );	


//		factories.add( new AntFactory( getGameFactory() ) );

//		factories.add( new BirdyFactory() );

//		factories.add( new SpawnerFactory() );

//		factories.add( new BulletFactory() );

//		factories.put( SPIDER, new SpiderFactory( this ) );

//		factories.add( new CannonFactory() );

//		factories.add( new WeaponFactory() );
		
//		factories.add( new DummyFactory() );	
	}

	@Override
	protected LevelDef loadLefelDef()
	{
		LevelParams params = new LevelParams();
		return new LevelGenerator().generate(params, gameFactory);

	}

	@Override
	public GameInputProcessor getInputController( Level level)
	{
		return new InputController( gameFactory, level);
	}

}
