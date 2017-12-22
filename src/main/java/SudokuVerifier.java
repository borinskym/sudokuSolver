import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SudokuVerifier {
    private final int numberOfRows = 9;
    private final int numbersInEachLine = 9;
    private final int numberOfRowsInSquare = 3;
    private final int numberOfColsInSquare = 3;
    private List<List<Integer>> sudoku;

    public SudokuVerifier(List<List<Integer>> sudoku) {
        this.sudoku= sudoku;
    }

    public boolean verifySudoku() {

        return verifyColumns() && verifyRows() && verifySquares();
    }

    private boolean verifySquares() {

        return getAllSquares().stream().allMatch(this::verifyAllNumbersExistWithoutDuplications);
    }

    private List<List<Integer>> getAllSquares() {
        List<List<Integer>> squares = new ArrayList<>();

        for(int row = 0; row < numberOfRowsInSquare; row += 3)
            for(int col = 0; col < numberOfColsInSquare; col += 3)
                squares.add(ListUtils.union(getSqaureLine(row, col),
                        ListUtils.union(getSqaureLine(row + 1, col), getSqaureLine(row + 2, col))));

        return squares;
    }

    private List<Integer> getSqaureLine(int i, int j) {

        List<Integer> lst = new ArrayList<>();
        lst.add(sudoku.get(i).get(j));
        lst.add(sudoku.get(i).get(j + 1));
        lst.add(sudoku.get(i).get(j + 2));

        return lst;
    }

    private boolean verifyRows() {
        return sudoku.stream().allMatch(this::verifyAllNumbersExistWithoutDuplications);
    }

    private boolean verifyColumns() {

        List<List<Integer>> colums = makeColumsFromSudoku(sudoku);

        return colums.stream().allMatch(this::verifyAllNumbersExistWithoutDuplications);
    }

    private List<List<Integer>> makeColumsFromSudoku(List<List<Integer>> sudoku) {
        List<List<Integer>> cols = new ArrayList<>();

        for(AtomicInteger i = new AtomicInteger(0); i.get() < numberOfRows; i.incrementAndGet()) {
            cols.add(sudoku.stream().map(line -> line.get(i.get()))
                    .collect(Collectors.toList()));
        }
        return cols;

    }

    public boolean verifyAllNumbersExistWithoutDuplications(List<Integer> row) {
        Set<Integer> nums = new HashSet<>(row);

        return nums.size() == numbersInEachLine &&
                nums.stream().allMatch(number -> number < 10 && number > 0);
    }
}
