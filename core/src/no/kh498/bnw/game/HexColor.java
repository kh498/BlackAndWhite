package no.kh498.bnw.game;

import com.badlogic.gdx.graphics.Color;

import java.util.HashMap;

/**
 * @author karl henrik
 */
@SuppressWarnings("GwtInconsistentSerializableClass")
public enum HexColor {
    WHITE(0.8f),
    GRAY(0.4f),
    BLACK(0.25f);

    private final Color shade;
    private final HashMap<Float, Color> ColorCache = new HashMap<>();

    HexColor(final float shade) {
        this(shade, shade, shade);
    }

    HexColor(final float r, final float g, final float b) {
        this.shade = new Color(r, g, b, 1f);
    }

    /**
     * Get a shade of a certain color, the method is lazy so if a percent is called once the shade is cached
     *
     * @param percent
     *     The percent of light to getData (num 0-1)
     *
     * @return A shade of a color
     */
    public Color shade(final float percent) {
        if (!this.ColorCache.containsKey(percent)) {
            final Color c = new Color(this.shade.r * percent, this.shade.g * percent, this.shade.b * percent, 1f);
            this.ColorCache.put(percent, c);
            return c;
        }
        else {
            return this.ColorCache.get(percent);
        }
    }
}