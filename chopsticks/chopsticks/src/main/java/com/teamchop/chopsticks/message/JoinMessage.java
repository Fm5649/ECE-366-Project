package com.teamchop.chopsticks.message;

import static java.lang.Long.parseLong;

public class JoinMessage {
    private long gameId;
    private long userId;

    public long getGameId() {
        return gameId;
    }

    public long getUserId(){
        return userId;
    }
}
