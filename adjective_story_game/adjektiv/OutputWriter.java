import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for writing information to a file.
 * 
 * @author (Per Lauvås & Tor-Morten Grønli) 
 * @version (2.0)
 */
public class OutputWriter
{

    /**
     * Constructor for objects of class OutputWriter
     */
    public OutputWriter()
    {
    }

    /**
     * Writes a list of words to a file. The words are separated by the 'space' character.
     * 
     * @param  output   the list of words
     * @param  filename   the name of the output file
     */
    public void write(ArrayList<String> output, String filename)
    {
        try {
            FileWriter out = new FileWriter(filename);
            for(String word : output) {
                out.write(word + " ");
            }
            out.close();
        }
        catch(IOException exc) {
            System.out.println("Error writing output file: " + exc);
        }

    }
}
