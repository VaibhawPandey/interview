package com.interview.codingblocks.week1;

//https://codingblocks.com/resources/unique-3-no/

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UniqueNumberIII {

    static class FastReader {
        private final InputStream is = System.in;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public FastReader() {
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.is.read(this.buf);
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }

        public String nextLine() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isEndOfLine(c = read()));
            return res.toString();
        }

        public String nextString() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isSpaceChar(c = read()));
            return res.toString();
        }

        public long nextLong() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            boolean f = true;
            if (c == '-') {
                f = false;
                c = read();
            }
            long res = 0;
            do {
				/*if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}*/
                res = res * 10 + (c - '0');
            } while ((c = read()) >= '0' && c <= '9');
            return f ? res : -res;
        }

        public int nextInt() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            boolean f = true;
            if (c == '-') {
                f = false;
                c = read();
            }
            int res = 0;
            do {
				/*if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}*/
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return f ? res : -res;
        }

        public double nextDouble1() {
            double ret = 0, div = 1;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() {
            return Double.parseDouble(nextString());
            // return FloatingDecimal.parseDouble(nextString());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(nextString(), 10);
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(nextString());
        }

        public int[] nextArray(final int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArray(final int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        public char[] nextCharArray(final int n) {
            final char[] bf = new char[n];
            int b, p = 0;
            while (isSpaceChar(b = read())) {
            }
            while (p < n && !isSpaceChar(b)) {
                bf[p++] = (char) b;
                b = read();
            }
            return n == p ? bf : Arrays.copyOf(bf, p);
        }

        public char[][] nextMatrix(final int n, final int m) {
            final char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextCharArray(m);
            }
            return map;
        }

        public int[][] nextIntMatrix(final int n, final int m) {
            final int[][] map = new int[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextArray(m);
            }
            return map;
        }

        public long[][] nextLongMatrix(final int n, final int m) {
            final long[][] map = new long[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextLongArray(m);
            }
            return map;
        }

        public boolean isSpaceChar(final int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(final int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
    public static void main( String[] args ) {
       // int a[] = {7, 7, 3, 4, 12, 6, 6, 6, 3, 3, 4, 4, 7};

        Scanner scanner = new Scanner(System.in);

        System.out.println(findUnique(nextArray(scanner.nextInt())));
    }

    private static int[] nextArray( final int n ) {
       FastReader scanner = new FastReader();

        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }

    private static int findUnique( int[] a ) {
        int cnt[] = new int[64];

        for (int anA : a) {
            ///Extract Bits of Every Number and update the count array

            int i = 0;
            int no = anA;
            while (no > 0) {

                //if bit position is set then increment the count[] index value
                cnt[i] += (no & 1); // where (no & 1) extract last bit of number
                i++;

                //equals to number divide by 2
                no = no >> 1;
            }

        }
        /// Take mod of cnt array index value with 3
        int p = 1;
        int ans = 0;
        for (int i = 0; i < 64; i++) {
            cnt[i] %= 3;

            //converting binary into decimal as : 2^4 2^2 2^0
            ans += cnt[i] * p;

            //same as p*=2 such that power value increases of 2^1 -> 2^2. That's why p=1 initially.
            p = p << 1;
        }
        return ans;
    }
}
