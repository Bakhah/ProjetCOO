package models;

public class Coordonnees
{

    private final int x;
    private final int y;

    public Coordonnees(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return "[" + this.getX() + ", " + this.getY() + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (obj instanceof Coordonnees)
            {
                return this.equals((Coordonnees) obj);
            }
        }
        return false;
    }

    public boolean equals(Coordonnees autreCoord)
    {
        return this.x == autreCoord.x && this.y == autreCoord.y;
    }

    public boolean estCoteACote(Coordonnees autreCoord)
    {
        if (this.y == autreCoord.getY())
        {
            return this.x == autreCoord.getX() + 1 || this.x == autreCoord.getX() - 1;
        } else
        {
            if (this.x == autreCoord.getX())
            {
                return this.y == autreCoord.getY() + 1 || this.y == autreCoord.getY() - 1;
            }
        }
        return false;
    }

}
