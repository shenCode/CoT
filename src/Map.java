public class Map {

    private Area[] map;
    public Map() {
        map = new Area[401];
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < map.length; i++) {
            map[i] = new Area(i);
        }
        map[0].addNext(map[1]);
        map[1].addNext(map[202]);
        map[1].addNext(map[33]);
        map[1].addNext(map[49]);
        map[2].addNext(map[377]);
        map[2].addNext(map[174]);
        map[3].addNext(map[37]);
        map[3].addNext(map[398]);
    }

    public Area getAreaLocation(int id) {
        System.out.println(map[id].getText());
        return map[id];
    }
}
