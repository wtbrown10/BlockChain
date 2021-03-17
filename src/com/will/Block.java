package com.will;

import java.util.Arrays;
import java.util.Date;


public class Block {

    public String hash;
    public String previousHash;
    private String data; //data will be a simple message.
    private long timeStamp; //as number of milliseconds since 1/1/1970

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after we set the values.
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data);
        return calculatedHash;
    }



  /*  private String[] transactions;
    private int blockHash;
    private int previousBlockHash;

    @Override
    public String toString() {
        return "Block{" +
                "transactions=" + Arrays.toString(transactions) +
                ", blockHash=" + blockHash +
                ", previousBlockHash=" + previousBlockHash +
                '}';
    }

    public Block(String[] transactions, int previousBlockHash) {
        this.transactions = transactions;
        this.previousBlockHash = previousBlockHash;
        this.blockHash = Arrays.hashCode( new int[] { Arrays.hashCode(transactions), this.previousBlockHash});
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public int getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(int blockHash) {
        this.blockHash = blockHash;
    }

    public int getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(int previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }*/
}
