import java.util.ArrayList;

public class Area {

    private int id;
    private String areaText;
    private ArrayList<Area> nextArea = new ArrayList<Area>();
    private Enemy enemy;
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
}
