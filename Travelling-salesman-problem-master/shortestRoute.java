package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class shortestRoute {
	TreeMap<Double, Integer> outOne = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outTwo = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outThree = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outFour = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outFive = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outSix = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outSeven = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outEight = new TreeMap<Double, Integer>();
	TreeMap<Double, Integer> outNine = new TreeMap<Double, Integer>();
	

	List<TreeMap<Double, Integer>> all = new ArrayList<TreeMap<Double, Integer>>(){{
		add(outOne);
		add(outTwo);
		add(outThree);
		add(outFour);
		add(outFive);
		add(outSix);
		add(outSeven);
		add(outEight);
		add(outNine);
	}};

	List<Integer> pathNodes = new ArrayList<Integer>();
	List<Double> minPath = new ArrayList<Double>();
	List<Double> latPoints = new ArrayList<Double>();
	List<Double> lngPoints = new ArrayList<Double>();
	
	
	public shortestRoute(){
		pathNodes.add(1);
		innitialize();
		pathFinder();
	}
	
	private void formatPoints(double lat, double lng){
		latPoints.add(lat);
		lngPoints.add(lng);
	}
	
	private void storeDistances(TreeMap<Double, Integer> node,int nodeNumber){
		
		
	}
	
	private double calcDistance(double x1, double y1,double x2, double y2){
		return Math.sqrt((x2-x1)+(y2-y1));
	}
	
	private void innitialize(){
		//outOne.put(0.0,1);
		outOne.put(2.0,2);
		outOne.put(5.25,3);
		outOne.put(4.0,4);
		outOne.put(6.5,5);
		outOne.put(6.5,6);
		outOne.put(5.0,7);
		outOne.put(6.0,8);
		outOne.put(9.0,9);
		
		outTwo.put(2.0,1);
		//outTwo.put(0.0,2);
		outTwo.put(2.5,3);
		outTwo.put(3.5,4);
		outTwo.put(4.75,5);
		outTwo.put(5.5,6);
		outTwo.put(5.0,7);
		outTwo.put(4.5,8);
		outTwo.put(6.0,9);
		
		outThree.put(5.25,1);
		outThree.put(2.5,2);
		//outThree.put(0.0,3);
		outThree.put(3.0,4);
		outThree.put(2.0,5);
		outThree.put(3.5,6);
		outThree.put(5.0,7);
		outThree.put(3.0,8);
		outThree.put(4.0,9);
		
		outFour.put(4.0,1);
		outFour.put(3.5,2);
		outFour.put(3.0,3);
		//outFour.put(0.0,4);
		outFour.put(4.0,5);
		outFour.put(3.0,6);
		outFour.put(2.0,7);
		outFour.put(6.0,8);
		outFour.put(6.25,9);
		
		outFive.put(6.5,1);
		outFive.put(4.75,2);
		outFive.put(2.0,3);
		outFive.put(4.0,4);
		//outFive.put(0.0,5);
		outFive.put(3.0,6);
		outFive.put(6.0,7);
		outFive.put(3.0,8);
		outFive.put(2.0,9);
		
		outSix.put(6.5,1);
		outSix.put(5.5,2);
		outSix.put(3.5,3);
		outSix.put(3.0,4);
		outSix.put(3.5,5);
		//outSix.put(0.0,6);
		outSix.put(3.5,7);
		outSix.put(6.0,8);
		outSix.put(5.0,9);
		
		outSeven.put(5.0,1);
		outSeven.put(5.0,2);
		outSeven.put(5.0,3);
		outSeven.put(2.0,4);
		outSeven.put(6.0,5);
		outSeven.put(3.5,6);
		//outSeven.put(0.0,7);
		outSeven.put(9.0,8);
		outSeven.put(9.0,9);
		
		outEight.put(6.0,1);
		outEight.put(4.5,2);
		outEight.put(3.0,3);
		outEight.put(6.25,4);
		outEight.put(3.0,5);
		outEight.put(6.0,6);
		outEight.put(9.0,7);
		//outEight.put(0.0,8);
		outEight.put(2.5,9);
		
		outNine.put(9.0,1);
		outNine.put(6.0,2);
		outNine.put(4.0,3);
		outNine.put(6.25,4);
		outNine.put(2.0,5);
		outNine.put(5.0,6);
		outNine.put(9.0,7);
		outNine.put(2.0,8);
		//outNine.put(0.0,9);
		
	}
	private void pathFinder(){
		int nextPointNode = 0;
		while(true){
			TreeMap<Double, Integer> currentNode = all.get(nextPointNode);
		
			System.err.println("\n"+ "out "+ (nextPointNode+1) +": \n");
			printTreeMap(currentNode);

			Map.Entry<Double,Integer> entry = getNextEntry(currentNode);
			pathNodes.add(entry.getValue());
			minPath.add(entry.getKey());
			nextPointNode = entry.getValue() - 1;
			
			if(pathNodes.size()==9){
				break;
			}
		}
	}
	
	private Map.Entry<Double,Integer> getNextEntry(TreeMap<Double, Integer> node){
		Map.Entry<Double,Integer> firstEntry = getFirstEntry(node);
		if(isInPath(firstEntry.getValue())){
			node.remove(firstEntry.getKey());
			return getNextEntry(node);
		}
		else{
			printTreeMap(node);
			return firstEntry;
		}
		
	}
	
	private void printTreeMap(TreeMap<Double, Integer> tm){
		for (double treeKey : tm.keySet()){
			System.out.println("("+treeKey+"," + tm.get(treeKey)+")");
		}
		System.out.println("\n");
	}
	private boolean isInPath(int pointNode){
		
		return (pathNodes.contains(pointNode));
	}
	
	private Map.Entry<Double,Integer> getFirstEntry(TreeMap<Double, Integer> node){
		return node.firstEntry();
	}
	
	public double getTotalDistance(){
		double total = 0;
		for(int d = 0; d < 8; d++){
			total+=minPath.get(d);
		}
		return total;
	}
	
	public void printPathNodes(){
		for(int i=0;i<pathNodes.size();i++){
			System.out.println(pathNodes.get(i));
		}
	}

	public static void main(String[] args) {
		shortestRoute sr = new shortestRoute();
		sr.printPathNodes();
		
	}

}
