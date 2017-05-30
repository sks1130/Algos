import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import io.swagger.models.auth.In;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class Tetris{
	
	static class Shape {
		    enum Tetrominoes { NoShape, ZShape, SShape, LineShape, 
		               TShape, SquareShape, LShape, MirroredLShape };

		    private Tetrominoes pieceShape;
		    private int coords[][];
		    private int[][][] coordsTable;
		    public Shape() {
		        coords = new int[4][2];
		        setShape(Tetrominoes.NoShape);
		    }

		    public void setShape(Tetrominoes shape) {
		         coordsTable = new int[][][] {
		            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
		            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
		            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
		            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
		            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
		            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
		            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
		            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
		        };
		        for (int i = 0; i < 4 ; i++) {
		            for (int j = 0; j < 2; ++j) {
		                coords[i][j] = coordsTable[shape.ordinal()][i][j];
		            }
		        }
		        pieceShape = shape;

		    }

		    private void setX(int index, int x) { coords[index][0] = x; }
		    private void setY(int index, int y) { coords[index][1] = y; }
		    public int x(int index) { return coords[index][0]; }
		    public int y(int index) { return coords[index][1]; }
		    public Tetrominoes getShape()  { return pieceShape; }

		    public void setRandomShape(){
		    	Random r = new Random();
		    	int x = Math.abs(r.nextInt()) % 7 + 1;
		    	Tetrominoes[] values = Tetrominoes.values(); 
		    	setShape(values[x]);
		    }

		    public int minX(){
		    	int m = coords[0][0];
		    	for (int i=0; i < 4; i++) {
		    		m = Math.min(m, coords[i][0]);
		    	}
		    	return m;
		    }


		    public int minY(){
		    	int m = coords[0][1];
		    	for (int i=0; i < 4; i++) {
		    		m = Math.min(m, coords[i][1]);
		    	}
		    	return m;
		    }

		    public Shape rotateLeft(){
		        if (pieceShape == Tetrominoes.SquareShape)
		            return this;
		        Shape result = new Shape();
		        result.pieceShape = pieceShape;
		        for (int i = 0; i < 4; ++i) {
		            result.setX(i, y(i));
		            result.setY(i, -x(i));
		        }
		        return result;
		    }

		    public Shape rotateRight(){
		    	if (pieceShape == Tetrominoes.SquareShape)
		    		return this;
		    	Shape result = new Shape();
		    	result.pieceShape = pieceShape;
		    	for (int i = 0; i < 4; ++i) {
		    		result.setX(i, -y(i));
		    		result.setY(i, x(i));
		    	}
		    	return result;
		    }
		}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(21);
		list.add(111);
		list.add(311);
		list.add(2331);
		list.add(23111);
		list.add(1);
//		list.add(23);
//		list.add(11);
//		list.add(9);
//		list.add(7);
//		list.add(2);
		//System.out.println(list.parallelStream().sorted().collect(Collectors.toList()).equals(list));
		List<Integer> listNew  = new ArrayList<>(list);
		
		System.out.println(isSorted(list));
		
	}
	public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
		if(list == null || list.isEmpty()){
			return false;
		}
		if(list.size() == 1) {
			return true;
		}
		T prev =null;
		boolean asc = true;
		boolean desc = true;
		for (T t : list) {
			//ascending
			if(prev!=null && prev.compareTo(t) > 0 ){
				asc = false;
			} 
			//descending
			if(prev!=null && prev.compareTo(t) < 0 ){
				desc = false;
			}
			prev  = t;
		}
		return asc || desc;
	}
}


