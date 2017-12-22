import com.sun.tools.javac.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SudokuSolverTest {

    @Test
    public void getFirstIndexNotSolved() throws Exception {

        assertThat(new SudokuSolver(sudokuSolvedExeptOne()).findIndexOfNotSolved()
        , is(new Pair<>(8, 8)));


    }

    @Test
    public void solveBasic() throws Exception {
        List<List<Integer>> sudoku = sudokuSolvedExeptOne();
        //assertSudokuSolved(sudoku, sudokuSolved());

        assertSudokuSolved(sudokuAlmostSolvedExeptTwo(), sudokuSolved());
    }




    private void assertSudokuSolved(List<List<Integer>> sudoku, List<List<Integer>> solved) {
        assertThat(new SudokuSolver(sudoku).solve(),
                is(solved));
    }

    private  static List<List<Integer>> sudokuSolvedExeptOne() {
        return Arrays.asList(Arrays.asList(4,3,5,2,6,9,7,8,1),
                Arrays.asList(6,8,2,5,7,1,4,9,3),
                Arrays.asList(1,9,7,8,3,4,5,6,2),
                Arrays.asList(8,2,6,1,9,5,3,4,7),
                Arrays.asList(3,7,4,6,8,2,9,1,5),
                Arrays.asList(9,5,1,7,4,3,6,2,8),
                Arrays.asList(5,1,9,3,2,6,8,7,4),
                Arrays.asList(2,4,8,9,5,7,1,3,6),
                Arrays.asList(7,6,3,4,1,8,2,5,-1));
    }

    private  static List<List<Integer>> sudokuAlmostSolvedExeptTwo() {
        return Arrays.asList(Arrays.asList(4,3,5,2,6,9,7,8,1),
                Arrays.asList(6,8,2,5,7,1,4,9,3),
                Arrays.asList(1,9,7,8,3,4,5,6,2),
                Arrays.asList(8,2,6,1,9,5,3,4,7),
                Arrays.asList(3,7,4,6,8,2,9,1,5),
                Arrays.asList(9,5,1,7,4,3,6,2,8),
                Arrays.asList(5,1,9,3,2,6,8,7,4),
                Arrays.asList(2,4,8,9,5,7,1,3,6),
                Arrays.asList(7,6,3,4,1,8,2,-1,-1));
    }

    private  static List<List<Integer>> sudokuSolved() {
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


}
