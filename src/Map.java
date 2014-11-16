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
        map[12].addNext(map[176]);
        map[12].addNext(map[383]);
        map[13].addNext(map[273]);
        map[13].addNext(map[80]);
        map[13].addNext(map[334]);
        map[14].addNext(map[237]);
        map[14].addNext(map[191]);
        map[15].addNext(map[75]);
        map[15].addNext(map[298]);
        map[16].addNext(map[333]);
        map[17].addNext(map[331]);
        map[17].addNext(map[161]);
        map[18].addNext(map[102]);
        map[18].addNext(map[225]);
        map[19].addNext(map[340]);
        map[19].addNext(map[60]);
        map[20].addNext(map[84]);
        map[21].addNext(map[288]);
        map[21].addNext(map[77]);
        map[22].addNext(map[198]);
        map[23].addNext(map[146]);
        map[24].addNext(map[336]);
        map[24].addNext(map[196]);
        map[25].addNext(map[169]);
        map[25].addNext(map[323]);
        map[25].addNext(map[115]);
        map[26].addNext(map[296]);
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
