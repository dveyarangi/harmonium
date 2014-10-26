package yar.dots.level.controllers;

import eir.input.GameInputProcessor;
import eir.input.IControlMode;
import eir.resources.ResourceFactory;
import eir.world.Level;

public class InputController extends GameInputProcessor
{

	public InputController(ResourceFactory factory, Level level)
	{
		super(factory, level);
	}

	@Override
	protected IControlMode[] createControlModes(ResourceFactory factory)
	{
		return new IControlMode [] {
				new BuildingControlMode( factory, level ),
				new OrderingControlMode( )
		};
	};

}
