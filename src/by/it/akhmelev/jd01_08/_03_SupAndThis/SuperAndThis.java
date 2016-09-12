package by.it.akhmelev.jd01_08._03_SupAndThis;

public class SuperAndThis {

    class Point1D {
        private int x;
        Point1D(int x) {
            this.x = x;
        }
    }
    class Point2D extends Point1D {
        private int y;
        Point2D(int x, int y) {
            super(x);
            this.y = y;
        }
    }
    public class Point3D extends Point2D {
        private int z;
        public Point3D(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }
    }

}
