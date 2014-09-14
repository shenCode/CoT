import java.util.ArrayList;

public class Area {

    private int id;
    private String areaText;
    private ArrayList<Area> nextArea = new ArrayList<Area>();
    private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    private ArrayList<Prompt> prompts = new ArrayList<Prompt>();

    public Area(int num) {
        id = 5;
        initText();
    }

    public void initText() {

        switch (id) {
        case 0:
            areaText = Text.BACKGROUND_1 + Text.BACKGROUND_2 + Text.BACKGROUND_3
                + Text.BACKGROUND_4 + Text.BACKGROUND_5 + Text.BACKGROUND_6
                + Text.BACKGROUND_7 + Text.BACKGROUND_8;
            prompts.add(new Prompt(0, Text.BACKGROUND_9));
            break;
        case 1:
            areaText = Text.STORY1;
            prompts.add(new Prompt(1, Text.STORY1_1 + " Enter 1."));
            prompts.add(new Prompt(1, Text.STORY1_2 + " Enter 2."));
            prompts.add(new Prompt(1, Text.STORY1_3 + " Enter 3."));
            break;
        case 2:
            areaText = Text.STORY2;
            prompts.add(new Prompt(2, Text.STORY2_1 + " Enter 1."));
            prompts.add(new Prompt(2, Text.STORY2_2 + " Enter 2."));
            break;
        case 3:
            areaText = Text.STORY3;
            prompts.add(new Prompt(3, Text.STORY3_1 + " Enter 1."));
            prompts.add(new Prompt(3, Text.STORY3_2 + " Enter 2."));
            break;
        case 4:
            areaText = Text.STORY4;
            prompts.add(new Prompt(4, Text.STORY4_1 + " Enter 1."));
            prompts.add(new Prompt(4, Text.STORY4_2 + " Enter 2."));
            break;
        case 5:
            areaText = Text.STORY5;
            prompts.add(new Prompt(999, Text.BATTLE));
            enemy.add(new Enemy("MAN-ORC", 8, 5));
            break;
        case 6:
            areaText = Text.STORY6;
            prompts.add(new Prompt(6, Text.STORY6_1 + " Enter 1."));
            prompts.add(new Prompt(6, Text.STORY6_2 + " Enter 2."));
            break;
        case 7:
            areaText = Text.STORY7;
            prompts.add(new Prompt(7, Text.STORY7_1 + " Enter 1."));
            prompts.add(new Prompt(7, Text.STORY7_2 + " Enter 2."));
            break;
        case 151:
            areaText = Text.STORY151;
            prompts.add(new Prompt(151, Text.STORY151_1 + "Enter 1."));
            prompts.add(new Prompt(151, Text.STORY151_2 + "Enter 2."));
        case 202:
            areaText = Text.STORY202;
            prompts.add(new Prompt(202, Text.STORY202_1 + " Enter 1."));
            prompts.add(new Prompt(202, Text.STORY202_2 + " Enter 2."));
            prompts.add(new Prompt(202, Text.STORY202_3 + " Enter 3."));
            break;
        case 351:
            areaText = Text.STORY351;
            enemy.add(new Enemy("First CITY GUARD", 6, 6));
            enemy.add(new Enemy("Second CITY GUARD", 7, 5));
        case 401:
            areaText = "You died.";
            prompts.add(new Prompt(401, "Enter 1 to restart the game."));
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

    public void removeNext(Area area) {
        nextArea.remove(area);
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
            System.out.println(prompts.get(i).getText());
        }
    }

    public void removeNext(int id) {
        nextArea.remove(findArea(id));
        prompts.remove(findPrompt(id));
    }

    public Prompt findPrompt(int id) {
        for (int i = 0; i < prompts.size(); i++) {
            if (id == prompts.get(i).getId()) {
                return prompts.get(i);
            }
        }
        return null;
    }

    public Area findArea(int id) {
        for (int i = 0; i < nextArea.size(); i++) {
            if (id == nextArea.get(i).getId()) {
                return nextArea.get(i);
            }
        }
        return null;
    }

    public ArrayList<Enemy> getEnemy() {
        return enemy;
    }
}
