public class Map {

    private Area[] map;

    public Map() {
        map = new Area[402];
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
        map[4].addNext(map[339]);
        map[4].addNext(map[35]);
        map[5].addNext(map[371]);
        map[6].addNext(map[333]);
        map[6].addNext(map[88]);
        map[7].addNext(map[232]);
        map[7].addNext(map[78]);
        map[151].addNext(map[351]);
        map[151].addNext(map[29]);
        map[202].addNext(map[151]);
        map[202].addNext(map[69]);
        map[202].addNext(map[276]);
        map[401].addNext(map[1]);
    }

    public Area getAreaLocation(int id) {
        map[id].showText();
        return map[id];
    }
}
