package eu.deltasource.hangman;

import java.util.ArrayList;
import java.util.List;

public class BagOfWords {
    private final List<String> wordList;

    public BagOfWords() {
        this.wordList = new ArrayList<>();
        initializeWordList();
    }

    private void initializeWordList() {
        wordList.add("abandon");
        wordList.add("balance");
        wordList.add("capture");
        wordList.add("delivery");
        wordList.add("embrace");
        wordList.add("festival");
        wordList.add("glorious");
        wordList.add("history");
        wordList.add("invisible");
        wordList.add("journey");
        wordList.add("kangaroo");
        wordList.add("language");
        wordList.add("medicine");
        wordList.add("narrate");
        wordList.add("observe");
        wordList.add("paradise");
        wordList.add("question");
        wordList.add("radiant");
        wordList.add("sculptor");
        wordList.add("trouble");
        wordList.add("universe");
        wordList.add("venture");
        wordList.add("wonder");
        wordList.add("xylophone");
        wordList.add("yardstick");
        wordList.add("zeppelin");
        wordList.add("awesome");
        wordList.add("buzzard");
        wordList.add("clapper");
        wordList.add("dormant");
        wordList.add("eloquent");
        wordList.add("frosted");
        wordList.add("grazing");
        wordList.add("hillside");
        wordList.add("ignition");
        wordList.add("jubilant");
        wordList.add("knapsack");
        wordList.add("luxury");
        wordList.add("meander");
        wordList.add("nomadic");
        wordList.add("overture");
        wordList.add("pioneer");
        wordList.add("abandon");
        wordList.add("balance");
        wordList.add("capture");
        wordList.add("delivery");
        wordList.add("embrace");
        wordList.add("festival");
        wordList.add("glorious");
        wordList.add("history");
        wordList.add("invisible");
        wordList.add("journey");
        wordList.add("kangaroo");
        wordList.add("language");
        wordList.add("medicine");
        wordList.add("narrate");
        wordList.add("observe");
        wordList.add("paradise");
        wordList.add("question");
        wordList.add("radiant");
        wordList.add("sculptor");
        wordList.add("trouble");
        wordList.add("universe");
        wordList.add("venture");
        wordList.add("wonder");
        wordList.add("xylophone");
        wordList.add("yardstick");
        wordList.add("zeppelin");
        wordList.add("awesome");
        wordList.add("buzzard");
        wordList.add("clapper");
        wordList.add("dormant");
        wordList.add("eloquent");
        wordList.add("frosted");
        wordList.add("grazing");
        wordList.add("hillside");
        wordList.add("ignition");
        wordList.add("jubilant");
        wordList.add("knapsack");
        wordList.add("luxury");
        wordList.add("meander");
        wordList.add("nomadic");
        wordList.add("overture");
        wordList.add("pioneer");
        wordList.add("quality");
        wordList.add("ravishing");
        wordList.add("serenity");
        wordList.add("traverse");
        wordList.add("uplifting");
        wordList.add("verdant");
        wordList.add("whisper");
        wordList.add("xenon");
        wordList.add("yearning");
        wordList.add("zephyr");
        wordList.add("aquatic");
        wordList.add("bewitch");
        wordList.add("cascade");
        wordList.add("delicate");
        wordList.add("ephemeral");
        wordList.add("frivolous");
        wordList.add("glistening");
        wordList.add("harmony");
        wordList.add("imagine");
        wordList.add("jubilation");
        wordList.add("kaleidoscope");
        wordList.add("luminous");
        wordList.add("mystical");
        wordList.add("nurturing");
        wordList.add("opulent");
        wordList.add("pristine");
        wordList.add("quixotic");
        wordList.add("resplendent");
        wordList.add("serendipity");
        wordList.add("tranquil");
        wordList.add("unfolding");
        wordList.add("velvet");
        wordList.add("whimsical");
        wordList.add("xanadu");
        wordList.add("yearnful");
        wordList.add("zestful");
    }

    public void addWord(String word) {
        wordList.add(word);
    }

    public String getRandomWord() {
        if (wordList.isEmpty()) {
            throw new IllegalStateException("Word list is empty. Add words before requesting.");
        }

        int randomIndex = (int) (Math.random() * wordList.size());
        return wordList.get(randomIndex);
    }
}
