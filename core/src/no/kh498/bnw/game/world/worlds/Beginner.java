package no.kh498.bnw.game.world.worlds;

import no.kh498.bnw.game.HexColor;
import no.kh498.bnw.game.world.World;
import no.kh498.bnw.hexagon.HexagonData;
import no.kh498.bnw.util.HexUtil;
import org.codetome.hexameter.core.api.CubeCoordinate;
import org.codetome.hexameter.core.api.Hexagon;

/**
 * @author karl henrik
 */
public class Beginner extends World {

    @Override
    protected void finalizeWorld() {
        for (final Hexagon<HexagonData> hexagon : HexUtil.getHexagons(grid)) {
            final HexagonData data = HexUtil.getData(hexagon);
            final CubeCoordinate coord = hexagon.getCubeCoordinate();
            final int x = coord.getGridX();
            final int z = coord.getGridZ();
            if (x == 0 && z == 2 || x == 1 && z == 2 || x == 2 && z == 1) {
                data.color = HexColor.WHITE;
            }
            else if (x == 1 && z == 0) {
                data.color = HexColor.BLACK;
            }
            hexagon.setSatelliteData(data);
        }
    }

    @Override
    protected int getGridRadius() {
        return 3;
    }
}
