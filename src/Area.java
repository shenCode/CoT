import java.util.ArrayList;

public class Area {

    private int number;
    private String areaText;
    private ArrayList<Area> nextArea = new ArrayList<Area>();
    private Enemy enemy;
    private ArrayList<String> prompts = new ArrayList<String>();

    public Area(int num) {
        number = num;
        initText();
    }

    public void initText() {

        switch (number) {
        case 0:
            areaText = Text.BACKGROUND_1 + Text.BACKGROUND_2 + Text.BACKGROUND_3
                + Text.BACKGROUND_4 + Text.BACKGROUND_5 + Text.BACKGROUND_6
                + Text.BACKGROUND_7 + Text.BACKGROUND_8;
        case 1:
            areaText = Text.STORY1;
            prompts.add(Text.STORY1_1);
            prompts.add(Text.STORY1_2);
            prompts.add(Text.STORY1_3);
        case 2:
            areaText = Text.STORY2;
            prompts.add(Text.STORY2_1);
            prompts.add(Text.STORY2_2);
        default:
            break;
        }
    }

    public int getNumber() {
        return number;
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
}
