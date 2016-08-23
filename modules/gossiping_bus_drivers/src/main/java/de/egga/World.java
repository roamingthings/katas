package de.egga;

class World {

    private Integer gossipCount;

    World() {

    }

    String simulate(Bus... busses) {
        gossipCount = busses.length;

        exchangeGossips(busses);


        Integer i = 0;
        while (!checkAllGossipsExchanged(busses)) {
            if (++i >= 480) {
                return "never";
            }
        }
        return i.toString();
    }

    private boolean checkAllGossipsExchanged(Bus... busses) {
        for (Bus bus : busses) {
            if (bus.knownGossips().size() < gossipCount) {
                return false;
            }
        }

        return true;
    }

    private void exchangeGossips(Bus[] busses) {

        for (Bus bus : busses) {
            for (Bus other : busses) {
                bus.knownGossips().addAll(other.knownGossips());
            }
        }
    }
}
