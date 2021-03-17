package com.will;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();



    public static void main(String[] args) {
	// write your code here



        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

/*      First crack at creating a blockchain
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
        System.out.println("The blockchain is " + blockChain.toString());*/
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
