import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Recognizer {
    Map<Character, Map<Character, Integer>> lookup_table = Map.of(
            'T', Map.of(
                    'a', 1,
                    'b', 1,
                    'c', 1,
                    'd', 1,
                    '$', -1),
            'S', Map.of(
                    'a', 4,
                    'b', 3,
                    'c', 2,
                    'd', 4,
                    '$', -1),
            'X', Map.of(
                    'a', 5,
                    'b', -1,
                    'c', -1,
                    'd', 6,
                    '$', 6),
            'Y', Map.of(
                    'a', 7,
                    'b', -1,
                    'c', -1,
                    'd', 8,
                    '$', 8));
    Map<Integer, String> production_list = Map.of(
            1, "S$",
            2, "cS",
            3, "bX",
            4, "Xd",
            5, "aY",
            6, "",
            7, "a",
            8, "");

    Set<Character> terminals = Set.of('a', 'b', 'c', 'd', '$');
    Set<Character> not_terminals = Set.of('T', 'S', 'X', 'Y');

    int nextState(String symbolsLane) {
        int answer = 1;
        StringBuilder production_sequence = new StringBuilder();
        Character[] characters = new Character[symbolsLane.length()];
        for (int i = 0; i < symbolsLane.length(); i++) {
            characters[i] = symbolsLane.charAt(i);
        }
        Stack<Character> stack = new Stack<>();
        stack.push('T');
//        for (Character current_in_text : characters) {
//            if (!terminals.contains(current_in_text)) {
//                return -1;
//            }
//            if (stack.isEmpty())
//                return 0;
//            Character current_in_stack = stack.pop();
//            if (terminals.contains(current_in_stack)) {
//                if (current_in_stack == current_in_text) {
//                    continue;
//                } else {
//                    return 0;
//                }
//            }
//            if (not_terminals.contains(current_in_stack)) {
//                Integer production = lookup_table.get(current_in_stack).get(current_in_text);
//                if (production == -1) {
//                    return 0;
//                }
//                production_sequence.append(production);
//                String line = production_list.get(production);
//                for (int i=line.length()-1;i>=0;i--){
//                    stack.push(line.charAt(i));
//                }
//            }
//        }
        int current_in_text_number = 0;
        while (current_in_text_number < characters.length) {
            Character current_in_text = characters[current_in_text_number];
            if (!terminals.contains(current_in_text)) {
                return -1;
            }
            if (stack.isEmpty()) {
                answer = 0;
                break;
            }
            Character current_in_stack = stack.pop();
            if (terminals.contains(current_in_stack)) {
                if (current_in_stack == current_in_text) {
                    current_in_text_number++;
                    continue;
                } else {
                    answer = 0;
                    break;
                }
            }
            if (not_terminals.contains(current_in_stack)) {
                Integer production = lookup_table.get(current_in_stack).get(current_in_text);
                if (production == -1) {
                    answer = 0;
                    break;
                }
                production_sequence.append(production);
                String line = production_list.get(production);
                for (int i = line.length() - 1; i >= 0; i--) {
                    stack.push(line.charAt(i));
                }
            }
        }
        if (answer == 0) {
            for (int i = 0; i < symbolsLane.length(); i++) {
                if (!terminals.contains(symbolsLane.charAt(i))) {
                    return -1;
                }
            }
            return 0;
        }
        if (stack.isEmpty()) {
            System.out.println("Semantic was: " + production_sequence);
            return 1;
        } else {
            return 0;
        }
    }

}