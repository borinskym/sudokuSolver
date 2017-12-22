import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {

    private final int numOfRows = 9;
    private final int numOfCols = 9;
    private final int minimumNumber = 1;
    private final int maxNumber = 10;
    private List<List<Integer>> sudoku;

    public SudokuSolver(List<List<Integer>> sudoku) {
        this.sudoku = sudoku;

    }

    public List<List<Integer>> solve() {
        Pair<Integer, Integer> indexOfNotSolved = findIndexOfNotSolved();
        List<List<Integer>> sudokuCandidate = getEmptySuduku();

        for(int numberToFill = 1; !(verifySudoku(sudokuCandidate)); numberToFill ++)
            sudokuCandidate = fillNumberOnUnsolvedSudoku(indexOfNotSolved, numberToFill++);


        return sudokuCandidate;

    }

    private boolean verifySudoku(List<List<Integer>> sudokuCandidate) {
        return new SudokuVerifier(sudokuCandidate).verifySudoku();
    }

    private List<List<Integer>> fillNumberOnUnsolvedSudoku(Pair<Integer, Integer> indexOfNotSolved, int numberToFill) {
        List<List<Integer>> sudokuCandidate = getEmptySuduku();

        for(int row = 0; row < numOfRows; row++)
            for(int col = 0; col < numOfCols; col++)
                    sudokuCandidate.get(row).set(col, isIndexesMatchesPair(indexOfNotSolved, row, col) ?
                            numberToFill : sudoku.get(row).get(col));

        return sudokuCandidate;
    }

    private boolean isIndexesMatchesPair(Pair<Integer, Integer> indexOfNotSolved, int row, int col) {
        return row == indexOfNotSolved.fst && col == indexOfNotSolved.snd;
    }

    private List<List<Integer>> getEmptySuduku() {
        List<List<Integer>> sudokuCandidate = new ArrayList<>();
        for(int candidateRow = 0; candidateRow < numOfRows; candidateRow++){
            sudokuCandidate.add(newEmptyRow());
        }
        return sudokuCandidate;
    }

    private ArrayList<Integer> newEmptyRow() {
        return new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0));
    }

    protected Pair<Integer, Integer> findIndexOfNotSolved() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku.get(i).get(j) == -1){
                    return new Pair<>(i, j);
                }
            }
        }

        return null;
    }
}
