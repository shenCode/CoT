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
        map[8].addNext(map[334]);
        map[9].addNext(map[401]);
        map[10].addNext(map[212]);
        map[10].addNext(map[130]);
        map[11].addNext(map[358]);
        map[54].addNext(map[74]);
        map[74].addNext(map[95]);
        map[74].addNext(map[116]);
        map[74].addNext(map[17]);
        map[94].addNext(map[234]);
        map[95].addNext(map[224]);
        map[95].addNext(map[300]);
        map[96].addNext(map[257]);
        map[96].addNext(map[319]);
        map[96].addNext(map[197]);
        map[151].addNext(map[351]);
        map[151].addNext(map[29]);
        map[202].addNext(map[151]);
        map[202].addNext(map[69]);
        map[202].addNext(map[276]);
        map[224].addNext(map[66]);
        map[224].addNext(map[236]);
        map[351].addNext(map[54]);
        map[401].addNext(map[1]);
    }

    public Area getAreaLocation(int id) {
        map[id].showText();
        return map[id];
    }
}
