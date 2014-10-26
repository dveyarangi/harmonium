package yar.dots.level.units.node;

import eir.world.unit.UnitsFactory.UnitFactory;

public class SingularityFactory extends UnitFactory <Singularity>
{
	public static final String NAME = "singularity".intern();

	@Override
	protected Singularity createEmpty()
	{
		return new Singularity();
	}

	@Override protected String getName() { return NAME; }

}
