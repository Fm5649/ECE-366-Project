package com.teamchop.chopsticks;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GameLogic {
    public static List<List<Integer>> validMoves(GameRound g) {
        List<List<Integer>> moves = new ArrayList<>();
        int round = g.getRoundNumber();
        int h1, h2, o1, o2;
        int player;
        if (round % 2 == 0) {
            h1 = g.getP1Hand1();
            h2 = g.getP1Hand2();
            o1 = g.getP2Hand1();
            o2 = g.getP2Hand2();
            player=1;
        } else {
            h1 = g.getP2Hand1();
            h2 = g.getP2Hand2();
            o1 = g.getP1Hand1();
            o2 = g.getP1Hand2();
            player=2;
        }
        if (h1 < 5 && h2 < 5 && h1 >= 0 && h2 >= 0) {
            int s = h1+h2;
            for(int j=0;j<=s;j++){
                List<Integer> item = new ArrayList<Integer>();
                item.add(j);
                item.add(s-j);
                item.add(o1);
                item.add(o2);
                moves.add(item);
            }
        }
        if (h1 != 0) {
            if(o1 != 0) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(h1);
                item.add(h2);
                item.add((h1+o1)%5);
                item.add(o2);
                moves.add(item);
            }
            if(o2 != 0) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(h1);
                item.add(h2);
                item.add(o1);
                item.add((h1+o2)%5);
                moves.add(item);
            }
        }
        if (h2 != 0) {
            if(o1 != 0) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(h1);
                item.add(h2);
                item.add((h2+o1)%5);
                item.add(o2);
                moves.add(item);
            }
            if(o2 != 0) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(h1);
                item.add(h2);
                item.add(o1);
                item.add((h2+o2)%5);
                moves.add(item);
            }
        }
        return moves;
    }
    public static boolean isValidMove(GameRound g) {
        if (g.getP1Hand1() >= 5 || g.getP1Hand1() < 0) return false;
        if (g.getP1Hand2() >= 5 || g.getP1Hand2() < 0) return false;
        if (g.getP2Hand2() >= 5 || g.getP2Hand2() < 0) return false;
        if (g.getP2Hand1() >= 5 || g.getP2Hand1() < 0) return false;
        return true;
    }
    public static int  winner(GameRound g) {
        int a=0;
        if (g.getP2Hand1()==0 && g.getP2Hand2()==0) {
            a=1;
        } else if (g.getP1Hand1()==0 && g.getP1Hand2()==0) {
            a = 2;
        }
        return a;
    }

    public static long[] getElo(long winnerElo, long loserElo) {
        double E_w = 1/(1+Math.pow(10,(loserElo-winnerElo)/400));
        double E_l = 1/(1+Math.pow(10,(winnerElo-loserElo)/400));
        long R_w = (long)(winnerElo + 32*(1.0-E_w));
        long R_l = (long)(loserElo + 32*(0.0-E_l));
        long[] ans = new long[2];
        ans[0] = R_w;
        ans[1] = R_l;
        System.out.println(winnerElo);
        System.out.println(loserElo);
        System.out.println(R_w);
        System.out.println(R_l);
        System.out.println(E_w);
        System.out.println(E_l);
        return ans;
    }
}
