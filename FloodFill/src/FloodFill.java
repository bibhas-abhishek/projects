/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 11 Feb 2018
 * https://leetcode.com/problems/flood-fill/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/FloodFill/
 **/

public class FloodFill {

    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        floodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void floodFill(int[][] image, int r, int c, int oColor, int nColor) {
        if (r < 0 || r > image.length || c < 0 || c >= image[0].length)
            return;
        if (image[r][c] == oColor) {
            image[r][c] = nColor;
            floodFill(image, r - 1, c, oColor, nColor);
            floodFill(image, r, c - 1, oColor, nColor);
            floodFill(image, r + 1, c, oColor, nColor);
            floodFill(image, r, c + 1, oColor, nColor);
        }
    }

}
