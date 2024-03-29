package yar.dots;

import yar.dots.level.setup.DotsSetup;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import eir.debug.Debug;
import eir.game.LevelSetup;
import eir.game.screens.LoadingScreen;

/**
 * The game's main class, called as application events are fired.
 */
public class HarmoniumMain extends Game
{
    // constant useful for logging
    public static final String LOG = "EIR";

    // whether we are in development mode

    public static final boolean DEV_MODE = true;


    LevelSetup levelSetup = new DotsSetup();




    public HarmoniumMain()
    {
    }

    // Game-related methods

    @Override
    public void create()
    {
        Debug.log("Creating game on " + Gdx.app.getType() );

        LoadingScreen loadingScreen = new LoadingScreen( this, levelSetup );
    	setScreen( loadingScreen );

    }

    @Override
    public void resize( final int width, final int height )
    {
        super.resize( width, height );
        Debug.log("Resizing game to: " + width + " x " + height );

        // show the splash screen when the game is resized for the first time;
        // this approach avoids calling the screen's resize method repeatedly
 //       if( getScreen() == null ) {
 //           setScreen( new SplashScreen( this ) );
 //       }
        if( getScreen() == null ) {
        	//setScreen( new MenuScreen( this ) );
        }
/*        else
        	setScreen( getScreen() );*/
    }

    @Override
    public void render()
    {
        super.render();
    }

    @Override
    public void pause()
    {
        super.pause();
        Debug.log("Pausing game" );

    }

    @Override
    public void resume()
    {
        super.resume();
        Debug.log("Resuming game" );
    }

    @Override
    public void setScreen( final Screen screen )
    {
        super.setScreen( screen );
        Debug.log("Setting screen: " + screen.getClass().getSimpleName() );
    }

    @Override
    public void dispose()
    {
        super.dispose();
        Debug.log("Disposing game" );

    }

	public void startGame()
	{
		setScreen( new LoadingScreen( this, levelSetup ) );
	}


}