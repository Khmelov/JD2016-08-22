package by.it.voronovich.MathLab;

public class UnsupportedException extends Exception{

        public UnsupportedException() {
        }

        public UnsupportedException(String message) {
            super(message);
        }

        public UnsupportedException(Throwable exception) {
            super(exception);
        }

        public UnsupportedException(String message, Throwable exception) {
            super(message, exception);
        }

    }