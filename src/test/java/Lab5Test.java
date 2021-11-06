import junit.framework.TestCase;

public class Lab5Test extends TestCase {

    public void testDisplay() {
        String text = "Lorem Ipsum is simply dummy text of the printing and " +
                "typesetting industry. Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s, when an unknown " +
                "printer took a galley of type and scrambled it to make a type " +
                "specimen book. It has survived not only five centuries, but also" +
                " the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing " +
                "Lorem Ipsum passages, and more recently with desktop publishing software like " +
                "Aldus PageMaker including versions of Lorem Ipsum.";

        String expectedText = "Lorem typesetting is simply dummy text of the printing and Ipsum industry." +
                " Lorem industry's has been the Ipsum standard dummy text ever since the 1500s when an " +
                "unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " typesetting has survived not only five centuries but also the leap into electronic It " +
                "remaining essentially unchanged. popularised was It in the 1960s with the release of Letraset " +
                "sheets containing Lorem Ipsum passages and more recently with desktop publishing software " +
                "like Aldus PageMaker including versions of Lorem Ipsum.";

        expectedText.equals(Lab5.display(text));

        String secondText = " ";

        Lab5.display(secondText).equals("Seem's like your text is blank");

    }

    public void testPrepareOneSentence() {
        String sentence = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        String expected = "Lorem typesetting is simply dummy text of the printing and Ipsum industry.";

        expected.equals(Lab5.prepareOneSentence(sentence));

        String secondSentence = "Sentence without word that start with vowel";

        secondSentence.equals(Lab5.prepareOneSentence(sentence));
    }

    public void testFindInArray() {
        String[] array = {"Sun", "Moon", "Star"};
        assertEquals(1, Lab5.findInArray(array, "Moon"));
    }
}