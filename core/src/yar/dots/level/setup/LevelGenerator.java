package yar.dots.level.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import yar.dots.level.units.node.SingularityDef;
import yarangi.numbers.RandomUtil;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import eir.resources.ResourceFactory;
import eir.resources.TextureHandle;
import eir.resources.levels.FactionDef;
import eir.resources.levels.IUnitDef;
import eir.resources.levels.LevelDef;
import eir.resources.levels.LevelInitialSettings;
import eir.world.environment.parallax.Background;

public class LevelGenerator
{

	
	public LevelDef generate(final LevelParams parameters, final ResourceFactory factory )
	{

		LevelDef levelDef = new LevelDef( );

		levelDef.setWidth( parameters.width );
		levelDef.setHeight( parameters.height );

		levelDef.setInitialSettings( new LevelInitialSettings(new Vector2(0,0)) );

		levelDef.setBackgroundDef( generateBackground( parameters, factory ) );

		List <FactionDef> factions = new ArrayList <FactionDef>();

		FactionDef faction1Def = new FactionDef(LevelParams.PLAYER_FACTION, new Color(0.8f, 0.8f, 0.8f, 1.0f), "PlayerController");
		factions.add( faction1Def );
		FactionDef faction2Def = new FactionDef(LevelParams.ENEMY_FACTION, new Color(0.2f, 0.2f, 0.2f, 1.0f), "DummyController");
		factions.add( faction2Def );
		FactionDef faction3Def = new FactionDef(LevelParams.NEUTRAL_FACTION, new Color(0.5f, 0.0f, 0.5f, 1.0f), "WildlifeController");
		factions.add( faction3Def );

		levelDef.setFactionDefs( factions );


		List <IUnitDef> units = new ArrayList <IUnitDef> ();
		
		for(int aidx = 0; aidx < parameters.singularitiesNum; aidx ++)
		{
			String name = "singularity-" + aidx;

			Vector2 position = new Vector2(
					(RandomUtil.R( parameters.width ) - parameters.width/2)/2,
					(RandomUtil.R( parameters.height ) - parameters.height/2)/2
					);

			System.out.println(position);
			float radius = RandomUtil.STD( 300, 10 );

//			int segments = (int)(radius / 2f);
			//generateCircleModel( position, Vector2.Zero, radius, segments );

//			int textureSize = BitUtils.po2Ceiling( (int)(2*radius) );

			TextureHandle neutralHandle = factory.registerTexture( "levels/node/yellow_dot.png" );
//			PolygonalModelHandle modelHandle = PolygonalModelHandle.createCircularHandle(radius, segments);
//			factory.registerModelHandle( modelHandle );

//			float rotation = RandomUtil.sign() * (RandomUtil.R( 5 ) + 3f);

			SingularityDef node = new SingularityDef(position, 
					LevelParams.NEUTRAL_FACTION, 
					5,
					neutralHandle, 
					null);

			units.add( node );
		}
		levelDef.setUnitDefs( units );

		/////////////////////////////////////////////////////
		// generating factions:

		return levelDef;
	}

	private Background generateBackground( final LevelParams parameters, final ResourceFactory factory )
	{
		NavigableSet <Background.Layer> layers = new TreeSet <Background.Layer> ();

/*		TextureHandle layer1Handle =  new TextureHandle("levels/plasma_01.png");
		factory.registerTexture( layer1Handle );
		Background.Layer layer1 = new Background.Layer(
				5,
				layer1Handle,
				new Vector2(0,0), false );
		layers.add( layer1 );


		TextureHandle layer2Handle =  new TextureHandle("levels/fog_01.png");
		factory.registerTexture( layer2Handle );
		Background.Layer layer2 = new Background.Layer(
				0.9f, layer2Handle,
				new Vector2(500,0), true );

		layers.add( layer2 );*/

		Background background = new Background(layers);

		return background;
	}



}
