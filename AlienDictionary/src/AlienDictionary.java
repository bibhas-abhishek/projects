public class AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                // current word index > next word length; return false
                if (j >= words[i + 1].length()) {
                    return false;
                }

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (map[words[i].charAt(j) - 'a'] > map[words[i + 1].charAt(j) - 'a']) {
                        return false;
                    }
                    else
                        break;
                }
            }
        }
        return true;
    }
}
