import java.util.ArrayList;

public class Area {

    private int id;
    private String areaText;
    private ArrayList<Area> nextArea = new ArrayList<Area>();
    private Enemy enemy = new Enemy("", 0, 0);
    private ArrayList<String> prompts = new ArrayList<String>();

    public Area(int num) {
        id = num;
        initText();
    }

    public void initText() {

        switch (id) {
        case 0:
            areaText = Text.BACKGROUND_1 + Text.BACKGROUND_2 + Text.BACKGROUND_3
                + Text.BACKGROUND_4 + Text.BACKGROUND_5 + Text.BACKGROUND_6
                + Text.BACKGROUND_7 + Text.BACKGROUND_8;
            prompts.add(Text.BACKGROUND_9);
            break;
        case 1:
            areaText = Text.STORY1;
            prompts.add(Text.STORY1_1);
            prompts.add(Text.STORY1_2);
            prompts.add(Text.STORY1_3);
            break;
        case 2:
            areaText = Text.STORY2;
            prompts.add(Text.STORY2_1);
            prompts.add(Text.STORY2_2);
            break;
        case 3:
            areaText = Text.STORY3;
            prompts.add(Text.STORY3_1);
            prompts.add(Text.STORY3_2);
            break;
        case 4:
            areaText = Text.STORY4;
            prompts.add(Text.STORY4_1);
            prompts.add(Text.STORY4_2);
            break;
        case 5:
            areaText = Text.STORY5;
            prompts.add(Text.BATTLE);
            enemy = new Enemy("MAN-ORC", 8, 5);
        case 6:
            areaText = Text.STORY6;
            prompts.add(Text.STORY6_1);
            prompts.add(Text.STORY6_2);
        case 7:
            
            
            
        case 401:
            areaText = "You died.";
            prompts.add("Enter 1 to restart the game."); 
        default:
            break;
        }
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return areaText;
    }

    public void addNext(Area area) {
        nextArea.add(area);
    }

    public ArrayList<Area> getNext() {
        return nextArea;
    }

    public Area getNextById(int id) {
        return nextArea.get(id - 1);
    }

    public void showText() {
        System.out.println(areaText);
        for (int i = 0; i < prompts.size(); i++) {
            System.out.println(prompts.get(i));
        }
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
