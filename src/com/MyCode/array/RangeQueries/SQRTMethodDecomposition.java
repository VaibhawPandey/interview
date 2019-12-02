package com.MyCode.array.RangeQueries;

public class SQRTMethodDecomposition {

    static int blk_size;

    public static void main(String[] args) {
        int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
        int n = input.length;

        blk_size = (int) Math.sqrt(n);

        Query(input, 0, 6);
    }

    private static void Query(int input[], int left, int right) {

        int block[];
        if (input.length % blk_size != 0)
            block = new int[blk_size + 1];
        else
            block = new int[blk_size];

        block = populateBlockValue(input, block);

        for (int i = 0; i < block.length; i++)
            System.out.println(block[i]);

        int sum=0;
        for (int i = left; i <= right; i++) {
            if(i%blk_size == 0 && right>= (i+blk_size)){
                int blockPos=i/blk_size;
                sum += block[blockPos];
                i += blk_size-1;
            }else
                sum += input[i];
        }

        System.out.println(sum);
    }

    private static int[] populateBlockValue(int input[], int[] block) {

        int blockCount = -1;
        for (int i = 0; i < input.length; i++) {
            if (i % blk_size == 0)
                blockCount++;
            block[blockCount] += input[i];
        }

        return block;
    }
}
