package yar.dots.level.controllers;

import java.util.List;

import eir.input.IControlMode;
import eir.input.IPickingFilter;
import eir.input.PickingSensor;
import eir.rendering.IRenderer;
import eir.world.environment.spatial.ISpatialObject;
import eir.world.unit.Unit;

public class OrderingControlMode implements IControlMode
{
	PickingSensor sensor = new PickingSensor(new IPickingFilter () {

		@Override
		public boolean accept( final ISpatialObject entity )
		{
			return entity instanceof Unit;
		}

	});

	private Unit pickedUnit;

	@Override
	public PickingSensor getPickingSensor() { return sensor; }

	@Override
	public void render( final IRenderer renderer )
	{
	}

	@Override
	public ISpatialObject objectPicked( final List <ISpatialObject> pickedObjects )
	{
		pickedUnit = (Unit) pickedObjects.iterator().next();
		pickedUnit.setIsHovered( true );

		return pickedUnit;
	}

	@Override
	public void objectUnpicked( final ISpatialObject pickedObject )
	{
//		assert pickedUnit == pickedObject;
		if(pickedUnit != null)
		{
			pickedUnit.setIsHovered( false );
			pickedUnit = null;
		}
	}


	@Override
	public void reset()
	{
		pickedUnit = null;
	}

	@Override
	public void keyDown(int keycode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touchUnit(ISpatialObject pickedObject, int button)
	{
		// TODO Auto-generated method stub
		
	}


}
