# Aquarium

Model of a simple aquarium where we can take care of our fish.

#### Fish

Each fish has a name, weight and a color.

- The fish has a `status()` method. It should print the status for a fish.

  - For example: `Dory, weight: 9, color: blue, short-term memory loss: true`

- The fish has a `feed()` method. The implementation should depend on the type of the fish.

##### Clownfish

Clownfish, gains 1 gramm when fed and has an additional color (color of the stripes).

##### Tang

Tang, gains 1 gramm when fed and can suffer short-term memory loss.

##### Kong

Kong, gains 2 grams when fed.

#### Fish Tank

- It has an `addFish()` method where you can add fish to the aquarium.

- It has a `feed()` method that feeds all the fish in the aquarium:

  - Increases the weight of every fish with the amount of grams they gain when fed.

- It has a `removeFish()` a method that removes the big fish: 

  - A big fish's weight is at least 11 grams.

- The aquarium has a `getStatus()` method it should print the status for each fish.
