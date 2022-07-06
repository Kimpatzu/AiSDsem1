public class Edge {
    private int firstVerticeNumber;
    private int secondVerticeNumber;
    private int wieght;

    public Edge(int firstVerticeNumber, int secondVerticeNumber, int wieght) {
        this.firstVerticeNumber = firstVerticeNumber;
        this.secondVerticeNumber = secondVerticeNumber;
        this.wieght = wieght;
    }

    public int getFirstVerticeNumber() {
        return firstVerticeNumber;
    }

    public void setFirstVerticeNumber(int firstVerticeNumber) {
        this.firstVerticeNumber = firstVerticeNumber;
    }

    public int getSecondVerticeNumber() {
        return secondVerticeNumber;
    }

    public void setSecondVerticeNumber(int secondVerticeNumber) {
        this.secondVerticeNumber = secondVerticeNumber;
    }

    public int getWieght() {
        return wieght;
    }

    public void setWieght(int wieght) {
        this.wieght = wieght;
    }

    public String toString(){
        return (firstVerticeNumber+1) + " " + (secondVerticeNumber+1) + " " + wieght;
    }
}
