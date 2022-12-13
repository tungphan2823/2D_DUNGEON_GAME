package main;
public class level {
    private int[][] lvlData;
    public level(int[][] lvlData){
        this.lvlData = lvlData;
    }
    public int getIndex(int x, int y){
        return lvlData[y][x];
    }
    public int[][] getData(){
        return lvlData;
    }
}
