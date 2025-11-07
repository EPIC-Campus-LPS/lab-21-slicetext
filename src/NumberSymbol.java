public class NumberSymbol implements Symbol{
    public int value;

    public NumberSymbol(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        return value == ((NumberSymbol) o).value;
    }
}
