import java.util.concurrent.ThreadLocalRandom; 


public class BorkenGps 
{
//	public enum Direction 
//	{
//		NORTH(0, 5), 
//		EAST(5, 0), 
//		SOUTH(0, -5), 
//		WEST(-5, 0);
//		
//		private int x=0, y=0;
//		Direction(int arg1, int arg2)
//		{
//			x=arg1;
//			y=arg2;
//		}
//		
//		public ThreadLocalRandom random = ThreadLocalRandom.current();
//		
//	    public Direction randomDirection() 
//	    {
//	        return Direction.values()[random.nextInt(4)];
//	    }
//	}
	
	private static int dx=0, dy=0;
	//delta x, and delta y for North and East respectively.
	
	public static void main(String [] args) throws InterruptedException
	{
		final int TURNS = 12;
		//Change direction every 5 minutes for 60 hours.
		int totalDistance=0;
		//Ensures I traveled the full 60 miles.
		double crowFlyDistance=0;
		//Point A to point B distance "as the crow flies".
		
//		ThreadLocalRandom random = ThreadLocalRandom.current().nextInt(4);
		//I read this is better for multithreading, and was introduced with Java 7.
		//I misunderstood how this works, so I would like to leave the error commented out.
		//int r3 = ThreadLocalRandom.current().nextInt(4);
		
		for(int i=0; i<TURNS; i++)
		{
			Thread.sleep(1000);
			int random = ThreadLocalRandom.current().nextInt(4);
			System.out.println("\n\n" + random);
			//This was to ensure that I was printing a random number, and it was properly associated with a direction.
			
			//0=North, 1=East, 2=South, 3=West
			
		switch (random)
		{
		case 0:
			dy++;
			System.out.println("You just turned North.  That's " + dy + " units traveled North");
			totalDistance++;
			break;
		case 1:
			dx++;
			System.out.println("You just turned East.  That's " + dx + " units traveled East");
			totalDistance++;
			break;
		case 2:
			dy--;
			System.out.println("You just turned South.  That's " + dy + " units traveled North");
			totalDistance++;
			break;
		case 3:
			dx--;
			System.out.println("You just turned West.  That's " + dx + " units traveled East.");
			totalDistance++;
			break;
		default:
			System.out.println("******  ERROR! ******\n\n*********  ERROR! ******\n\n************  ERROR! ******");
			totalDistance++;
			break;
		}
		}
		dy=dy*5;
		dx=dx*5;
		System.out.println("\n\n\n\nYou traveled " + totalDistance*5 + " miles.");
		Thread.sleep(1000);
		if(dy<0 && dx<0){
			System.out.println("\n\nThat's " + Math.abs(dy) + " miles South, and " + Math.abs(dx) + " miles West.");
			//Correcting standard North/East for the possibility of South/West.  The Math.abs gives an absolute value.
		}
		else if(dy<0 && dx>=0){
			System.out.println("\n\nThat's " + Math.abs(dy) + " miles South, and " + dx + " miles East.");
		}
		else if(dy>=0 && dx<0){
			System.out.println("\n\nThat's " + dy + " miles North, and " + Math.abs(dx) + " miles West.");
		}
		else{
			System.out.println("\n\nThat's " + dy + " miles North, and " + dx + " miles East.");
		}
		
		
		crowFlyDistance = Math.sqrt(Math.pow(dx, 2)+ Math.pow(dy, 2));
		System.out.println("From your origin, you've traveled " + crowFlyDistance + " as the crow flies.");
	}
}
