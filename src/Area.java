import java.util.ArrayList;

public class Area {

    private int id, count = 1;
    private String areaText;
    private ArrayList<Area> nextArea = new ArrayList<Area>();
    private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    private ArrayList<Prompt> prompts = new ArrayList<Prompt>();

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
            prompts.add(new Prompt(0, Text.BACKGROUND_9));
            break;
        case 1:
            areaText = Text.STORY1;
            addPrompt(1, Text.STORY1_1);
            addPrompt(1, Text.STORY1_2);
            addPrompt(1, Text.STORY1_3);
            break;
        case 2:
            areaText = Text.STORY2;
            addPrompt(2, Text.STORY2_1);
            addPrompt(2, Text.STORY2_1);
            break;
        case 3:
            areaText = Text.STORY3;
            addPrompt(3, Text.STORY3_1);
            addPrompt(3, Text.STORY3_1);
            break;
        case 4:
            areaText = Text.STORY4;
            addPrompt(4, Text.STORY4_1);
            addPrompt(4, Text.STORY4_1);
            break;
        case 5:
            areaText = Text.STORY5;
            addPrompt(999, Text.BATTLE);
            enemy.add(new Enemy("MAN-ORC", 8, 5));
            break;
        case 6:
            areaText = Text.STORY6;
            addPrompt(6, Text.STORY6_1);
            addPrompt(6, Text.STORY6_2);
            break;
        case 7:
            areaText = Text.STORY7;
            addPrompt(7, Text.STORY7_1);
            addPrompt(7, Text.STORY7_2);
            break;
        case 8:
            areaText = Text.STORY8;
            addPrompt(8, Text.STORY8_1);
            break;
        case 9:
            areaText = Text.STORY9;
            addPrompt(9, "You have died.");
            break;
        case 10:
            areaText = Text.STORY10;
            addPrompt(999, Text.BATTLE);
            enemy.add(new Enemy("CITY GUARD", 8, 7));
            break;
        case 11:
            areaText = Text.STORY11;
            addPrompt(11, Text.STORY11);
            break;
        case 12:
            areaText = Text.STORY12;
            addPrompt(12, Text.STORY12_1);
            addPrompt(12, Text.STORY12_2);
            break;
        case 13:
            areaText = Text.STORY13;
            addPrompt(13, Text.STORY13_1);
            addPrompt(13, Text.STORY13_2);
            addPrompt(13, Text.STORY13_3);
            break;
        case 14:
            areaText = Text.STORY14;
            addPrompt(14, Text.STORY14_1);
            addPrompt(14, Text.STORY14_2);
            break;
        case 15:
            areaText = Text.STORY15;
            addPrompt(15, Text.STORY15_1);
            addPrompt(15, Text.STORY15_2);
            break;
        case 16:
            areaText = Text.STORY16;
            addPrompt(16, Text.STORY16_1);
            break;
        case 17:
            areaText = Text.STORY17;
            addPrompt(17, Text.STORY17_1);
            addPrompt(17, Text.STORY17_2);
            break;
        case 18:
            areaText = Text.STORY18;
            addPrompt(18, Text.STORY18_1);
            addPrompt(18, Text.STORY18_2);
            break;
        case 19:
            areaText = Text.STORY19;
            addPrompt(19, Text.STORY19_1);
            addPrompt(19, Text.STORY19_2);
            break;
        case 20:
            areaText = Text.STORY20;
            addPrompt(20, Text.STORY20_1);
            break;
        case 21:
            areaText = Text.STORY21;
            addPrompt(21, Text.STORY21_1);
            addPrompt(21, Text.STORY21_2);
            break;
        case 22:
            areaText = Text.STORY22;
            addPrompt(999, Text.BATTLE);
            enemy.add(new Enemy("First GOBLIN", 4, 5));
            enemy.add(new Enemy("Second GOBLIN", 5, 5));
            break;
        case 23:
            areaText = Text.STORY23;
            addPrompt(999, Text.BATTLE);
            enemy.add(new Enemy("SILVERSMITH", 4, 8));
            break;
        case 24:
            areaText = Text.STORY24;
            addPrompt(24, Text.STORY24_1);
            addPrompt(24, Text.STORY24_2);
            break;
        case 25:
            areaText = Text.STORY25;
            addPrompt(25, Text.STORY25_1);
            addPrompt(25, Text.STORY25_2);
            addPrompt(25, Text.STORY25_3);
            break;
        case 26:
            areaText = Text.STORY26;
            addPrompt(26, Text.STORY26_1);
            break;
        default:
            initText2(id);
        }
    }

    public void initText2(int id) {
        switch(id) {
        case 54:
            areaText = Text.STORY54;
            addPrompt(54, "Enter 1 to continue.");
            break;
        case 74:
            areaText = Text.STORY74;
            addPrompt(74, Text.STORY74_1);
            addPrompt(74, Text.STORY74_2);
            addPrompt(74, Text.STORY74_3);
            break;
        case 94:
            areaText = Text.STORY94;
            addPrompt(94, "Enter 1 to continue.");
            break;
        case 95:
            areaText = Text.STORY95;
            addPrompt(95, Text.STORY95_1);
            addPrompt(95, Text.STORY95_2);
            break;
        case 96:
            areaText = Text.STORY96;
            addPrompt(96, Text.STORY96_1);
            addPrompt(96, Text.STORY96_2);
            addPrompt(96, Text.STORY96_3);
            break;
        case 151:
            areaText = Text.STORY151;
            addPrompt(151, Text.STORY151_1);
            addPrompt(151, Text.STORY151_2);
            break;
        case 202:
            areaText = Text.STORY202;
            addPrompt(202, Text.STORY202_1);
            addPrompt(202, Text.STORY202_2);
            addPrompt(202, Text.STORY202_3);
            break;
        case 224:
            areaText = Text.STORY224;
            addPrompt(224, Text.STORY224_1);
            addPrompt(224, Text.STORY224_2);
            break;
        case 351:
            areaText = Text.STORY351;
            enemy.add(new Enemy("First CITY GUARD", 6, 6));
            enemy.add(new Enemy("Second CITY GUARD", 7, 5));
            break;
        default:
            break;
        }
    }

    public void addPrompt(int id, String text) {
        prompts.add(new Prompt(id, text + " Enter " + count + "."));
        count++;
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
        prompts.remove(findPrompt(area.getId()));
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
