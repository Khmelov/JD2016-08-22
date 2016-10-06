package by.it.shkantau.mathlab.calc.exceptions;

public class MathLabException extends Exception{

        public static final byte WRONG_FORMAT_STRING = 1;
    
        private byte errorCode;

        public MathLabException(){
        }

        public MathLabException(String message){
            super(message);
        }

        public MathLabException(String message, byte errorCode){
            super(message);
            this.errorCode = errorCode;
        }

        public byte getErrorCode(){
            return errorCode;
        }
    
}
