package com.will;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String statement1 = "My world is perfect";
        int hashvalue = statement1.hashCode();

        System.out.println("Statement = " + statement1 + " whose's hash value = " + hashvalue);

        // lets hash an array
        String [] list1 = {"Alex", "becky", "cyril"};
        String [] list2 = {"Alex", "becky", "cyril"};

        int hash1 = Arrays.hashCode(list1);
        int hash2 = Arrays.hashCode(list2);

        System.out.println("hash1 = " + hash1 + " hash2 = " + hash2);

        // demonstrate series of block in the chain
        ArrayList<Block> blockChain = new ArrayList<Block>();
        String[] initialValues = {"Shad has $700" , "Miguel has $550"};
        Block firstBlock = new Block(initialValues, 0);
        blockChain.add(firstBlock);
        System.out.println("first block is " + firstBlock.toString());
        System.out.println("The blockchain is " + blockChain.toString());


        // second block
        String[] shadGivesItAway = {"Shad gives Tim $40" , "Shad gives Miguel $60", "Shad gives Terry $100"};
        Block secondBlock = new Block(shadGivesItAway, firstBlock.getBlockHash());
        blockChain.add(secondBlock);
        System.out.println("Second block is " + secondBlock.toString());
        System.out.println("The blockchain is " + blockChain.toString());

        // third block
        String[] shadGetsSomeBack = {"Tim gives Shad $10 " , "Terry gives $50 to shad"};
        Block thirdBlock = new Block(shadGetsSomeBack, secondBlock.getBlockHash());
        blockChain.add(thirdBlock);
        System.out.println("Third block is " + thirdBlock.toString());
        System.out.println("The blockchain is " + blockChain.toString());
    }
}
