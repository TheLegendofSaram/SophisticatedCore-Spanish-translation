package net.p3pp3rf1y.sophisticatedcore.util;

import net.minecraft.util.RandomSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RandHelper {
	private RandHelper() {}

	@SuppressWarnings("squid:S1764") // this actually isn't a case of identical values being used as both side are random float value thus -1 to 1 as a result
	public static float getRandomMinusOneToOne(RandomSource rand) {
		return rand.nextFloat() - rand.nextFloat();
	}

	public static <T> List<T> getNRandomElements(List<T> input, int numberOfElements) {
		if (input.size() == numberOfElements) {
			return input;
		}

		ArrayList<T> randomizedList = new ArrayList<>(input);
		List<T> ret = new ArrayList<>();
		Collections.shuffle(randomizedList);
		for (int i = 0; i < randomizedList.size() && i < numberOfElements; i++) {
			ret.add(randomizedList.get(i));
		}
		return ret;
	}

	public static <T> Optional<T> getRandomWeightedElement(RandomSource random, List<WeightedElement<T>> weightedElements) {
		int totalWeight = 0;
		for (WeightedElement<T> weightedElement : weightedElements) {
			int weight = weightedElement.getWeight();
			if (weight < 0) {
				throw new IllegalArgumentException("Negative weight element passed in");
			}
			totalWeight += weight;
		}
		if (totalWeight == 0) {
			throw new IllegalArgumentException("Map passed in is either empty or the only element has 0 weight");
		}

		int rndValue = random.nextInt(totalWeight + 1);

		for (WeightedElement<T> weightedElement : weightedElements) {
			rndValue -= weightedElement.getWeight();
			if (rndValue <= 0) {
				return Optional.of(weightedElement.getElement());
			}
		}
		return Optional.empty();
	}

}
