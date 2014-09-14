public class Enemy {

    private String name;
    private int skill;
    private int stamina;
    private boolean alive;

    public Enemy(String n, int sk, int st) {
        name = n;
        skill = sk;
        stamina = st;
        alive = true;
    }
    
    public void setDead(){
    	alive = false;
    	stamina = 0;
    }
    
    public void setStamina(int change){
    	stamina += change;
    }
    
    
    
}
