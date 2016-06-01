package models;

public class Coordonnees {
	private int x;
	private int y;
	
	public Coordonnees(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
        public String toString(){
            return "["+this.getX()+", "+this.getY()+"]";
        }
        @Override
        public boolean equals(Object obj){
            if(obj!=null){
                if(obj instanceof Coordonnees){
                    return this.equals((Coordonnees)obj);
                }
            }
            return false;
        }
        public boolean equals(Coordonnees autreCoord){
            return this.x==autreCoord.x && this.y==autreCoord.y;
        }
	
}
