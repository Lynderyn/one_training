package com.acme.acmetrade.domain;

public class TradersRankByVolume implements Comparable<TradersRankByVolume>{
    private String name;
    private long volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(TradersRankByVolume tradersRankByVolume) {
        return (this.getVolume() < tradersRankByVolume.getVolume() ? -1 :
                (this.getVolume() == tradersRankByVolume.getVolume() ? 0 : 1));
    }
}
