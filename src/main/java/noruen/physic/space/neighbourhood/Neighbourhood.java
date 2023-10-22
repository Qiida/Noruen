package noruen.physic.space.neighbourhood;

import noruen.physic.space.cell.Coordinates;

public class Neighbourhood {
    static public Coordinates[] getVonNeumann(Coordinates coordinates) {
        Coordinates[] neighbouringCoordinates = new Coordinates[6];
        neighbouringCoordinates[0] = coordinates.goAbove();
        neighbouringCoordinates[1] = coordinates.goUnder();
        neighbouringCoordinates[2] = coordinates.goUp();
        neighbouringCoordinates[3] = coordinates.goRight();
        neighbouringCoordinates[4] = coordinates.goDown();
        neighbouringCoordinates[5] = coordinates.goLeft();
        return neighbouringCoordinates;
    }

    static public Coordinates[] getMoore(Coordinates coordinates) {
        Coordinates[] neighbouringCoordinates = new Coordinates[26];
        neighbouringCoordinates[0] = coordinates.goAbove();
        neighbouringCoordinates[1] = neighbouringCoordinates[0].goUp();
        neighbouringCoordinates[2] = neighbouringCoordinates[1].goRight();
        neighbouringCoordinates[3] = neighbouringCoordinates[2].goDown();
        neighbouringCoordinates[4] = neighbouringCoordinates[3].goDown();
        neighbouringCoordinates[5] = neighbouringCoordinates[4].goLeft();
        neighbouringCoordinates[6] = neighbouringCoordinates[5].goLeft();
        neighbouringCoordinates[7] = neighbouringCoordinates[6].goUp();
        neighbouringCoordinates[8] = neighbouringCoordinates[7].goUp();

        neighbouringCoordinates[9] = coordinates.goUp();
        neighbouringCoordinates[10] = neighbouringCoordinates[9].goRight();
        neighbouringCoordinates[11] = neighbouringCoordinates[10].goDown();
        neighbouringCoordinates[12] = neighbouringCoordinates[11].goDown();
        neighbouringCoordinates[13] = neighbouringCoordinates[12].goLeft();
        neighbouringCoordinates[14] = neighbouringCoordinates[13].goLeft();
        neighbouringCoordinates[15] = neighbouringCoordinates[14].goUp();
        neighbouringCoordinates[16] = neighbouringCoordinates[15].goUp();

        neighbouringCoordinates[17] = coordinates.goUnder();
        neighbouringCoordinates[18] = neighbouringCoordinates[17].goUp();
        neighbouringCoordinates[19] = neighbouringCoordinates[18].goRight();
        neighbouringCoordinates[20] = neighbouringCoordinates[19].goDown();
        neighbouringCoordinates[21] = neighbouringCoordinates[20].goDown();
        neighbouringCoordinates[22] = neighbouringCoordinates[21].goLeft();
        neighbouringCoordinates[23] = neighbouringCoordinates[22].goLeft();
        neighbouringCoordinates[24] = neighbouringCoordinates[23].goUp();
        neighbouringCoordinates[25] = neighbouringCoordinates[24].goUp();

        return neighbouringCoordinates;
    }
}