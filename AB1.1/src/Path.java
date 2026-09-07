public class Path {

    private int currentPos = 0;
    private Vector[] vectors = new Vector[0];

    public void add(Vector vector) {
        Vector[] temp = new Vector[vectors.length+1];

        for (int i = 0; i < vectors.length; i++) {
            temp[i] = vectors[i];
        }

        temp[temp.length-1] = vector;
        vectors = temp;
    }

    public Vector next() {
        if (currentPos >= vectors.length) {
            System.out.println("No more vectors to get");
            return null;
        }

        return vectors[currentPos++];
    }

    static void main() {
        Path p = new Path();

        p.add(new Vector(2));

        p.next();
        p.next();

        p.add(new Vector(2));

        p.next();
        System.out.println("A");
        p.next();
    }
}
