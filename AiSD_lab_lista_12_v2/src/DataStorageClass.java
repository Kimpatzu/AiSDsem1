public class DataStorageClass {
    private int[] colour;
    private int[] p;
    private int[] t;
    private int time;
    private String output;

    public DataStorageClass( int[] colour, int[] p, int[] t, int time, String output) {
        this.colour = colour;
        this.p = p;
        this.t = t;
        this.time = time;
        this.output = output;
    }

    public int[] getColour() {
        return colour;
    }

    public void setColour(int[] colour) {
        this.colour = colour;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

    public int[] getT() {
        return t;
    }

    public void setT(int[] t) {
        this.t = t;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    //(Graph G, int indexOfU, int[] colour, int[] p, int[] t, int time)
}
