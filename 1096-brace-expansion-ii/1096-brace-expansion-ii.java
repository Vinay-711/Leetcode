import java.util.*;

public class Solution {
    private int index = 0;
    private String expression;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;
        
        Set<String> resultSet = parseExpression();
        return new ArrayList<>(resultSet);
    }
    private Set<String> parseExpression() {
        Set<String> result = new TreeSet<>();
        
        result.addAll(parseTerm());
        
        while (index < expression.length() && expression.charAt(index) == ',') {
            index++; // consume ','
            result.addAll(parseTerm());
        }
        
        return result;
    }

    private Set<String> parseTerm() {

        Set<String> result = new TreeSet<>();
        result.add("");
        while (index < expression.length() && (Character.isLetter(expression.charAt(index)) || expression.charAt(index) == '{')) {
            Set<String> factor = parseFactor();
            result = product(result, factor);
        }

        return result;
    }
    private Set<String> parseFactor() {
        Set<String> result = new TreeSet<>();
        char c = expression.charAt(index);

        if (c == '{') {
            index++; // consume '{'
            result = parseExpression();
            index++; // consume '}'
        } else if (Character.isLetter(c)) {
            StringBuilder sb = new StringBuilder();
            while (index < expression.length() && Character.isLetter(expression.charAt(index))) {
                sb.append(expression.charAt(index));
                index++;
            }
            result.add(sb.toString());
        }

        return result;
    }
    private Set<String> product(Set<String> set1, Set<String> set2) {
        Set<String> result = new TreeSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
}
