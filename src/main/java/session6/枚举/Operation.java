package session6.枚举;

public enum Operation {
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };
    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        int x = 4;
        int y = 3;
        System.out.println(Operation.PLUS.eval(x, y));
        System.out.println(Operation.MINUS.eval(x, y));
        System.out.println(Operation.TIMES.eval(x, y));
        System.out.println(Operation.DIVIDE.eval(x, y));
    }
}
