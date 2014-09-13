import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        default:
//            Collections.sort(nextArea, new AreaIdComparator());
        }
    }

//    private class AreaIdComparator implements Comparator<Area> {
//
//        public int compare(Area a1, Area a2) {
//            if (a1.getId() < a2.getId()) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//    }

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
        showText();
        return nextArea.get(id - 1);
    }

    public void showText() {
        System.out.println(areaText);
        for (int i = 0; i < prompts.size(); i++) {
            System.out.println(prompts.get(i));
        }
    }
}
