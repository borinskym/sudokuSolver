import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuVerifierTest {


    private static final List<List<Integer>> validSudoku = makeValidSudoku();

    private static final List<List<Integer>> notValidSudoku = makeNotValidSudoku();


    @Test
    public void shouldVerifyRightSudoku() throws Exception {
        assertTrue(new SudokuVerifier(validSudoku).verifySudoku());
    }

    @Test
    public void shouldReturnFalseWhenNotValid() {

        assertFalse(new SudokuVerifier(notValidSudoku).verifySudoku());

        assertFalse(new SudokuVerifier(makeNotValidSudokuInSquares()).verifySudoku());
    }

    private  static List<List<Integer>> makeValidSudoku() {
        return Arrays.asList(Arrays.asList(4,3,5,2,6,9,7,8,1),
                Arrays.asList(6,8,2,5,7,1,4,9,3),
                Arrays.asList(1,9,7,8,3,4,5,6,2),
                Arrays.asList(8,2,6,1,9,5,3,4,7),
                Arrays.asList(3,7,4,6,8,2,9,1,5),
                Arrays.asList(9,5,1,7,4,3,6,2,8),
                Arrays.asList(5,1,9,3,2,6,8,7,4),
                Arrays.asList(2,4,8,9,5,7,1,3,6),
                Arrays.asList(7,6,3,4,1,8,2,5,9));
    }

    private  static List<List<Integer>> makeNotValidSudoku() {
        return Arrays.asList(
                Arrays.asList(4,3,5,2,6,9,7,8,1),
                Arrays.asList(6,8,2,5,7,1,4,9,3),
                Arrays.asList(1,9,7,8,3,4,5,6,2),
                Arrays.asList(8,2,6,1,9,5,3,4,7),
                Arrays.asList(3,7,4,6,8,2,9,5,1),
                Arrays.asList(9,5,1,7,4,3,6,2,8),
                Arrays.asList(5,1,9,3,2,6,8,7,4),
                Arrays.asList(2,4,8,9,5,7,1,3,6),
                Arrays.asList(7,6,3,4,1,8,2,5,9));
    }

    private  static List<List<Integer>> makeNotValidSudokuInSquares() {
        return Arrays.asList(
                Arrays.asList(4,3,5,2,6,9,7,8,1),
                Arrays.asList(6,8,2,5,7,1,4,9,3),
                Arrays.asList(8,2,6,1,9,5,3,4,7),
                Arrays.asList(1,9,7,8,3,4,5,6,2),
                Arrays.asList(3,7,4,6,8,2,9,1,5),
                Arrays.asList(9,5,1,7,4,3,6,2,8),
                Arrays.asList(5,1,9,3,2,6,8,7,4),
                Arrays.asList(2,4,8,9,5,7,1,3,6),
                Arrays.asList(7,6,3,4,1,8,2,5,9));
    }






}
