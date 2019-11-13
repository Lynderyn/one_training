package com.acme.acmetrade.domain;

public class TradersRankByTrades implements Comparable<TradersRankByTrades>{

    private String name;
    private int numberOfTrades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(int numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    @Override
    public int compareTo(TradersRankByTrades tradersRankByTrades) {
        return (this.getNumberOfTrades() < tradersRankByTrades.getNumberOfTrades() ? -1 :
                (this.getNumberOfTrades() == tradersRankByTrades.getNumberOfTrades() ? 0 : 1));
    }
}
