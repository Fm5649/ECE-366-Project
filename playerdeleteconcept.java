//In player dao

private static final String DELETE_BY_ID = "DELETE player_id a, player_name b, password c, " FROM player WHERE player_id=?";

public Player deleteById(long id) {
        Player user = new Player();
        System.out.println(DELETE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setPlayerId(rs.getLong("a"));
                user.setPlayerName(rs.getString("b"));
                user.setPassword(rs.getString("c"));
                user.setTotalGames(rs.getInt("total_games"));
                user.setTotalWins(rs.getInt("total_wins"));
                user.setTotalLosses(rs.getInt("total_losses"));
                user.setPlayerElo(rs.getInt("player_elo"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }



//In controllers

@GetMapping("/deletePlayerById/{id}")
    public Player deletePlayerById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);

            player = playerDAO.deleteById(id);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return player;
    }
