Morphognosis: the shape of knowledge in space and time
Thomas E. Portegys
portegys@gmail.com

The brain can be viewed as a solution to problems posed by an environment existing in space and time. 
The environment generates signals that produce sensory events within an organism. Building an internal 
spatial and temporal model of the environment allows an organism to navigate and manipulate the environment. 
This notion is embodied in a model called morphognosis (morpho = shape and gnosis = knowledge). 
Its basic structure is a pyramid of event recordings called a morphognostic. At the apex of the pyramid 
are the most recent and nearby event recordings. Receding from the apex are recordings of less recent 
and possibly more distant events. A morphognostic can thus be viewed as a structure of progressively larger chunks 
of space-time knowledge. Matching a current morphognostic with a learned set of morphognostics allows a 
response to be selected that serves some purpose to the organism. The set of morphognostics forms a long-term memory 
that can be learned by exposure to the environment. A cellular automaton is used as the platform to investigate the 
morphognosis model.

Paper:
www.researchgate.net/publication/315112721_Morphognosis_the_shape_of_knowledge_in_space_and_time

Morphognosis is a library for use in applications.

Usage:

// Initialize.
init()
{
      // Let the event types be determined by the organism's sensors.
      int NUM_SENSORS = 1;
      int [] numEventTypes = new int[NUM_SENSORS];
      int NUM_SENSOR_VALUES = 2;
      numEventTypes[0] = NUM_SENSOR_VALUES;
          
      // This is the morphognostic to be updated to reflect the
      // current state of the world.
      morphognostic = new Morphognostic(NORTH, numEventTypes,
                                        NUM_NEIGHBORHOODS,
                                        NEIGHBORHOOD_INITIAL_DIMENSION,
                                        NEIGHBORHOOD_DIMENSION_STRIDE,
                                        NEIGHBORHOOD_DIMENSION_MULTIPLIER,
                                        EPOCH_INTERVAL_STRIDE,
                                        EPOCH_INTERVAL_MULTIPLIER);
                                        
      // Learned metamorphs.
      // Metamorph: morphognostic -> response pair.
      metamorphs  = new ArrayList<Metamorph>();
}
      
// Sensor/response cycle.
int cycle(sensors)
{
      // Create event for current state of organism.
      event = new Event(sensors, currentX, currentY, currentTime);
      
      // Add new event to the history of events.
      events.add(event); 
      eventArray = convertToArray(events);   
 
      // Update morphognostic with new event.
      morphognostic.update(eventArray, currentX, currentY);

      // Training?
      if (training)
      {
         // Get appropriate training response.
         response = getTrainingResponse(morphognostic);

         // Update metamorphs with new morphognostic -> response pair.
         Metamorph metamorph = new Metamorph(morphognostic.clone(), response);
         metamorphs.add(metamorph);
         
      } else {  // Testing.
      
	     // Pattern-match morphognostic to metamorphs and retrieve associated response.
	     response = getMetamorphResponse(morphognostic);
      }

      return(response);
}

Applications:

Morphognosis learning and control of mox.

A mox is an organism occupying a cell in a cellular automaton. A mox has an orientation
and can sense landmarks in front of it. It also has a sense for the proximity of food.
A mox is capable of moving forward, turning, and consuming food.
A primary purpose of the project is investigate morphognosis learning and control of the mox.
github.com/portegys/MoxWorx


Pufferfish nest-building with Morphognosis learning and control.

A species of pufferfish builds circular nesting sites on the sea floor.
This project simulates this nest-building behavior in a cellular automaton using the Morphognosis model.
