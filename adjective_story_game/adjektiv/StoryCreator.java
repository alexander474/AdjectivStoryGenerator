import java.util.*;
/**
 * Makes an adjectiv story
 * Takes a story and changes the word "ADJEKTIV" with wither a input word or
 * a random word from a list
 */
public class StoryCreator
{
    private InputReader reader;
    private OutputWriter writer;
    private Random random;

    public StoryCreator()
    {
        reader = new InputReader();
        writer = new OutputWriter();
        random = new Random();
    }

    /**
      * Creates a story and changes the word "ADJEKTIV" with a random adjective
       */
    public void createAdjectiveStory(String storyFilename,
                  String adjectivesFilename, String outputFilename)
    {
        ArrayList<String> story = reader.getWordsInFile(storyFilename); 
        ArrayList<String> adjective = reader.getWordsInFile(adjectivesFilename);
        
        createStoryFromLists(story, adjective, outputFilename);
    }

    /**
      * Creates a story and changes the word "ADJEKTIV" with a input word from scanner
       */
    public void createAdjectiveStory(String storyFilename, String outputFilename)
    {
        ArrayList<String> story;           
        story = reader.getWordsInFile(storyFilename);
        
        Scanner sc = new Scanner(System.in);
           for(int i = 0; i < story.size(); i++) {
            String word = story.get(i);
            if(word.contains("ADJEKTIV")){
                System.out.println("Write [exit] if you are done");
                System.out.println("Please enter an adjective: ");
                String adj = sc.nextLine();
                if(adj.equals("exit")){
                    System.exit(0);
                }
                story.set(i, adj);
                writer.write(story, outputFilename);
            }
           }
        //writer.write(story, outputFilename);
    }

    /**
      * Creates a list with adjectives from a full wordlists and changes
      * the word "ADJEKTIV" with a random adjective from the new made 
      * list with adjectives.
       */
    public void createAdjectiveStoryFromDictionary(String storyFilename, String dictionaryFilename, String outputFilename)
    {
        ArrayList<String> story = reader.getWordsInFile(storyFilename);
        ArrayList<String> wordlist = reader.getWordsInFile(dictionaryFilename);
        ArrayList<String> adjective = new ArrayList<>();
        
        //walk through every other word in the list
           for(int i = 0; i < wordlist.size(); i+=2){
            String word = wordlist.get(i);
            String type = wordlist.get(i+1);
            
            if(type.equals("adj")){
                adjective.add(word);
            }
           }
        createStoryFromLists(story, adjective, outputFilename);
    }
    
    /**
      * Changes the word from a txt with a new word from another txt
      * Changes the word "ADJEKTIV" with an random word from a list.
       */
    private void createStoryFromLists(ArrayList<String> story, ArrayList<String> adjective,
                                     String outputFilename){
        for(int i = 0; i < story.size(); i++) {
            String word = story.get(i);
            if(word.contains("ADJEKTIV")){
                // makes a random int betwen 0 and max words in list
                int ix = random.nextInt(adjective.size());
                String adj = adjective.get(ix);
                story.set(i, adj);
            }
           }
        writer.write(story, outputFilename);
    }

}
