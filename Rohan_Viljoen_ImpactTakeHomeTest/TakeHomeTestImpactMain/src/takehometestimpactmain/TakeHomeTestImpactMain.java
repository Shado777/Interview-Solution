package takehometestimpactmain;

/**
 *
 * @author viljo
 */
public class TakeHomeTestImpactMain {
    

    //Main method for calling the NumberRangeImplementation class
    public static void main(String[] args){
        

        String output;
        String input = "1,3,6,17,8,12,13,14,15,21,22,23,24,31";
        
        NumberRangeImplementation implement = new NumberRangeImplementation();
        
        output = implement.summarizeCollection(implement.collect(input));
        System.out.println(output);
    }
    
}
