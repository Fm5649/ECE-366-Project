package com.teamchop.chopsticks.message;

import static java.lang.Long.parseLong;

public class JoinMessage {
    private long gameId;
    private long userId;
    private String idToken;

    public long getGameId() {
        return gameId;
    }

    public long getUserId(){
        return userId;
    }

    public String getIdToken() {return idToken;}
}
