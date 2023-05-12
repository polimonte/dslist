package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class BelongingPK implements Serializable {

    private static final long serialVersionUID = -8562206293270536197L;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK(){
    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingPK)) return false;

        BelongingPK that = (BelongingPK) o;

        if (!getGame().equals(that.getGame())) return false;
        return getGameList().equals(that.getGameList());
    }

    @Override
    public int hashCode() {
        int result = getGame().hashCode();
        result = 31 * result + getGameList().hashCode();
        return result;
    }
}
