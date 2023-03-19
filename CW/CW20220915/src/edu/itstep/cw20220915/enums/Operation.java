package edu.itstep.cw20220915.enums;

public enum Operation {
    SUM {
        public double action(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT{
        public double action(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY{
        public double action(double x, double y) {
            return x * y;
        }
    },
    DIVISION{
        public double action(double x, double y) {
            // потрібна перевірка ділення на 0 !!!
            return x / y;
        }
    };

    public abstract double action(double x, double y);
}
