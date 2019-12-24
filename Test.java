import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName:Test
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/12/1 9:26
 * @Author:DangWei
 */

class Card{
    private int rank;
    private String suit;
    public Card(String suit,int rank){
        this.suit=suit;
        this.rank=rank;
    }
    @Override
    public String toString(){
        return String.format("[%s %d]",suit,rank);
    }
}
class Cards{
    String[] s={"♠","♥","♣","♦"};
    public List<Card> buyCard(){
        List<Card> res=new ArrayList<>();
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                Card c=new Card(s[i],j);
                res.add(c);
            }
        }
        return res;
    }

    private void swap(List<Card> card,int i,int j){
        Card tmp=card.get(i);
        card.set(i,card.get(j));
        card.set(j,tmp);
    }
    public void shuffle(List<Card> card){
        Random random=new Random(20191224);
        for(int i=card.size()-1;i>0;i--){
           int j=random.nextInt(i);
            swap(card,i,j);
        }
    }

    public void playCards(List<Card> card){
        List<List<Card>> res=new ArrayList<>(3);
        for(int i=0;i<3;i++){
            res.add(new ArrayList<Card>());
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                Card c=card.remove(card.size()-1);
                res.get(j).add(c);
            }
        }
        for(int i=0;i<3;i++){
            System.out.println(res.get(i));
        }
        System.out.println(card.size());
    }
}
public class Test {
    public static void main(String[] args) {
        Cards card=new Cards();
        List<Card> c=card.buyCard();
        System.out.println("刚买回来的牌：");
        System.out.println(c);
        System.out.println("洗完之后的牌：");
        card.shuffle(c);
        System.out.println(c);
        System.out.println("游戏开始：");
        card.playCards(c);
    }
}
