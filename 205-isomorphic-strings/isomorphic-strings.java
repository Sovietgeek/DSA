class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char se = s.charAt(i);
            char tu = t.charAt(i);
            if (mp.containsKey(se)) {
                if (mp.get(se) != tu) {
                    return false;
                }
            } else {
                if (set.contains(tu))
                    return false;
                mp.put(se, tu);
                set.add(tu);
            }

            
        }
        return true;

    }
}